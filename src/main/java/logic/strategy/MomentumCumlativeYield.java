package logic.strategy;

import logic.tools.DateHelper;
import po.StockPO;
import vo.BaseCumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 动量策略计算累计收益率
 * Created by Mark.W on 2017/4/4.
 */
public class MomentumCumlativeYield {
    private StockPool stockPool;

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量

    private ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;  //每天的收益率
    private ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率
    private ArrayList<String> holdingStockCodes;

    private double capital;     //本金
    private double income;      //总收益
    private CumulativeYieldGraphVO cumulativeYieldGraphVO;

    public MomentumCumlativeYield(StockPool stockPool, int holdingPeriod, int returnPeriod, int holdingStockNum) {
        this.stockPool = stockPool;

        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;

        this.cumulativeYieldGraphDataVOS = new ArrayList<>();
        this.holdingStockCodes = new ArrayList<>();
        this.baseCumulativeYieldGraphDataVOS = new ArrayList<>();
    }

    /**
     *  执行回测的主程序
     */
    public void start() {
        this.initHoldingStockOnfirstRun();

        Date temp = stockPool.getStartDate();
        int index = 0;     //记录是否达到一个holdingPeriod的index

        while(!DateHelper.getInstance().dateTransToString(temp).equals(DateHelper.getInstance().dateTransToString(stockPool.getEndDate()))) {
            if(index == holdingPeriod) { //若达到holdingPeriod index置0 同时进行rebalance
                index = 0;
                this.rebalance(temp);

            } else {
                index ++;
            }

            this.calculateHoldingStockYield(temp); //计算收益
            temp = DateHelper.getInstance().nextTradeDay(temp);
        }

        this.calculateData();

    }

    /**
     * 在第一次运行时 确定持有的股票
     */
    public void initHoldingStockOnfirstRun() {
        ArrayList<StockYield> stockYields = new ArrayList<>();

        for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
            StockPO before = stockPool.getStockInfos().get(i).getBeforeStockPO();
            StockPO yesterday = stockPool.getStockInfos().get(i).getStockByDate(DateHelper.getInstance().formerTradeDay(stockPool.getStartDate()));

            if(yesterday == null || before == null) {
                continue;
            }

            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        this.initTopNStocks(stockYields);
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum作为持有的股票
     * @param stockYields stockYields
     */
    public void initTopNStocks(ArrayList<StockYield> stockYields) {
        //冒泡排序 排序holdingStockNum次 得到收益前holdingStockNum的股票

        for(int i=stockYields.size()-1;i>stockYields.size()-holdingStockNum-1; i--) {
            for(int j=0; j<i; ++ j) {
                if(stockYields.get(j).getYield() < stockYields.get(j+1).getYield()) {
                    StockYield temp = stockYields.get(j);
                    stockYields.set(j, new StockYield(stockYields.get(j+1).getStockCode(), stockYields.get(j+1).getYield()));
                    stockYields.set(j+1, temp);
                }
            }
        }

        //确定持有股票的代码
        for(int i=0; i<holdingStockNum; ++i) {
            this.holdingStockCodes.add(stockYields.get(i).getStockCode());
        }
    }

    /**
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * @param date 日期
     */
    public void rebalance(Date date) {
        ArrayList<StockYield> stockYields = new ArrayList<>();

        Date beforeDate = DateHelper.getInstance().formerNTradeDay(date, returnPeriod);

        for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
            StockPO before = stockPool.getStockInfos().get(i).getStockByDate(beforeDate);
            StockPO yesterday = stockPool.getStockInfos().get(i).getStockByDate(DateHelper.getInstance().formerTradeDay(date));

            if(yesterday == null || before == null) {
                continue;
            }

            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        this.initTopNStocks(stockYields);

    }

    /**
     * 计算持有股票每天的收益，并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    public void calculateHoldingStockYield(Date date) {
        int yieldNum = 0; //计算该日期有多少未停牌，用于计算平均值
        double yield = 0;

        for(int i=0; i<this.holdingStockCodes.size(); ++i) {
            StockPO stockPO = stockPool.findSpecificStock(this.holdingStockCodes.get(i), date);
            StockPO startDatePO = stockPool.findStartDateStock(this.holdingStockCodes.get(i));

            if(stockPO == null || startDatePO == null) {
                continue;
            }

            yieldNum ++;

            //计算累计收益率
            yield += (stockPO.getADJ()-startDatePO.getADJ())/startDatePO.getADJ();
        }

        this.cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(date,yield/yieldNum));

    }

    /**
     * 计算累计收益率图的分析结果数据
     */
    private void calculateData() {

        double annualRevenue = 0;       //年化收益率
        double baseAnnualRevenue = 0;  //基准年化收益率
        double alpha = 0;
        double beta = 0;
        double sharpeRatio = 0;  //夏普比率
        double maxDrawdown = 0;  //最大回撤

        //这里添加计算计算上述六个数据的代码



        this.cumulativeYieldGraphVO = new CumulativeYieldGraphVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,cumulativeYieldGraphDataVOS, baseCumulativeYieldGraphDataVOS);

    }

    public CumulativeYieldGraphVO getCumulativeYieldGraphVO() {
        return cumulativeYieldGraphVO;
    }
}
