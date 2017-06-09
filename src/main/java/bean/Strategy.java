package bean;

/**
 * Created by wangxue on 2017/5/23.
 */
//@Entity
public class Strategy {

    /********************必须参数*******************/
    private int strategyID;                 //策略id 收藏后该id由数据库确定 初次添加无需指定id
    private String strateygyName;           //策略名字
    private String userID;                  //用户id
    private String time;                    //添加时间

    private int strategyType;               //0动量策略 1均值回归 2双均线策略 3羊驼策略 4KNN机器学习策略
    private double initFund;                //初始资金
    private boolean notST;                  //是否排除st
    private int holdingPeriod;              //股票持有期
    private int returnPeriod;               //形成期 (strategyType为1时表示N日移动均线 strategyType为2时表示第一条N日平滑均线(长周期)）
    private double stopLoss;                //止损点 输入百分数 如20表示20%
    private double stopProfit;              //止盈点

    private double lastYield;                   //最近一次回测的收益率
    /********************必须参数********************/

    /******************不同策略的可选参数*****************/
    private double ratio;                   //strategyType为0时需要此参数 持有股票的比例,用于计算持有的股票数量 输入百分数 如20表示20%
    private int holdingStockNum;            //strategyType为1,2,3时需要此参数 持有的股票数量
    private int shortReturnPeriod;          //strategyType为2时需要此参数 表示第二条N日平滑均线(短周期)
    private int changeNumber;               //strategyType为3时需要此参数 表示每次换仓换股数量
    private int trainPeriod;                //strategyType为4时需要此参数 表示训练数据的天数(n)
    private int k;                          //strategyType为4时需要此参数 表示最近邻的数量 n-m>k
    private int vectorLength;               //strategyType为4时需要此参数 表示最近邻向量的长度(m)
    /******************不同策略的可选参数*****************/

    public int getStrategyID() {
        return strategyID;
    }

    public void setStrategyID(int strategyID) {
        this.strategyID = strategyID;
    }

    public String getStrateygyName() {
        return strateygyName;
    }

    public void setStrateygyName(String strateygyName) {
        this.strateygyName = strateygyName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public double getLastYield() {
        return lastYield;
    }

    public void setLastYield(double lastYield) {
        this.lastYield = lastYield;
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


    //    private int strategyId;
//    private String strategyName;
//    private String strategyType;
//    private String strategyContent;
//    private String userId;
//    private Integer posted;
//
//    @Id
//    @Column(name = "strategyID", nullable = false)
//    public int getStrategyId() {
//        return strategyId;
//    }
//
//    public void setStrategyId(int strategyId) {
//        this.strategyId = strategyId;
//    }
//
//    @Basic
//    @Column(name = "strategyName", nullable = false, length = -1)
//    public String getStrategyName() {
//        return strategyName;
//    }
//
//    public void setStrategyName(String strategyName) {
//        this.strategyName = strategyName;
//    }
//
//    @Basic
//    @Column(name = "strategyType", nullable = false, length = 20)
//    public String getStrategyType() {
//        return strategyType;
//    }
//
//    public void setStrategyType(String strategyType) {
//        this.strategyType = strategyType;
//    }
//
//    @Basic
//    @Column(name = "strategyContent", nullable = true, length = -1)
//    public String getStrategyContent() {
//        return strategyContent;
//    }
//
//    public void setStrategyContent(String strategyContent) {
//        this.strategyContent = strategyContent;
//    }
//
//    @Basic
//    @Column(name = "userID", nullable = false, length = 20)
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    @Basic
//    @Column(name = "posted", nullable = true)
//    public Integer getPosted() {
//        return posted;
//    }
//
//    public void setPosted(Integer posted) {
//        this.posted = posted;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Strategy strategy = (Strategy) o;
//
//        if (strategyId != strategy.strategyId) return false;
//        if (strategyName != null ? !strategyName.equals(strategy.strategyName) : strategy.strategyName != null)
//            return false;
//        if (strategyType != null ? !strategyType.equals(strategy.strategyType) : strategy.strategyType != null)
//            return false;
//        if (strategyContent != null ? !strategyContent.equals(strategy.strategyContent) : strategy.strategyContent != null)
//            return false;
//        if (userId != null ? !userId.equals(strategy.userId) : strategy.userId != null) return false;
//        if (posted != null ? !posted.equals(strategy.posted) : strategy.posted != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = strategyId;
//        result = 31 * result + (strategyName != null ? strategyName.hashCode() : 0);
//        result = 31 * result + (strategyType != null ? strategyType.hashCode() : 0);
//        result = 31 * result + (strategyContent != null ? strategyContent.hashCode() : 0);
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
//        result = 31 * result + (posted != null ? posted.hashCode() : 0);
//        return result;
//    }
}
