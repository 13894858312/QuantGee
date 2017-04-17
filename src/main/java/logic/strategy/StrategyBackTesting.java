package logic.strategy;

import logic.tools.DateHelper;
import logic.tools.MathHelper;
import po.StockPO;
import vo.*;

import java.util.ArrayList;

/**
 * 动量策略计算累计收益率
 * Created by Mark.W on 2017/4/4.
 */
public class StrategyBackTesting {
    private static final double INIT_FUND = 100000; //起始资金
    private double income = INIT_FUND;      //总本金+收益
    private double tempIncome = income;  //记录上一个周期的本金+收益，用于计算周期收益率

    private double allBaseY;   //总的基准收益率
    private boolean periodOnly;
    private BlockType blockType;

    private Strategy strategy;
    private StockPool stockPool;

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量
    private ArrayList<HoldingStock> holdingStocks;

    private ArrayList<CumulativeYieldGraphDataVO> strategyYield;  //每天的收益率
    private ArrayList<CumulativeYieldGraphDataVO> baseYield; //基准收益率
    private ArrayList<Double> yieldPerPeriod;     //每个持有期结束后的收益率  周期收益率
    private BackTestingResultVO backTestingResultVO;

    /**
     * @param stockPool 股票池
     * @param holdingPeriod 持有期
     * @param returnPeriod 形成期
     * @param strategy 不同策略选择股票的接口
     */
    public StrategyBackTesting(StockPool stockPool, int holdingPeriod, int returnPeriod, Strategy strategy, boolean periodOnly) {
        this.stockPool = stockPool;
        this.strategy = strategy;
        this.periodOnly = periodOnly;

        this.blockType = stockPool.getBlockType();
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.holdingStockNum = stockPool.getHoldingStockNum();

        this.holdingStocks = new ArrayList<>();
        this.strategyYield = new ArrayList<>();
        this.baseYield = new ArrayList<>();
        this.yieldPerPeriod = new ArrayList<>();
    }

    /**
     *  执行回测的主程序
     */
    public void start() {

        //如果回测板块，获取板块的基准收益率
        if (blockType != null) {
            this.baseYield = stockPool.getBlockBaseRaito();
        }


        ArrayList<StockPO> indexStocks = stockPool.getIndexStocks();
        int startIndex = stockPool.getStartIndex(); //初始化访问股票的下标index
        int index = 0;  //记录是否达到一个holdingPeriod的index
        this.initHoldingStocks(indexStocks.get(startIndex+1).getDate());

        this.allBaseY = (indexStocks.get(0).getADJ()-indexStocks.get(startIndex).getADJ())/indexStocks.get(0).getADJ();

        //循环主体 最早的时间在前面 所以倒序访问
        for(int i=startIndex; i>=0; i--) {

System.out.println("here: " + indexStocks.get(i).getDate());

            String dateTemp = indexStocks.get(i).getDate();
            if(index == holdingPeriod) { //若达到holdingPeriod index置0
                index = 0;               //前一天进行rebalance,买入卖出

                String d1;
                if(i+this.returnPeriod >= indexStocks.size()) {
                    d1 = indexStocks.get(indexStocks.size()-1).getDate();
                } else {
                    d1 = indexStocks.get(i+this.returnPeriod).getDate();
                }

                String d2 = indexStocks.get(i).getDate();
                this.rebalance(d1,d2);
            } else {
                index ++;
            }

            if(!periodOnly) {
                //每天需要计算的数据
                if(blockType == null) {                             //如果不是回测板块 则需要计算基准收益率
                    this.calculateBaseYield(dateTemp);         //基准收益率计算 用今日adj
                }
                this.calculateStrategyYield(dateTemp);          //计算收益， 用昨日adj
            }


            if(i == 0 && index != holdingPeriod) {
                this.sellStock(dateTemp);                       //如果最后剩余的天数不足holdingPeriod，仍然计算周期收益率
                this.calculatePeriodYield();
            }
        }

        if(!periodOnly) {
            this.finish();
        }
    }

    /**
     * 在第一次运行时 确定持有的股票
     * 不同策略确定方法不一样
     * @param oneDayBeforeFirstDay 在开始日期的前一个交易日买入股票
     */
    private void initHoldingStocks(String oneDayBeforeFirstDay) {
        //不同策略确定方法不一样
        ArrayList<StockYield> stockYields = strategy.initHoldingStocks(stockPool);

        //在开始日期的前一个交易日买入股票
        this.buyStock(stockYields, oneDayBeforeFirstDay);
    }

    /**
     * 计算基准收益率
     * @param date 日期
     */
    private void calculateBaseYield(String date) {

        //不是按照板块回测
        int stockNum = 0;           //用于求平均
        double yield = 0;           //收益率

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            StockPO firstDay = stockPool.getStocksList().get(i).getStartDateStockPO();
            StockPO today = stockPool.getStocksList().get(i).getStockByDate(date);

            if(firstDay != null && today != null) {
                //计算基准累计收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
                yield += (today.getADJ()-firstDay.getADJ())/firstDay.getADJ();
                stockNum ++;
            }
        }
System.out.println(stockPool.getStocksList().get(0).getStartDateStockPO() == null);
System.out.println(stockPool.getStocksList().get(0).getStockByDate(date) == null);
System.out.println(stockNum);

        yield = yield/stockNum;
        this.baseYield.add(new CumulativeYieldGraphDataVO(DateHelper.getInstance().stringTransToDate(date),
                MathHelper.formatData(yield,4)));
    }

    /**
     * 计算持有股票每天的收益
     * 并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateStrategyYield(String date) {

System.out.println("holdingStocks-size: " + this.holdingStocks.size());

        double yield = 0;
        for(int i = 0; i<this.holdingStocks.size(); ++i) {
            StockPO stockPO = stockPool.getStockByCodeAndDate(this.holdingStocks.get(i).getStockCode(), date);

            if(stockPO != null) {  //如果该天的股票数据没有 暂时放弃该股票
                yield += holdingStocks.get(i).getNumOfStock() * stockPO.getADJ();
            }
        }

        //计算累计收益率
        yield = (yield - INIT_FUND)/INIT_FUND;

System.out.println("strategy-Yield:" + yield);

        this.strategyYield.add(new CumulativeYieldGraphDataVO(DateHelper.getInstance().stringTransToDate(date),
                MathHelper.formatData(yield,4)));
    }

    /**
     * 一个持有期结束
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * 不同策略确定方法不一样
     * @param beforeDate 形成期前的日期
     * @param oneDayBeforeDate 调仓日期的前一天（用前一天的收盘价进行陶仓操作）
     */
    private void rebalance(String beforeDate, String oneDayBeforeDate) {
        this.sellStock(oneDayBeforeDate);           //卖出所有持有的且当天没有停盘的股票
        this.calculatePeriodYield();                //计算周期收益率

        //计算股票池內所有股票的收益率 用于确定下次持有的股票
        // 不同策略确定方法不一样
        ArrayList<StockYield> stockYields = strategy.rebalanceHoldingStocks(stockPool, beforeDate, oneDayBeforeDate);

        //确定前n的股票 买入
        this.buyStock(stockYields, oneDayBeforeDate);
    }

    /**
     * 计算每个持有期结束后的收益率
     */
    private void calculatePeriodYield() {
System.out.println("               前一周期收益：" + tempIncome);
System.out.println("               当前周期收益：" + income);

        double yield = (income-tempIncome)/tempIncome;
        this.yieldPerPeriod.add(yield);
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum买入
     * @param stockYields stockYields
     * @param date  用于确定特定一天的adj， 确定每只股票买多少股
     */
    private void buyStock(ArrayList<StockYield> stockYields, String date) {

        //冒泡排序 排序holdingStockNum次 得到收益前holdingStockNum的股票
        for(int i=0; i<holdingStockNum; ++i) {
            for(int j=stockYields.size()-1; j>i; j--) {
                if(stockYields.get(j).getYield() > stockYields.get(j-1).getYield()) {
                    StockYield temp = stockYields.get(j);
                    stockYields.set(j, new StockYield(stockYields.get(j-1).getStockCode(), stockYields.get(j-1).getYield()));
                    stockYields.set(j-1, temp);
                }
            }
        }

System.out.println("               买入前size:" + this.holdingStocks.size());
System.out.println(stockYields.size());

        //买入股票
        double moneyEachStock = income/this.holdingStockNum;
        for(int i=0; i<stockYields.size(); ++ i) {

            StockPO stockPO = this.stockPool.getStockByCodeAndDate(stockYields.get(i).getStockCode(), date);

            if(stockPO != null) {
                double adj = stockPO.getADJ();
                double numOfStock = moneyEachStock/adj;
                this.holdingStocks.add(new HoldingStock(stockYields.get(i).getStockCode(), numOfStock));
            }

            if(this.holdingStocks.size() >= this.holdingStockNum) { //持有数量只能为holdingStockNum
                break;
            }
        }

System.out.println("               买入后size:" + this.holdingStocks.size());
    }

    /**
     * 卖出股票
     * @param date 指定日期
     */
    private void sellStock(String date) {
        tempIncome  = income;
        income = 0;  //当前本金+收益

        ArrayList<HoldingStock> temp = new ArrayList<>();

        for (int i = 0; i < this.holdingStocks.size(); ++i) {
            double numOfStock = this.holdingStocks.get(i).getNumOfStock();
            StockPO stockPO = this.stockPool.getStockByCodeAndDate(this.holdingStocks.get(i).getStockCode(), date);

            if (stockPO != null) {
                double adj = this.stockPool.getStockByCodeAndDate(this.holdingStocks.get(i).getStockCode(), date).getADJ();
                income += numOfStock * adj;
            } else {                    //如果当天股票停盘 继续持有该股票，不卖出
                temp.add(this.holdingStocks.get(i));
            }
        }

        this.holdingStocks.clear();

        if (temp.size() != 0) {
            for (int i = 0; i < temp.size(); ++i) {
                this.holdingStocks.add(temp.get(i));
            }
        }
    }

    /**
     * 计算分析结果数据, 累计收益率和直方图
     */
    private void finish() {
        StrategyDataAnlysis analysis = new StrategyDataAnlysis();

        //计算累计收益率图的有关数据
        CumulativeYieldGraphVO cumulativeYieldGraphVO = analysis.analyseCumulativeYieldGraph(income, INIT_FUND, stockPool.getTradeDays(),
                strategyYield, baseYield);

        //计算有关频率分布直方图的数据
        YieldHistogramGraphVO yieldHistogramGraphVO = analysis.analyseYieldHistogram(this.yieldPerPeriod);

        this.backTestingResultVO = new BackTestingResultVO(cumulativeYieldGraphVO,yieldHistogramGraphVO);
    }


    /**
     * 获取超额收益率
     * @return 超额收益率
     */
    public double getAbnormalReturn() {
        double result = new StrategyDataAnlysis().analyseAbnormalReturn(income, INIT_FUND, allBaseY);
        return result;
    }

    /**
     * 获取策略胜率
     * @return 策略胜率
     */
    public double getWinRate() {
        double result = new StrategyDataAnlysis().analyseWinRate(yieldPerPeriod);
        return result;
    }

    public BackTestingResultVO getBackTestingResultVO() {
        return backTestingResultVO;
    }
}
