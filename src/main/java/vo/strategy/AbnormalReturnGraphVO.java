package vo.strategy;

import logic.tools.MathHelper;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 超额收益率和策略胜率图的信息类
 */
public class AbnormalReturnGraphVO {
    private boolean isHoldingPeriodFixed;  //holdingPeriod是否是不变量 true表示holdingPeriod不变，returnPeriod变化
    private int bestHoldingPeriod;  //最佳持有期
    private int bestReturnPeriod;  //最佳形成期

    private double bestAbnormalReturn;  //最优的超额收益率
    private double bestStategyWinRate;   //最优的策略胜率

    private ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS;  //超额收益率和策略胜率图数据信息

    /**
     * @param isHoldingPeriodFixed true表示holdingPeriod不变，returnPeriod变化
     * @param bestHoldingPeriod 最佳持有期
     * @param bestReturnPeriod 最佳形成期
     * @param bestAbnormalReturn 最优的超额收益率
     * @param bestStategyWinRate 最优的策略胜率
     * @param abnormalReturnGraphDataVOS 超额收益率和策略胜率图数据信息
     */
    public AbnormalReturnGraphVO(boolean isHoldingPeriodFixed,int bestHoldingPeriod, int bestReturnPeriod, double bestAbnormalReturn,
                                 double bestStategyWinRate, ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS) {
        this.isHoldingPeriodFixed = isHoldingPeriodFixed;
        this.bestHoldingPeriod = bestHoldingPeriod;
        this.bestReturnPeriod = bestReturnPeriod;
        this.bestAbnormalReturn = MathHelper.formatData(bestAbnormalReturn*100, 2);
        this.bestStategyWinRate = MathHelper.formatData(bestStategyWinRate*100, 2);
        this.abnormalReturnGraphDataVOS = abnormalReturnGraphDataVOS;
    }

    public boolean isHoldingPeriodFixed() {
        return isHoldingPeriodFixed;
    }

    public void setHoldingPeriodFixed(boolean holdingPeriodFixed) {
        isHoldingPeriodFixed = holdingPeriodFixed;
    }

    public int getBestHoldingPeriod() {
        return bestHoldingPeriod;
    }

    public void setBestHoldingPeriod(int bestHoldingPeriod) {
        this.bestHoldingPeriod = bestHoldingPeriod;
    }

    public int getBestReturnPeriod() {
        return bestReturnPeriod;
    }

    public void setBestReturnPeriod(int bestReturnPeriod) {
        this.bestReturnPeriod = bestReturnPeriod;
    }

    public double getBestAbnormalReturn() {
        return bestAbnormalReturn;
    }

    public void setBestAbnormalReturn(double bestAbnormalReturn) {
        this.bestAbnormalReturn = bestAbnormalReturn;
    }

    public double getBestStategyWinRate() {
        return bestStategyWinRate;
    }

    public void setBestStategyWinRate(double bestStategyWinRate) {
        this.bestStategyWinRate = bestStategyWinRate;
    }

    public ArrayList<AbnormalReturnGraphDataVO> getAbnormalReturnGraphDataVOS() {
        return abnormalReturnGraphDataVOS;
    }

    public void setAbnormalReturnGraphDataVOS(ArrayList<AbnormalReturnGraphDataVO> abnormalReturnGraphDataVOS) {
        this.abnormalReturnGraphDataVOS = abnormalReturnGraphDataVOS;
    }
}
