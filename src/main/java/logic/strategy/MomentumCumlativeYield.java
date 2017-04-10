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
    private final double INIT_FUND = 1000; //起始资金
    private double income = INIT_FUND;      //总收益

    private StockPool stockPool;

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量

    private ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;  //每天的收益率
    private ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率
    private ArrayList<HoldingStock> holdingStocks;

    private CumulativeYieldGraphVO cumulativeYieldGraphVO;


    public MomentumCumlativeYield(StockPool stockPool, int holdingPeriod, int returnPeriod, int holdingStockNum) {
        this.stockPool = stockPool;

        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = holdingStockNum;

        this.cumulativeYieldGraphDataVOS = new ArrayList<>();
        this.holdingStocks = new ArrayList<>();
        this.baseCumulativeYieldGraphDataVOS = new ArrayList<>();
    }

    /**
     *  执行回测的主程序
     */
    public void start() {
        this.initHoldingStockOnfirstRun();

        Date temp = stockPool.getStartDate();
        int index = 0;      //记录是否达到一个holdingPeriod的index

        while(!DateHelper.getInstance().dateTransToString(temp).equals(DateHelper.getInstance().dateTransToString(stockPool.getEndDate()))) {
            if(index == holdingPeriod) { //若达到holdingPeriod index置0 同时进行rebalance
                index = 0;
                this.rebalance(temp);

            } else {
                index ++;
            }

            this.calculateBaseCumlativeYield(temp);         //基准收益率计算 用今日adj
            this.calculateHoldingStockYield(temp);          //计算收益， 用昨日adj

            temp = DateHelper.getInstance().nextTradeDay(temp);     //暂时没考虑节假日
        }

        this.calculateData();

    }

    /**
     * 计算基准收益率
     * @param date 日期
     */
    private void calculateBaseCumlativeYield(Date date) {
        int stockNum = 0;
        double yield = 0;
        for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
            StockPO firstDay = stockPool.getStockInfos().get(i).getStartDateStockPO();
            StockPO today = stockPool.getStockInfos().get(i).getStockByDate(date);

            if(firstDay == null || today == null) {
                continue;
            }
            //计算基准累计收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            yield += (today.getADJ()-firstDay.getADJ())/firstDay.getADJ();
            stockNum ++;
        }

        yield /= stockNum;

        this.baseCumulativeYieldGraphDataVOS.add(new BaseCumulativeYieldGraphDataVO(date, yield));
    }

    /**
     * 在第一次运行时 确定持有的股票
     */
    private void initHoldingStockOnfirstRun() {
        ArrayList<StockYield> stockYields = new ArrayList<>();

        for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
            StockPO before = stockPool.getStockInfos().get(i).getBeforeStockPO();
            StockPO yesterday = stockPool.getStockInfos().get(i).getYesterdayStock();

            if(yesterday == null || before == null) {
                continue;
            }


            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        Date date = DateHelper.getInstance().formerTradeDay(this.stockPool.getStartDate());
        this.initTopNStocks(stockYields, date);
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum作为持有的股票
     * @param stockYields stockYields
     * @param date  用于确定特定一天的adj， 确定每只股票买多少股
     */
    private void initTopNStocks(ArrayList<StockYield> stockYields, Date date) {
        //冒泡排序 排序holdingStockNum次 得到收益前holdingStockNum的股票

        double moneyEachStock = income/this.holdingStockNum;

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

            double adj = this.stockPool.findSpecificStock(holdingStocks.get(i).getStockCode(), date).getADJ();
            double numOfStock = moneyEachStock/adj;

            this.holdingStocks.add(new HoldingStock(stockYields.get(i).getStockCode(), numOfStock));
        }
    }

    /**
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * @param date 该日期的前一天的收盘价用于计算
     */
    private void rebalance(Date date) {

        Date oneDayBeforeDate = DateHelper.getInstance().formerTradeDay(date);     //该日期的前一天的收盘价用于计算
        Date beforeDate = DateHelper.getInstance().formerNTradeDay(date, returnPeriod);

        this.sellStock(oneDayBeforeDate);

        ArrayList<StockYield> stockYields = new ArrayList<>();

        for(int i=0; i<stockPool.getStockInfos().size(); ++i) {
            StockPO before = stockPool.getStockInfos().get(i).getStockByDate(beforeDate);
            StockPO yesterday = stockPool.getStockInfos().get(i).getStockByDate(oneDayBeforeDate);

            if(yesterday == null || before == null) {
                continue;
            }

            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        this.initTopNStocks(stockYields, date);

    }

    /**
     * 卖出股票
     * @param date 指定日期
     */
    private void sellStock(Date date) {
        income = 0;

        for(int i=0; i<this.holdingStocks.size(); ++i) {
            double numOfStock = this.holdingStocks.get(i).getNumOfStock();
            double adj = this.stockPool.findSpecificStock(this.holdingStocks.get(i).getStockCode(), date).getADJ();
            income += numOfStock*adj;
        }
    }


    /**
     * 计算持有股票每天的收益，并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateHoldingStockYield(Date date) {
        double yield = 0;

        for(int i = 0; i<this.holdingStocks.size(); ++i) {
            StockPO stockPO = stockPool.findSpecificStock(this.holdingStocks.get(i).getStockCode(), date);

            if(stockPO == null) {
                continue;
            }

            //计算累计收益率
            yield += this.holdingStocks.get(i).getNumOfStock() * stockPO.getADJ();
        }

        yield = (yield-this.INIT_FUND)/this.INIT_FUND;

        this.cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(date, yield));
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
