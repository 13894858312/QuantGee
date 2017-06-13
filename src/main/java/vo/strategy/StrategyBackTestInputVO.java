package vo.strategy;


import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 策略计算输入的信息类
 */
public class StrategyBackTestInputVO {

    /********************回测必须参数*******************/
    private int stockPoolType;              //0指定板块 1指定股票
    private int strategyType;               //0动量策略 1均值回归 2双均线策略 3羊驼策略 4KNN机器学习策略
    private String baseYieldBlock="hs300";  //基准收益率的指数 默认沪深300  sh=上证指数 sz=深圳成指 hs300=沪深300指数 sz50=上证50 zxb=中小板 cyb=创业板
    private String backTestBlock;           //若stockPoolType为0 回测指定板块的股票 则指定板块代码 sh=上证A股 sz=深证A股 zxb=中小板 cyb=创业板
    private ArrayList<String> stockCodes;   //若stockPoolType为1 则指定股票代码
    private String startDate;               //回测开始时间
    private String endDate;                 //回测结束时间
    private double initFund;                //初始资金
    private boolean notST;                  //是否排除st
    private int holdingPeriod;              //股票持有期
    private int returnPeriod;               //形成期 (strategyType为1时表示N日移动均线 strategyType为2时表示第一条N日平滑均线(长周期)）
    private double stopLoss;                //止损点 输入百分数 如20表示20%
    private double stopProfit;              //止盈点
    /********************回测必须参数********************/


    /******************不同策略的可选参数*****************/
    private double ratio;                   //strategyType为0时需要此参数 持有股票的比例,用于计算持有的股票数量 输入百分数 如20表示20%
    private int holdingStockNum;            //strategyType为1,2,3时需要此参数 持有的股票数量
    private int shortReturnPeriod;          //strategyType为2时需要此参数 表示第二条N日平滑均线(短周期)
    private int changeNumber;               //strategyType为3时需要此参数 表示每次换仓换股数量
    private int trainPeriod;                //strategyType为4时需要此参数 表示训练数据的天数(n)
    private int k;                          //strategyType为4时需要此参数 表示最近邻的数量 n-m>k
    private int vectorLength;               //strategyType为4时需要此参数 表示最近邻向量的长度(m)
    /******************不同策略的可选参数*****************/


    /***************寻找最佳形成期需要的参数***************/
    private boolean isHoldingPeriodFixed;     //持有期是否为不变量 用于寻找最佳形成期或持有期
    /***************寻找最佳形成期需要的参数***************/


    public int getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(int changeNumber) {
        this.changeNumber = changeNumber;
    }

    public int getShortReturnPeriod() {
        return shortReturnPeriod;
    }

    public void setShortReturnPeriod(int shortReturnPeriod) {
        this.shortReturnPeriod = shortReturnPeriod;
    }

    public int getStockPoolType() {
        return stockPoolType;
    }

    public void setStockPoolType(int stockPoolType) {
        this.stockPoolType = stockPoolType;
    }

    public int getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(int strategyType) {
        this.strategyType = strategyType;
    }

    public String getBackTestBlock() {
        return backTestBlock;
    }

    public void setBackTestBlock(String backTestBlock) {
        this.backTestBlock = backTestBlock;
    }

    public ArrayList<String> getStockCodes() {
        return stockCodes;
    }

    public void setStockCodes(ArrayList<String> stockCodes) {
        this.stockCodes = stockCodes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getInitFund() {
        return initFund;
    }

    public void setInitFund(double initFund) {
        this.initFund = initFund;
    }

    public boolean isNotST() {
        return notST;
    }

    public void setNotST(boolean notST) {
        this.notST = notST;
    }

    public int getHoldingPeriod() {
        return holdingPeriod;
    }

    public void setHoldingPeriod(int holdingPeriod) {
        this.holdingPeriod = holdingPeriod;
    }

    public int getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(int returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public int getHoldingStockNum() {
        return holdingStockNum;
    }

    public void setHoldingStockNum(int holdingStockNum) {
        this.holdingStockNum = holdingStockNum;
    }

    public double getRatio() {
        return ratio/100;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public boolean isHoldingPeriodFixed() {
        return isHoldingPeriodFixed;
    }

    public void setHoldingPeriodFixed(boolean holdingPeriodFixed) {
        isHoldingPeriodFixed = holdingPeriodFixed;
    }

    public int getTrainPeriod() {
        return trainPeriod;
    }

    public void setTrainPeriod(int trainPeriod) {
        this.trainPeriod = trainPeriod;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getVectorLength() {
        return vectorLength;
    }

    public void setVectorLength(int vectorLength) {
        this.vectorLength = vectorLength;
    }

    /**
     * 获取止损 转换为小数
     * @return double
     */
    public double getStopLoss() {
        return (-stopLoss/100);
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    /**
     * 获取止盈 转换为小数
     * @return double
     */
    public double getStopProfit() {
        return stopProfit/100;
    }

    public void setStopProfit(double stopProfit) {
        this.stopProfit = stopProfit;
    }

    public String getBaseYieldBlock() {
        return baseYieldBlock;
    }

    public void setBaseYieldBlock(String baseYieldBlock) {
        this.baseYieldBlock = baseYieldBlock;
    }

    @Override
    public String toString() {
        return "StrategyBackTestInputVO{" +
                "stockPoolType=" + stockPoolType +
                ", strategyType=" + strategyType +
                ", baseYieldBlock='" + baseYieldBlock + '\'' +
                ", backTestBlock='" + backTestBlock + '\'' +
                ", stockCodes=" + stockCodes +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", initFund=" + initFund +
                ", notST=" + notST +
                ", holdingPeriod=" + holdingPeriod +
                ", returnPeriod=" + returnPeriod +
                ", stopLoss=" + stopLoss +
                ", stopProfit=" + stopProfit +
                ", ratio=" + ratio +
                ", holdingStockNum=" + holdingStockNum +
                ", shortReturnPeriod=" + shortReturnPeriod +
                ", changeNumber=" + changeNumber +
                ", trainPeriod=" + trainPeriod +
                ", k=" + k +
                ", vectorLength=" + vectorLength +
                ", isHoldingPeriodFixed=" + isHoldingPeriodFixed +
                '}';
    }
}
