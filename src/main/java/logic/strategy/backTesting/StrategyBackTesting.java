package logic.strategy.backTesting;

import bean.Stock;
import logic.tools.MathHelper;
import vo.stock.LineVO;
import vo.strategy.StrategyBackTestResultVO;
import vo.strategy.CumulativeYieldResultVO;
import vo.strategy.StrategyTradeRecordVO;
import vo.strategy.YieldHistogramResultVO;

import java.util.ArrayList;

/**
 * 动量策略计算累计收益率
 * Created by Mark.W on 2017/4/4.
 */
public class StrategyBackTesting {

    private StrategyDataAnlysis strategyDataAnlysis = new StrategyDataAnlysis();
    private IStrategy IStrategy;
    private StockPool stockPool;

    private double initFund;        //起始资金
    private double income;           //总本金+收益
    private double lastIncome;       //记录上一个周期的本金+收益，用于计算周期收益率
    private double sellOutMoney;       //每次换仓卖出股票得到的钱

    private int holdingPeriod;       //持有期
    private int returnPeriod;        //形成期
    private int holdingStockNum;      //每个持有期持有的股票数量
    private ArrayList<LogicHoldingStock> holdingStocks;

    private boolean periodOnly;
    private ArrayList<Double> yieldPerPeriod;     //每个持有期结束后的收益率 周期收益率

    private ArrayList<LineVO> strategyYield;  //每天的收益率
    private ArrayList<LineVO> baseYield; //基准收益率
    private StrategyBackTestResultVO strategyBackTestResultVO;

    private ArrayList<StrategyTradeRecordVO> tradeRecords;      //交易记录

    /**
     * @param stockPool 股票池
     * @param holdingPeriod 持有期
     * @param returnPeriod 形成期
     * @param IStrategy 不同策略选择股票的接口
     * @param periodOnly 是否是计算超额收益
     */
    public StrategyBackTesting(StockPool stockPool, int holdingPeriod, int returnPeriod, IStrategy IStrategy, boolean periodOnly) {
        this.stockPool = stockPool;
        this.IStrategy = IStrategy;
        this.returnPeriod = returnPeriod;
        this.holdingPeriod = holdingPeriod;
        this.periodOnly = periodOnly;

        this.initFund = stockPool.getInputVO().getInitFund();
        this.income = initFund;
        this.lastIncome = income;
        this.sellOutMoney = initFund;
        this.holdingStockNum = stockPool.getHoldingStockNum();

        this.holdingStocks = new ArrayList<>();
        this.strategyYield = new ArrayList<>();
        this.baseYield = new ArrayList<>();
        this.yieldPerPeriod = new ArrayList<>();
        this.tradeRecords = new ArrayList<>();
    }

    /**
     *  执行回测的主程序
     */
    public void start() {
        ArrayList<Stock> indexStocks = stockPool.getIndexStocks();
        int startIndex = stockPool.getStartIndex(); //初始化访问股票的下标index

        //如果回测板块，获取板块的基准收益率
        if(stockPool.getStockPoolType() == 0) {
            baseYield = stockPool.getBlockBaseRaito();
        }

        int holdingDaysIndex = holdingPeriod;  //记录是否达到一个holdingPeriod的index
        //循环主体
        for(int i=startIndex; i<indexStocks.size(); ++i) {
System.out.println("mainLoop: " + indexStocks.get(i).getDate());

            int tempIndex = Math.max(i-this.returnPeriod, 0);
            String formerDate = indexStocks.get(tempIndex).getDate();
            String todayTemp = indexStocks.get(i).getDate();

            if(holdingDaysIndex == holdingPeriod) {        //若达到holdingPeriod index置0
                holdingDaysIndex = 0;                      //前一天进行rebalance,买入卖出

                ArrayList<String> datesNextHoldingPeriod = new ArrayList<>();
                int end = Math.min(i+holdingPeriod+1, indexStocks.size());
                for(int j=i-1; j<end; ++j) {
                    datesNextHoldingPeriod.add(indexStocks.get(j).getDate());
                }

                this.rebalance(formerDate,datesNextHoldingPeriod);
            } else {
                holdingDaysIndex ++;
            }

            if(!periodOnly) {
                //每天需要计算的数据
                if(stockPool.getStockPoolType() == 1) {         //如果不是回测板块 则需要计算基准收益率
                    this.calculateBaseYield(todayTemp);         //基准收益率计算 用今日adj
                }
                this.calculateStrategyYield(todayTemp);          //计算收益， 用昨日adj
            }

            if(i == indexStocks.size()-1 && holdingDaysIndex != holdingPeriod) {
                this.sellStock(todayTemp);                       //如果最后剩余的天数不足holdingPeriod，仍然计算周期收益率
                this.calculatePeriodYield();
            }
        }

        if(!periodOnly) {
            this.calculateData();
        }
    }

    /**
     * 一个持有期结束
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * 不同策略确定方法不一样
     * @param dates 下一个持有期的日期 get(0)是today日期
     */
    private void rebalance(String formerDate, ArrayList<String> dates) {
        String yesterday = dates.get(0);
        String today = dates.get(1);
        //计算股票池內所有股票的收益率 用于确定下次持有的股票 不同策略确定方法不一样
        ArrayList<String> rebalancedStockCodes = IStrategy.getRebalancedStockCodes(stockPool, holdingStocks, holdingStockNum,formerDate,dates);

        this.sellStock(yesterday);           //卖出所有持有的且当天没有停盘的股票
        //确定前n的股票 买入
        this.buyStock(rebalancedStockCodes, today);
        this.calculatePeriodYield();                // 计算周期收益率
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum买入
     * @param rebalancedStocks yieldStocks
     * @param date  用于确定特定一天的adj,确定每只股票买多少股
     */
    private void buyStock(ArrayList<String> rebalancedStocks, String date) {
System.out.println("               date:" + date);
System.out.println("               买入前size:" + this.holdingStocks.size());
System.out.println("               rebalancedStocks-size:" + rebalancedStocks.size());

        //买入股票
        double moneyEachStock = sellOutMoney/rebalancedStocks.size();
        for(int i = 0; i< rebalancedStocks.size(); ++ i) {
            Stock stock = this.stockPool.getStockByCodeAndDate(rebalancedStocks.get(i), date);
            if(stock != null) {
                double close = stock.getClose();
                double numOfStock = moneyEachStock/close;
                this.holdingStocks.add(new LogicHoldingStock(rebalancedStocks.get(i), numOfStock));
                this.tradeRecords.add(new StrategyTradeRecordVO(date, stock.getCode(), 0, moneyEachStock, close));
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
        if (this.holdingStocks.size() == 0) {
            return;
        }

        ArrayList<LogicHoldingStock> newHoldingStocks = new ArrayList<>();
        lastIncome = income;
        income = 0;                  //当前本金+收益
        sellOutMoney = 0;            //卖出的股票获得的现金
        for (int i = 0; i < this.holdingStocks.size(); ++i) {
            LogicHoldingStock temp =  this.holdingStocks.get(i);
            double numOfStock = temp.getNumOfStock();
            Stock stock = this.stockPool.getStockByCodeAndDate(temp.getStockCode(), date);

            if (stock != null) {
                double close = this.stockPool.getStockByCodeAndDate(temp.getStockCode(), date).getClose();
                income += numOfStock * close;

                if (!temp.isCanContinueHold()) {            //不能继续持有 卖出股票
                    this.sellOutMoney += numOfStock * close;
                    this.tradeRecords.add(new StrategyTradeRecordVO(date, stock.getCode(), 0, numOfStock * close, close));
                } else {
                    temp.setCanContinueHold(false);
                    newHoldingStocks.add(temp);
                }
            }
        }

        this.holdingStocks = newHoldingStocks;
    }

    /**
     * 计算持有股票每天的收益
     * 并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateStrategyYield(String date) {
        double yield = 0;
        for(int i = 0; i<this.holdingStocks.size(); ++i) {
            Stock stock = stockPool.getStockByCodeAndDate(this.holdingStocks.get(i).getStockCode(), date);

            if(stock != null) {  //如果该天的股票数据没有 暂时放弃该股票
                yield += holdingStocks.get(i).getNumOfStock() * stock.getClose();
            }
        }
        //计算累计收益率
        yield = (yield - initFund)/ initFund;
        this.strategyYield.add(new LineVO(date, MathHelper.formatData(yield,4)));

System.out.println("      holdingStocks-size: " + this.holdingStocks.size());
System.out.println("      IStrategy-Yield:" + yield);
    }

    /**
     * 不是按照板块回测时 计算基准收益率的方法
     * @param date 日期
     */
    private void calculateBaseYield(String date) {
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

        yield = yield/stockNum;
        this.baseYield.add(new LineVO(date, MathHelper.formatData(yield,4)));
    }

    /**
     * 计算每个持有期结束后的收益率
     */
    private void calculatePeriodYield() {
System.out.println("                         前一周期收益：" + lastIncome);
System.out.println("                         当前周期收益：" + income);

        double yield = (income-lastIncome)/ lastIncome;
        this.yieldPerPeriod.add(yield);
    }

    /**
     * 计算分析结果数据, 累计收益率和直方图
     */
    private void calculateData() {
        //计算累计收益率图的有关数据
        CumulativeYieldResultVO cumulativeYields= strategyDataAnlysis.analyseCumulativeYieldGraph(income, initFund, stockPool.getTradeDays(), strategyYield, baseYield);
        //计算有关频率分布直方图的数据
        YieldHistogramResultVO yieldHistograms = strategyDataAnlysis.analyseYieldHistogram(this.yieldPerPeriod);

        this.strategyBackTestResultVO = new StrategyBackTestResultVO(cumulativeYields, yieldHistograms);
    }

    /**
     * 获取超额收益率
     * @return 超额收益率
     */
    public double getAbnormalReturn() {
        double allBaseY;
        if(baseYield.size() == 0) {
            ArrayList<Stock> indexStocks = stockPool.getIndexStocks();
            allBaseY = (indexStocks.get(indexStocks.size()-1).getClose() - indexStocks.get(stockPool.getStartIndex()).getClose())/ indexStocks.get(stockPool.getStartIndex()).getClose();
        } else {
            allBaseY = (baseYield.get(baseYield.size()-1).getValue() - baseYield.get(0).getValue())/baseYield.get(0).getValue();
        }

        double result = strategyDataAnlysis.analyseAbnormalReturn(income, initFund, allBaseY);
        return result;
    }

    /**
     * 获取策略胜率
     * @return 策略胜率
     */
    public double getWinRate() {
        double result = strategyDataAnlysis.analyseWinRate(yieldPerPeriod);
        return result;
    }

    public StrategyBackTestResultVO getStrategyBackTestResultVO() {
        return strategyBackTestResultVO;
    }
}
