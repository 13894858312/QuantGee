package vo.strategy;

/**
 * Created by Mark.W on 2017/5/11.
 * 策略具体信息的vo
 */
public class StrategyVO {

    /***********************必须参数*******************/
    private int strategyID;                 //策略id 收藏后该id由数据库确定 初次添加无需指定id
    private String userID;                  //用户id

    //策略列表展示的时候可以选择展示这三项 策略名字-策略添加时间-上一次回测的收益率
    private String strateygyName;           //可以用户输入名字 若不输入传递则系统指定
    private String time;                    //添加时间 传当前时间
    private double lastYield;                   //最近一次回测的收益率 没有回测过填0

    private int strategyType;               //0动量策略 1均值回归 2双均线策略 3羊驼策略 4KNN机器学习策略
    private double initFund;                //初始资金
    private boolean notST;                  //是否排除st
    private int holdingPeriod;              //股票持有期
    private int returnPeriod;               //形成期 (strategyType为1时表示N日移动均线 strategyType为2时表示第一条N日平滑均线(长周期)）
    private double stopLoss;                //止损点 输入百分数 如20表示20%
    private double stopProfit;              //止盈点
    /***********************必须参数********************/

    /******************不同策略的可选参数*****************/
    private double ratio;                   //strategyType为0时需要此参数 持有股票的比例,用于计算持有的股票数量 输入百分数 如20表示20%
    private int holdingStockNum;            //strategyType为1,2,3时需要此参数 持有的股票数量
    private int shortReturnPeriod;          //strategyType为2时需要此参数 表示第二条N日平滑均线(短周期)
    private int changeNumber;               //strategyType为3时需要此参数 表示每次换仓换股数量
    private int trainPeriod;                //strategyType为4时需要此参数 表示训练数据的天数(n)
    private int k;                          //strategyType为4时需要此参数 表示最近邻的数量 n-m>k
    private int vectorLength;               //strategyType为4时需要此参数 表示最近邻向量的长度(m)
    /******************不同策略的可选参数*****************/

    public StrategyVO() {
    }

    public StrategyVO(int strategyID, String userID, String strateygyName, String time, double lastYield,
                      int strategyType, double initFund, boolean notST, int holdingPeriod, int returnPeriod,
                      double stopLoss, double stopProfit, double ratio, int holdingStockNum,
                      int shortReturnPeriod, int changeNumber, int trainPeriod, int k, int vectorLength) {
        this.strategyID = strategyID;
        this.userID = userID;
        this.strateygyName = strateygyName;
        this.time = time;
        this.lastYield = lastYield;
        this.strategyType = strategyType;
        this.initFund = initFund;
        this.notST = notST;
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.stopLoss = stopLoss;
        this.stopProfit = stopProfit;
        this.ratio = ratio;
        this.holdingStockNum = holdingStockNum;
        this.shortReturnPeriod = shortReturnPeriod;
        this.changeNumber = changeNumber;
        this.trainPeriod = trainPeriod;
        this.k = k;
        this.vectorLength = vectorLength;
    }

    public String getStrateygyName() {
        return strateygyName;
    }

    public void setStrateygyName(String strateygyName) {
        this.strateygyName = strateygyName;
    }

    public double getLastYield() {
        return lastYield;
    }

    public void setLastYield(double lastYield) {
        this.lastYield = lastYield;
    }

    public String getUserID() {
        return userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStrategyID() {
        return strategyID;
    }

    public void setStrategyID(int strategyID) {
        this.strategyID = strategyID;
    }

    public int getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(int strategyType) {
        this.strategyType = strategyType;
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

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public double getStopProfit() {
        return stopProfit;
    }

    public void setStopProfit(double stopProfit) {
        this.stopProfit = stopProfit;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getHoldingStockNum() {
        return holdingStockNum;
    }

    public void setHoldingStockNum(int holdingStockNum) {
        this.holdingStockNum = holdingStockNum;
    }

    public int getShortReturnPeriod() {
        return shortReturnPeriod;
    }

    public void setShortReturnPeriod(int shortReturnPeriod) {
        this.shortReturnPeriod = shortReturnPeriod;
    }

    public int getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(int changeNumber) {
        this.changeNumber = changeNumber;
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
}
