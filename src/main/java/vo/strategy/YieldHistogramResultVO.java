package vo.strategy;

import logic.tools.MathHelper;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 收益分布直方图的vo
 */
public class YieldHistogramResultVO {

    private int positiveEarningNum; //正收益周期数
    private int negativeEarningNum; //负收益周期数
    private double winRate; //赢率

    private ArrayList<YieldHistogramLineVO> yieldHistogramData; //坐标信息

    /**
     *
     * @param positiveEarningNum 正收益周期数
     * @param negativeEarningNum 负收益周期数
     * @param winRate 赢率
     * @param yieldHistogramData 坐标信息
     */
    public YieldHistogramResultVO(int positiveEarningNum, int negativeEarningNum, double winRate,
                                  ArrayList<YieldHistogramLineVO> yieldHistogramData) {
        this.positiveEarningNum = positiveEarningNum;
        this.negativeEarningNum = negativeEarningNum;
        this.winRate = MathHelper.formatData(winRate*100, 2);
        this.yieldHistogramData = yieldHistogramData;
    }

    public int getPositiveEarningNum() {
        return positiveEarningNum;
    }

    public void setPositiveEarningNum(int positiveEarningNum) {
        this.positiveEarningNum = positiveEarningNum;
    }

    public int getNegativeEarningNum() {
        return negativeEarningNum;
    }

    public void setNegativeEarningNum(int negativeEarningNum) {
        this.negativeEarningNum = negativeEarningNum;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public ArrayList<YieldHistogramLineVO> getYieldHistogramData() {
        return yieldHistogramData;
    }

    public void setYieldHistogramData(ArrayList<YieldHistogramLineVO> yieldHistogramData) {
        this.yieldHistogramData = yieldHistogramData;
    }
}
