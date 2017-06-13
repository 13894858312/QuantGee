package logic.strategy.backTesting;

import bean.Stock;
import logic.tools.MathHelper;
import vo.stock.LineVO;
import vo.strategy.StrategyBackTestResultVO;
import vo.strategy.CumulativeYieldResultVO;
import vo.strategy.StrategyTradeRecordVO;
import vo.strategy.YieldHistogramResultVO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 动量策略计算累计收益率
 * Created by Mark.W on 2017/4/4.
 */
public class StrategyBackTesting {

    private StrategyDataAnlysis strategyDataAnlysis = new StrategyDataAnlysis();
    private IStrategy iStrategy;
    private StockPool stockPool;

    private double initFund;        //起始资金
    private double moneyInStock;     //在股票中钱
    private double moneyInHand;       //在股票的中的钱
    private double lastMoneyInStock;
    private double lastMoneyInHand;

    private double stopLoss;          //止损点 输入百分数 如20 30
    private double stopProfit;       //止盈点
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
     * @param iStrategy 不同策略选择股票的接口
     * @param periodOnly 是否是计算超额收益
     */
    public StrategyBackTesting(StockPool stockPool, int holdingPeriod, int returnPeriod, IStrategy iStrategy, boolean periodOnly) {
        this.stockPool = stockPool;
        this.iStrategy = iStrategy;
        this.returnPeriod = returnPeriod;
        this.holdingPeriod = holdingPeriod;
        this.periodOnly = periodOnly;
        this.stopLoss = stockPool.getInputVO().getStopLoss();
        this.stopProfit = stockPool.getInputVO().getStopProfit();
        this.holdingStockNum = stockPool.getHoldingStockNum();

        this.initFund = stockPool.getInputVO().getInitFund();
        this.moneyInStock = 0;
        this.lastMoneyInStock = moneyInStock;
        this.moneyInHand = initFund;
        this.lastMoneyInHand = moneyInHand;

        this.baseYield = stockPool.getBlockBaseRaito();;
        this.holdingStocks = new ArrayList<>();
        this.strategyYield = new ArrayList<>();
        this.yieldPerPeriod = new ArrayList<>();
        this.tradeRecords = new ArrayList<>();
    }

    /**
     *  执行回测的主程序
     */
    public void start() {
        ArrayList<Stock> indexStocks = stockPool.getIndexStocks();
        int startIndex = stockPool.getStartIndex(); //初始化访问股票的下标index

//        //如果回测板块，获取板块的基准收益率
//        if(stockPool.getStockPoolType() == 0) {
//            baseYield = stockPool.getBlockBaseRaito();
//        }

        int holdingDaysIndex = holdingPeriod;  //记录是否达到一个holdingPeriod的index
        //循环主体
        for(int i=startIndex; i<indexStocks.size(); ++i) {
System.out.println("mainLoop: " + indexStocks.get(i).getDate());
            String todayTemp = indexStocks.get(i).getDate();

            this.chechStop(todayTemp);

            if(holdingDaysIndex == holdingPeriod) {        //若达到holdingPeriod index置0
                holdingDaysIndex = 0;                      //前一天进行rebalance,买入卖出

                ArrayList<String> nextDates = new ArrayList<>();
                int end = Math.min(i+holdingPeriod+1, indexStocks.size());
                for(int j=i-1; j<end; ++j) {
                    nextDates.add(indexStocks.get(j).getDate());
                }

                ArrayList<String> formerDates = new ArrayList<>();
                if(iStrategy.getStrategyType() == 4) {
                    int start = Math.max(i-stockPool.getInputVO().getTrainPeriod(), 0);
                    for(int j=start; j<=i; ++j) {
                        formerDates.add(indexStocks.get(j).getDate());
                    }
                }

                int tempIndex = Math.max(i-this.returnPeriod, 0);
                String formerRDate = indexStocks.get(tempIndex).getDate();
                tempIndex = Math.max(i-this.holdingPeriod, 0);
                String formerHDate = indexStocks.get(tempIndex).getDate();

                this.rebalance(formerRDate,formerHDate,nextDates,formerDates);
            } else {
                holdingDaysIndex ++;
            }

            if(!periodOnly) {
//                //每天需要计算的数据
//                if(stockPool.getStockPoolType() == 1) {         //如果不是回测板块 则需要计算基准收益率
//                    this.calculateBaseYield(todayTemp);         //基准收益率计算 用今日adj
//                }
                this.calculateStrategyYield(todayTemp);          //计算收益， 用昨日adj
            }

            if(i == (indexStocks.size()-1) && holdingDaysIndex != holdingPeriod) {
                this.sellStock(todayTemp);                       //如果最后剩余的天数不足holdingPeriod，仍然计算周期收益率
                this.calculatePeriodYield(todayTemp);
            }
        }

        if(!periodOnly) {
            this.calculateData();
        }
    }

    /**
     * 检查止损止盈情况
     * @param date 日期
     */
    private void chechStop(String date) {
        HashMap<String, LogicHoldingStock> hashMapStocks = new HashMap<>();
        ArrayList<String> codes = new ArrayList<>();

        for(int i=0; i<holdingStocks.size(); ++i) {
            hashMapStocks.put(holdingStocks.get(i).getCode(), holdingStocks.get(i));
            double nowMoney, yield;
            Stock stock = stockPool.getStockByCodeAndDate(this.holdingStocks.get(i).getCode(), date);

            if(stock != null) {  //如果该天的股票数据没有 暂时放弃该股票
                nowMoney = holdingStocks.get(i).getNumOfStock() * stock.getClose();
                yield = (nowMoney-holdingStocks.get(i).getMoney())/holdingStocks.get(i).getMoney();

                if (yield >= stopProfit || yield <= stopLoss) {         //卖出股票
                    int sellType;
                    if (yield >= stopProfit) {
                        sellType = 2;
                    } else {
                        sellType = 1;
                    }
                    codes.add(holdingStocks.get(i).getCode());
                    moneyInHand += nowMoney;                             //持有的钱增加
                    this.tradeRecords.add(new StrategyTradeRecordVO(holdingStocks.get(i).getCode(), holdingStocks.get(i).getDate(), date, holdingStocks.get(i).getMoney(), nowMoney, sellType));
                }
            }
        }

        for (int i=0; i<codes.size(); ++i) {                        //卖出股票，将该股票从持有的股票中移除
            holdingStocks.remove(hashMapStocks.get(codes.get(i)));
        }
    }

    /**
     * 一个持有期结束
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * 不同策略确定方法不一样
     * @param formerRDate 上一个形成期的日日期
     * @param formerHDate 上一个持有期的日期
     * @param dates 下一个持有期的日期 get(0)是today日期
     */
    private void rebalance(String formerRDate, String formerHDate, ArrayList<String> dates, ArrayList<String> formerDates) {
        String yesterday = dates.get(0);
        String today = dates.get(1);
        //计算股票池內所有股票的收益率 用于确定下次持有的股票 不同策略确定方法不一样
        ArrayList<String> rebalancedStockCodes = iStrategy.getRebalancedStockCodes(stockPool, holdingStocks, holdingStockNum,formerRDate, formerHDate, dates,formerDates);

        this.sellStock(yesterday);                          //卖出所有持有的且当天没有停盘的股票
        this.buyStock(rebalancedStockCodes, today);         //确定前n的股票 买入
        this.calculatePeriodYield(today);                        // 计算周期收益率

        this.lastMoneyInHand = moneyInHand;                     //每一轮调仓完成，记录上一次的手中持有的钱

System.out.println("                        前一周期moneyInStock:" + lastMoneyInStock + "   前一周期moneyInHand:" + lastMoneyInHand);
System.out.println("                        当前周期moneyInStock:" + moneyInStock + "    当前周期moneyInHand:" + moneyInHand);
    }

    /**
     * 卖出股票
     * @param date 指定日期
     */
    private void sellStock(String date) {
System.out.println("          date:" + date);
System.out.println("          卖出前size:" + this.holdingStocks.size());
System.out.println("          holdingstock-size:" + holdingStocks.size());

        if (this.holdingStocks.size() == 0) {
            return;
        }

        ArrayList<LogicHoldingStock> newHoldingStocks = new ArrayList<>();

        for (int i = 0; i < this.holdingStocks.size(); ++i) {
            LogicHoldingStock temp =  this.holdingStocks.get(i);
            double numOfStock = temp.getNumOfStock();
            Stock stock = this.stockPool.getStockByCodeAndDate(temp.getCode(), date);

            if (stock != null) {
                double close = this.stockPool.getStockByCodeAndDate(temp.getCode(), date).getClose();
                if (!temp.isCanContinueHold()) {            //不能继续持有 卖出股票
                    this.moneyInHand += numOfStock * close;
                    this.tradeRecords.add(new StrategyTradeRecordVO(temp.getCode(), temp.getDate(), date, temp.getMoney(), numOfStock * close, 0));
                } else {                                    //继续持有股票
                    newHoldingStocks.add(temp);
                }
            } else {
                newHoldingStocks.add(temp);
            }
        }
        this.holdingStocks = newHoldingStocks;

System.out.println("          卖出后size:" + this.holdingStocks.size());
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum买入
     * @param rebalancedStocks yieldStocks
     * @param date  用于确定特定一天的adj,确定每只股票买多少股
     */
    private void buyStock(ArrayList<String> rebalancedStocks, String date) {
System.out.println("              date:" + date);
System.out.println("              买入前size:" + this.holdingStocks.size());
System.out.println("              rebalancedStocks-size:" + rebalancedStocks.size());

        if(rebalancedStocks.size() == 0 || moneyInHand == 0) {
            return;
        }

        int codeSize = 0;
        for(int i = 0; i< rebalancedStocks.size(); ++ i) {
            Stock stock = this.stockPool.getStockByCodeAndDate(rebalancedStocks.get(i), date);
            if(stock != null) {
                codeSize ++;
            }
        }

        //买入股票
        double moneyEachStock = moneyInHand/codeSize;
        for(int i = 0; i< rebalancedStocks.size(); ++ i) {
            Stock stock = this.stockPool.getStockByCodeAndDate(rebalancedStocks.get(i), date);
            if(stock != null) {
                double close = stock.getClose();
                double numOfStock = moneyEachStock/close;
                this.holdingStocks.add(new LogicHoldingStock(rebalancedStocks.get(i), date, numOfStock, moneyEachStock));
            }

            if(this.holdingStocks.size() >= this.holdingStockNum) { //持有数量只能为holdingStockNum
                break;
            }
        }
        this.moneyInHand = 0;

System.out.println("              买入后size:" + this.holdingStocks.size());
    }


    /**
     * 计算持有股票每天的收益
     * 并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateStrategyYield(String date) {
        double yield = (getMoneyInStock(date) + moneyInHand - initFund)/ initFund;       //计算累计收益率
        this.strategyYield.add(new LineVO(date, MathHelper.formatData(yield,4)));

System.out.println("      holdingStocks-size: " + this.holdingStocks.size());
System.out.println("      iStrategy-Yield:" + yield);
    }

//    /**
//     * 不是按照板块回测时 计算基准收益率的方法
//     * @param date 日期
//     */
//    private void calculateBaseYield(String date) {
//        int stockNum = 0;           //用于求平均
//        double yield = 0;           //收益率
//
//        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
//            Stock firstDay = stockPool.getStocksList().get(i).getStartDateStock();
//            Stock today = stockPool.getStocksList().get(i).getStockByDate(date);
//
//            if(firstDay != null && today != null) {
//                //计算基准累计收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
//                yield += (today.getClose()-firstDay.getClose())/firstDay.getClose();
//                stockNum ++;
//            }
//        }
//
//        yield = yield/stockNum;
//        this.baseYield.add(new LineVO(date, MathHelper.formatData(yield,4)));
//    }

    /**
     * 计算每个持有期结束后的收益率
     */
    private void calculatePeriodYield(String date) {
        this.lastMoneyInStock = moneyInStock;
        this.moneyInStock = getMoneyInStock(date);

        double yield = ((moneyInStock+moneyInHand) -(lastMoneyInHand+lastMoneyInStock))/ (lastMoneyInHand+lastMoneyInStock);
        this.yieldPerPeriod.add(yield);

System.out.println("                    前一周期收益：" + (lastMoneyInHand+lastMoneyInStock));
System.out.println("                    当前周期收益：" + (moneyInStock+moneyInHand));

System.out.println("                        前一周期moneyInStock:" + lastMoneyInStock + "   前一周期moneyInHand:" + lastMoneyInHand);
System.out.println("                        当前周期moneyInStock:" + moneyInStock + "    当前周期moneyInHand:" + moneyInHand);
    }

    /**
     * 获取当天持有的股票中的钱
     * @param date 日期
     * @return 钱
     */
    private double getMoneyInStock(String date) {
        double money = 0;
        for(int i = 0; i<this.holdingStocks.size(); ++i) {
            Stock stock = stockPool.getStockByCodeAndDate(this.holdingStocks.get(i).getCode(), date);
            if(stock != null) {  //如果该天的股票数据没有 暂时放弃该股票
                money += holdingStocks.get(i).getNumOfStock() * stock.getClose();
            } else {
                money += holdingStocks.get(i).getMoney();
            }
        }
        return money;
    }


    /**
     * 计算分析结果数据, 累计收益率和直方图
     */
    private void calculateData() {
        //计算累计收益率图的有关数据
        CumulativeYieldResultVO cumulativeYields= strategyDataAnlysis.analyseCumulativeYieldGraph(moneyInStock+moneyInHand, initFund, stockPool.getTradeDays(), strategyYield, baseYield);
        //计算有关频率分布直方图的数据
        YieldHistogramResultVO yieldHistograms = strategyDataAnlysis.analyseYieldHistogram(this.yieldPerPeriod);

        this.strategyBackTestResultVO = new StrategyBackTestResultVO(cumulativeYields, yieldHistograms, tradeRecords);
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
            allBaseY = baseYield.get(baseYield.size()-1).getValue() - baseYield.get(0).getValue();
        }

        double result = strategyDataAnlysis.analyseAbnormalReturn(moneyInStock+moneyInHand, initFund, allBaseY);
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
