package logic.strategy.backTesting;

import bean.Stock;
import logic.tools.MathHelper;
import vo.stock.LineVO;
import vo.strategy.StrategyBackTestResultVO;
import vo.strategy.CumulativeYieldResultVO;
import vo.strategy.YieldHistogramResultVO;

import java.util.ArrayList;

/**
 * 动量策略计算累计收益率
 * Created by Mark.W on 2017/4/4.
 */
public class StrategyBackTesting {
    private double INIT_FUND = 100000; //起始资金
    private double income = INIT_FUND;      //总本金+收益
    private double tempIncome = income;  //记录上一个周期的本金+收益，用于计算周期收益率

    private double allBaseY;   //总的基准收益率
    private boolean periodOnly;
    private String blockType;

    private IStrategy IStrategy;
    private StockPool stockPool;

    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量
    private ArrayList<LogicHoldingStock> logicHoldingStocks;

    private ArrayList<LineVO> strategyYield;  //每天的收益率
    private ArrayList<LineVO> baseYield; //基准收益率
    private ArrayList<Double> yieldPerPeriod;     //每个持有期结束后的收益率  周期收益率
    private StrategyBackTestResultVO strategyBackTestResultVO;

    /**
     * @param stockPool 股票池
     * @param holdingPeriod 持有期
     * @param returnPeriod 形成期
     * @param IStrategy 不同策略选择股票的接口
     */
    public StrategyBackTesting(StockPool stockPool, int holdingPeriod, int returnPeriod, IStrategy IStrategy, boolean periodOnly) {
        this.stockPool = stockPool;
        this.IStrategy = IStrategy;
        this.periodOnly = periodOnly;
        this.returnPeriod = returnPeriod;
        this.holdingPeriod = holdingPeriod;

        this.blockType = stockPool.getInputVO().getBlockType();
        this.holdingStockNum = stockPool.getHoldingStockNum();

        this.logicHoldingStocks = new ArrayList<>();
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
            baseYield = stockPool.getBlockBaseRaito();
        }

        ArrayList<Stock> indexStocks = stockPool.getIndexStocks();

        int startIndex = stockPool.getStartIndex(); //初始化访问股票的下标index
        int index = 0;  //记录是否达到一个holdingPeriod的index

        ArrayList<String> dates = new ArrayList<>();
        int temp = Math.min(startIndex+1+holdingPeriod+1, indexStocks.size());
        for(int j=startIndex-1; j<temp; ++j) {         //持有期內每天的股票信息必须有 否则不持有该股票
            dates.add(indexStocks.get(j).getDate());
        }
        this.initHoldingStocks(dates);

        if(blockType == null) {
            this.allBaseY = (indexStocks.get(indexStocks.size()-1).getClose()-indexStocks.get(startIndex).getClose())/indexStocks.get(startIndex).getClose();
        } else {
            this.allBaseY = (baseYield.get(baseYield.size()-1).getValue() - baseYield.get(0).getValue())/baseYield.get(0).getValue();
        }


        //循环主体
        for(int i=startIndex; i<indexStocks.size(); ++i) {

System.out.println("mainLoop: " + indexStocks.get(i).getDate());

            String dateTemp = indexStocks.get(i).getDate();
            if(index == holdingPeriod) {        //若达到holdingPeriod index置0
                index = 0;                      //前一天进行rebalance,买入卖出

                int tempIndex = Math.max(i-this.returnPeriod, 0);
                String d1 = indexStocks.get(tempIndex).getDate();
                String d2 = indexStocks.get(i).getDate();

                ArrayList<String> datesNextHoldingPeriod = new ArrayList<>();
                int t = Math.min(i+holdingPeriod+1, indexStocks.size());
                for(int j=i; j<t; ++j) {
                    datesNextHoldingPeriod.add(indexStocks.get(j).getDate());
                }

                this.rebalance(d1, d2, datesNextHoldingPeriod);

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


            if(i == indexStocks.size()-1 && index != holdingPeriod) {
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
     * @param dates 下一个持有期的日期
     */
    private void initHoldingStocks(ArrayList<String> dates) {

        String date = dates.get(0);
        dates.remove(0);
        //不同策略确定方法不一样
        ArrayList<StockYield> stockYields = IStrategy.initHoldingStocks(stockPool, dates);

        //在开始日期的前一个交易日买入股票
        this.buyStock(stockYields, date);
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
            Stock firstDay = stockPool.getStocksList().get(i).getStartDateStockPO();
            Stock today = stockPool.getStocksList().get(i).getStockByDate(date);

            if(firstDay != null && today != null) {
                //计算基准累计收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
                yield += (today.getClose()-firstDay.getClose())/firstDay.getClose();
                stockNum ++;
            }
        }
System.out.println("  stockNum " + stockNum);

        yield = yield/stockNum;
        this.baseYield.add(new LineVO(date, MathHelper.formatData(yield,4)));
    }

    /**
     * 计算持有股票每天的收益
     * 并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateStrategyYield(String date) {

System.out.println("      logicHoldingStocks-size: " + this.logicHoldingStocks.size());

        double yield = 0;
        for(int i = 0; i<this.logicHoldingStocks.size(); ++i) {
            Stock stock = stockPool.getStockPOByCodeAndDate(this.logicHoldingStocks.get(i).getStockCode(), date);

            if(stock != null) {  //如果该天的股票数据没有 暂时放弃该股票
                yield += logicHoldingStocks.get(i).getNumOfStock() * stock.getClose();
            }
        }

System.out.println("      IStrategy-income:" + yield);

        //计算累计收益率
        yield = (yield - INIT_FUND)/INIT_FUND;

System.out.println("      IStrategy-Yield:" + yield);

        this.strategyYield.add(new LineVO(date, MathHelper.formatData(yield,4)));
    }

    /**
     * 一个持有期结束
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * 不同策略确定方法不一样
     * @param beforeDate 形成期前的日期
     * @param oneDayBeforeDate 调仓日期的前一天（用前一天的收盘价进行陶仓操作）
     * @param dates 下一个持有期的日期
     */
    private void rebalance(String beforeDate, String oneDayBeforeDate, ArrayList<String> dates) {
        this.sellStock(oneDayBeforeDate);           //卖出所有持有的且当天没有停盘的股票
        this.calculatePeriodYield();                //计算周期收益率

        //计算股票池內所有股票的收益率 用于确定下次持有的股票
        // 不同策略确定方法不一样
        ArrayList<StockYield> stockYields = IStrategy.rebalanceHoldingStocks(stockPool, beforeDate, oneDayBeforeDate, dates);

        //确定前n的股票 买入
        this.buyStock(stockYields, oneDayBeforeDate);
    }

    /**
     * 计算每个持有期结束后的收益率
     */
    private void calculatePeriodYield() {
System.out.println("                         前一周期收益：" + tempIncome);
System.out.println("                         当前周期收益：" + income);

        double yield = (income-tempIncome)/tempIncome;
        this.yieldPerPeriod.add(yield);
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum买入
     * @param stockYields stockYields
     * @param date  用于确定特定一天的adj,确定每只股票买多少股
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


System.out.println("               date:" + date);
System.out.println("               买入前size:" + this.logicHoldingStocks.size());
System.out.println("               StockYield-size:" + stockYields.size());

        //买入股票
        double moneyEachStock = income/this.holdingStockNum;
        for(int i=0; i<stockYields.size(); ++ i) {

            Stock stock = this.stockPool.getStockPOByCodeAndDate(stockYields.get(i).getStockCode(), date);

            if(stock != null) {
                double adj = stock.getClose();
                double numOfStock = moneyEachStock/adj;
                this.logicHoldingStocks.add(new LogicHoldingStock(stockYields.get(i).getStockCode(), numOfStock));
            }

            if(this.logicHoldingStocks.size() >= this.holdingStockNum) { //持有数量只能为holdingStockNum
                break;
            }
        }

System.out.println("               买入后size:" + this.logicHoldingStocks.size());
    }

    /**
     * 卖出股票
     * @param date 指定日期
     */
    private void sellStock(String date) {
        tempIncome  = income;
        income = 0;  //当前本金+收益

        for (int i = 0; i < this.logicHoldingStocks.size(); ++i) {
            double numOfStock = this.logicHoldingStocks.get(i).getNumOfStock();
            Stock stock = this.stockPool.getStockPOByCodeAndDate(this.logicHoldingStocks.get(i).getStockCode(), date);

            if (stock != null) {
                double adj = this.stockPool.getStockPOByCodeAndDate(this.logicHoldingStocks.get(i).getStockCode(), date).getClose();
                income += numOfStock * adj;
            }
        }

        this.logicHoldingStocks.clear();

    }

    /**
     * 计算分析结果数据, 累计收益率和直方图
     */
    private void finish() {
        StrategyDataAnlysis analysis = new StrategyDataAnlysis();

        //计算累计收益率图的有关数据
        CumulativeYieldResultVO cumulativeYieldResultVO = analysis.analyseCumulativeYieldGraph(income, INIT_FUND, stockPool.getTradeDays(),
                strategyYield, baseYield);

        //计算有关频率分布直方图的数据
        YieldHistogramResultVO yieldHistogramResultVO = analysis.analyseYieldHistogram(this.yieldPerPeriod);

        this.strategyBackTestResultVO = new StrategyBackTestResultVO(cumulativeYieldResultVO, yieldHistogramResultVO);
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

    public StrategyBackTestResultVO getStrategyBackTestResultVO() {
        return strategyBackTestResultVO;
    }
}
