package vo.strategy;

/**
 * Created by Mark.W on 2017/3/23.
 * 超额收益率和策略胜率图的坐标信息
 */
public class AbnormalReturnGraphDataVO {

    private int holdingPeriod;  //持有期
    private int returnPeriod;  //形成期

    private double abnormalReturn; //超额收益率
    private double stategyWinRate; //策略胜率

    /**
     * @param holdingPeriod 持有期
     * @param returnPeriod 形成期
     * @param abnormalReturn 超额收益率
     * @param stategyWinRate 策略胜率
     */
    public AbnormalReturnGraphDataVO(int holdingPeriod, int returnPeriod,
                                     double abnormalReturn, double stategyWinRate) {
        this.holdingPeriod = holdingPeriod;
        this.returnPeriod = returnPeriod;
        this.abnormalReturn = abnormalReturn;
        this.stategyWinRate = stategyWinRate;
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

    public double getAbnormalReturn() {
        return abnormalReturn;
    }

    public void setAbnormalReturn(double abnormalReturn) {
        this.abnormalReturn = abnormalReturn;
    }

    public double getStategyWinRate() {
        return stategyWinRate;
    }

    public void setStategyWinRate(double stategyWinRate) {
        this.stategyWinRate = stategyWinRate;
    }
}
