package logic.strategy;

import logic.tools.DateHelper;
import logic.tools.MathHelper;
import po.StockPO;
import vo.BackTestingResultVO;
import vo.BaseCumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 动量策略计算累计收益率
 * Created by Mark.W on 2017/4/4.
 */
public class MomentumBackTesting {
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
    private BackTestingResultVO backTestingResultVO;

    public MomentumBackTesting(StockPool stockPool, int holdingPeriod, int returnPeriod, int holdingStockNum) {
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
        int startIndex = this.returnPeriod;

        ArrayList<StockPO> stockPOS = stockPool.getIndexStocks();

        //确定开始日期 stockPOS的index
        for(int i=0; i<stockPOS.size(); ++i) {
            Date d = DateHelper.getInstance().stringTransToDate(stockPOS.get(i).getDate());
            int num = DateHelper.getInstance().calculateDaysBetween(d, stockPool.getStartDate());
            if(num < 0) {
                break;
            }

            if(num == 0) {
                startIndex = i;
            }
        }

        int index = 0;      //记录是否达到一个holdingPeriod的index

        //循环主题
        for(int i=startIndex; i<stockPOS.size(); ++i) {

            Date temp = DateHelper.getInstance().stringTransToDate(stockPOS.get(i).getDate());

            if(index == holdingPeriod) { //若达到holdingPeriod index置0 同时进行rebalance
                index = 0;                  //前一天进行调仓
                this.rebalance(temp);

            } else {
                index ++;
            }

            this.calculateBaseCumlativeYield(temp);         //基准收益率计算 用今日adj
            this.calculateHoldingStockYield(temp);          //计算收益， 用昨日adj
        }

//        if(index > 0 && index < holdingPeriod) {
//            this.
//        }

        this.finish();
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
     * 计算持有股票每天的收益，并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateHoldingStockYield(Date date) {
        double yield = 0;

        for(int i = 0; i<this.holdingStocks.size(); ++i) {
            StockPO stockPO = stockPool.findSpecificStock(this.holdingStocks.get(i).getStockCode(), date);

            if(stockPO == null) {  //如果该天的股票数据没有 暂时放弃该股票
                continue;
            }

            yield += this.holdingStocks.get(i).getNumOfStock() * stockPO.getADJ();
        }

        //计算累计收益率
        yield = (yield-this.INIT_FUND)/this.INIT_FUND;

        this.cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(date, yield));
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

        this.initTopNStocks(stockYields, oneDayBeforeDate);

    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum作为持有的股票
     * @param stockYields stockYields
     * @param date  用于确定特定一天的adj， 确定每只股票买多少股
     */
    private void initTopNStocks(ArrayList<StockYield> stockYields, Date date) {
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

        //买入股票
        double moneyEachStock = income/this.holdingStockNum;
        for(int i=0; i<holdingStockNum; ++ i) {
            if(this.holdingStocks.size() < this.holdingStockNum) {
                double adj = this.stockPool.findSpecificStock(stockYields.get(i).getStockCode(), date).getADJ();
                double numOfStock = moneyEachStock/adj;

                this.holdingStocks.add(new HoldingStock(stockYields.get(i).getStockCode(), numOfStock));
            }
        }
    }

    /**
     * 卖出股票
     * @param date 指定日期
     */
    private void sellStock(Date date) {
        income = 0;

        ArrayList<HoldingStock> temp = new ArrayList<>();

        for(int i=0; i<this.holdingStocks.size(); ++i) {
            double numOfStock = this.holdingStocks.get(i).getNumOfStock();
            StockPO stockPO = this.stockPool.findSpecificStock(this.holdingStocks.get(i).getStockCode(), date);

            if(stockPO != null) {
                double adj = this.stockPool.findSpecificStock(this.holdingStocks.get(i).getStockCode(), date).getADJ();
                income += numOfStock*adj;
            } else {
                temp.add(this.holdingStocks.get(i));
            }
        }

        this.holdingStocks.clear();

        if(temp.size() != 0) {
            for(int i=0; i<temp.size(); ++i) {
                this.holdingStocks.add(temp.get(i));
            }
        }
    }


    /**
     * 计算累计收益率图的分析结果数据
     */
    private void finish() {

        double annualRevenue = calculateAnnualRevenue();       //策略年化收益率
        double baseAnnualRevenue = calculateBaseAnnualRevenue();  //基准年化收益率\
        double beta = calculateBeta();
        double alpha = calculateAlpha(annualRevenue, baseAnnualRevenue, beta);
        double sharpeRatio = calculateSharpRatio(annualRevenue);  //夏普比率
        double maxDrawdown = calculateMaxDrawdown();  //最大回撤

        this.cumulativeYieldGraphVO = new CumulativeYieldGraphVO(annualRevenue,baseAnnualRevenue,
                alpha, beta,sharpeRatio, maxDrawdown,cumulativeYieldGraphDataVOS, baseCumulativeYieldGraphDataVOS);

    }

    /**
     * 计算策略年化收益率
     * @return 策略年化收益率
     */
    private double calculateAnnualRevenue() {
        double annualRevenue = 0;
        return annualRevenue;
    }


    /**
     * 计算alpha
     * @param annualRevenue 年化收益率
     * @param baseAnnualRevenue 基准收益率
     * @param beta beta
     * @return
     */
    private double calculateAlpha(double annualRevenue, double baseAnnualRevenue, double beta) {
        double rf = 0.0175;
        double alpha = annualRevenue - rf - beta * (baseAnnualRevenue - rf);
        return alpha;
    }

    /**
     * 计算夏普比率
     * @return 夏普比率
     */
    private double calculateSharpRatio(double annualRevenue) {
        double rf = 0.0175;
        double[] strategy = new double[this.cumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<this.cumulativeYieldGraphDataVOS.size(); ++i) {
            strategy[i] = this.cumulativeYieldGraphDataVOS.get(i).ratio;
        }

        double sharpeRatio = (annualRevenue - rf)/Math.sqrt(MathHelper.variance(strategy));

        return sharpeRatio;
    }

    /**
     * 计算beta
     * @return beta
     */
    private double calculateBeta() {
        double[] strategy = new double[this.cumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<this.cumulativeYieldGraphDataVOS.size(); ++i) {
            strategy[i] = this.cumulativeYieldGraphDataVOS.get(i).ratio;
        }

        double[] base = new double[this.baseCumulativeYieldGraphDataVOS.size()];
        for(int i=0; i<this.baseCumulativeYieldGraphDataVOS.size(); ++i) {
            base[i] = this.baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }

        double beta = MathHelper.covariance(strategy, base)/MathHelper.variance(base);

        return beta;
    }


    /**
     * 计算基准年化收益率
     * @return 基准年化收益率
     */
    private double calculateBaseAnnualRevenue() {
        double baseAnnualRevenue = 0;
        for(int i=1; i<this.baseCumulativeYieldGraphDataVOS.size(); ++i) {
            baseAnnualRevenue += this.baseCumulativeYieldGraphDataVOS.get(i).baseRatio;
        }
        baseAnnualRevenue /= this.baseCumulativeYieldGraphDataVOS.size();

        return baseAnnualRevenue;
    }

    /**
     * 计算最大回撤
     * @return 最大回撤
     */
    private double calculateMaxDrawdown() {
        double maxDrawdown = 0;

        double start = this.cumulativeYieldGraphDataVOS.get(0).ratio, end = start;

        for(int i=1; i<this.cumulativeYieldGraphDataVOS.size(); ++i) {
            //折线在上升
            if(cumulativeYieldGraphDataVOS.get(i).ratio > cumulativeYieldGraphDataVOS.get(i-1).ratio) {
                start = cumulativeYieldGraphDataVOS.get(i).ratio;
            }

            //折线在上升折线在下降
            if(cumulativeYieldGraphDataVOS.get(i).ratio < cumulativeYieldGraphDataVOS.get(i-1).ratio) {
                end = cumulativeYieldGraphDataVOS.get(i).ratio;
            }

            if((start-end) > maxDrawdown) {
                maxDrawdown = start-end;
            }
        }

        return maxDrawdown;
    }

    public BackTestingResultVO getBackTestingResultVO() {
        return backTestingResultVO;
    }
}
