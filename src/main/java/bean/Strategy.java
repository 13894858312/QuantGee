package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/6/9.
 */
@Entity
public class Strategy {

//    /********************必须参数*******************/
//    private int strategyID;                 //策略id 收藏后该id由数据库确定 初次添加无需指定id
//    private String strateygyName;           //策略名字
//    private String userID;                  //用户id
//    private String time;                    //添加时间
//
//    private int strategyType;               //0动量策略 1均值回归 2双均线策略 3羊驼策略 4KNN机器学习策略
//    private double initFund;                //初始资金
//    private boolean notST;                  //是否排除st
//    private int holdingPeriod;              //股票持有期
//    private int returnPeriod;               //形成期 (strategyType为1时表示N日移动均线 strategyType为2时表示第一条N日平滑均线(长周期)）
//    private double stopLoss;                //止损点 输入百分数 如20表示20%
//    private double stopProfit;              //止盈点
//
//    private double lastYield;                   //最近一次回测的收益率
//    /********************必须参数********************/
//
//    /******************不同策略的可选参数*****************/
//    private double ratio;                   //strategyType为0时需要此参数 持有股票的比例,用于计算持有的股票数量 输入百分数 如20表示20%
//    private int holdingStockNum;            //strategyType为1,2,3时需要此参数 持有的股票数量
//    private int shortReturnPeriod;          //strategyType为2时需要此参数 表示第二条N日平滑均线(短周期)
//    private int changeNumber;               //strategyType为3时需要此参数 表示每次换仓换股数量
//    private int trainPeriod;                //strategyType为4时需要此参数 表示训练数据的天数(n)
//    private int k;                          //strategyType为4时需要此参数 表示最近邻的数量 n-m>k
//    private int vectorLength;               //strategyType为4时需要此参数 表示最近邻向量的长度(m)
//    /******************不同策略的可选参数*****************/

    private int strategyId;
    private String strategyName;
    private String userId;
    private String time;
    private int strategyType;
    private double initFund;
    private byte notSt;
    private int holdingPeriod;
    private int returnPeriod;
    private double stopLoss;
    private double stopProfit;
    private double lastYield;
    private Double ratio;
    private Integer holdingStockNum;
    private Integer shortReturnPeriod;
    private Integer changeNumber;
    private Integer trainPeriod;
    private Integer k;
    private Integer vectorLength;

    @Id
    @Column(name = "strategyID", nullable = false)
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    @Basic
    @Column(name = "strategyName", nullable = false, length = 30)
    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Basic
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time", nullable = false, length = 20)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "strategyType", nullable = false)
    public int getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(int strategyType) {
        this.strategyType = strategyType;
    }

    @Basic
    @Column(name = "initFund", nullable = false, precision = 0)
    public double getInitFund() {
        return initFund;
    }

    public void setInitFund(double initFund) {
        this.initFund = initFund;
    }

    @Basic
    @Column(name = "notST", nullable = false)
    public byte getNotSt() {
        return notSt;
    }

    public void setNotSt(byte notSt) {
        this.notSt = notSt;
}

    @Basic
    @Column(name = "holdingPeriod", nullable = false)
    public int getHoldingPeriod() {
        return holdingPeriod;
    }

    public void setHoldingPeriod(int holdingPeriod) {
        this.holdingPeriod = holdingPeriod;
    }

    @Basic
    @Column(name = "returnPeriod", nullable = false)
    public int getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(int returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    @Basic
    @Column(name = "stopLoss", nullable = false, precision = 0)
    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    @Basic
    @Column(name = "stopProfit", nullable = false, precision = 0)
    public double getStopProfit() {
        return stopProfit;
    }

    public void setStopProfit(double stopProfit) {
        this.stopProfit = stopProfit;
    }

    @Basic
    @Column(name = "lastYield", nullable = false, precision = 0)
    public double getLastYield() {
        return lastYield;
    }

    public void setLastYield(double lastYield) {
        this.lastYield = lastYield;
    }

    @Basic
    @Column(name = "ratio", nullable = true, precision = 0)
    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    @Basic
    @Column(name = "holdingStockNum", nullable = true)
    public Integer getHoldingStockNum() {
        return holdingStockNum;
    }

    public void setHoldingStockNum(Integer holdingStockNum) {
        this.holdingStockNum = holdingStockNum;
    }

    @Basic
    @Column(name = "shortReturnPeriod", nullable = true)
    public Integer getShortReturnPeriod() {
        return shortReturnPeriod;
    }

    public void setShortReturnPeriod(Integer shortReturnPeriod) {
        this.shortReturnPeriod = shortReturnPeriod;
    }

    @Basic
    @Column(name = "changeNumber", nullable = true)
    public Integer getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(Integer changeNumber) {
        this.changeNumber = changeNumber;
    }

    @Basic
    @Column(name = "trainPeriod", nullable = true)
    public Integer getTrainPeriod() {
        return trainPeriod;
    }

    public void setTrainPeriod(Integer trainPeriod) {
        this.trainPeriod = trainPeriod;
    }

    @Basic
    @Column(name = "k", nullable = true)
    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    @Basic
    @Column(name = "vectorLength", nullable = true)
    public Integer getVectorLength() {
        return vectorLength;
    }

    public void setVectorLength(Integer vectorLength) {
        this.vectorLength = vectorLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strategy strategy = (Strategy) o;

        if (strategyId != strategy.strategyId) return false;
        if (strategyType != strategy.strategyType) return false;
        if (Double.compare(strategy.initFund, initFund) != 0) return false;
        if (notSt != strategy.notSt) return false;
        if (holdingPeriod != strategy.holdingPeriod) return false;
        if (returnPeriod != strategy.returnPeriod) return false;
        if (Double.compare(strategy.stopLoss, stopLoss) != 0) return false;
        if (Double.compare(strategy.stopProfit, stopProfit) != 0) return false;
        if (Double.compare(strategy.lastYield, lastYield) != 0) return false;
        if (strategyName != null ? !strategyName.equals(strategy.strategyName) : strategy.strategyName != null)
            return false;
        if (userId != null ? !userId.equals(strategy.userId) : strategy.userId != null) return false;
        if (time != null ? !time.equals(strategy.time) : strategy.time != null) return false;
        if (ratio != null ? !ratio.equals(strategy.ratio) : strategy.ratio != null) return false;
        if (holdingStockNum != null ? !holdingStockNum.equals(strategy.holdingStockNum) : strategy.holdingStockNum != null)
            return false;
        if (shortReturnPeriod != null ? !shortReturnPeriod.equals(strategy.shortReturnPeriod) : strategy.shortReturnPeriod != null)
            return false;
        if (changeNumber != null ? !changeNumber.equals(strategy.changeNumber) : strategy.changeNumber != null)
            return false;
        if (trainPeriod != null ? !trainPeriod.equals(strategy.trainPeriod) : strategy.trainPeriod != null)
            return false;
        if (k != null ? !k.equals(strategy.k) : strategy.k != null) return false;
        if (vectorLength != null ? !vectorLength.equals(strategy.vectorLength) : strategy.vectorLength != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = strategyId;
        result = 31 * result + (strategyName != null ? strategyName.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + strategyType;
        temp = Double.doubleToLongBits(initFund);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) notSt;
        result = 31 * result + holdingPeriod;
        result = 31 * result + returnPeriod;
        temp = Double.doubleToLongBits(stopLoss);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(stopProfit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lastYield);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        result = 31 * result + (holdingStockNum != null ? holdingStockNum.hashCode() : 0);
        result = 31 * result + (shortReturnPeriod != null ? shortReturnPeriod.hashCode() : 0);
        result = 31 * result + (changeNumber != null ? changeNumber.hashCode() : 0);
        result = 31 * result + (trainPeriod != null ? trainPeriod.hashCode() : 0);
        result = 31 * result + (k != null ? k.hashCode() : 0);
        result = 31 * result + (vectorLength != null ? vectorLength.hashCode() : 0);
        return result;
    }
}
