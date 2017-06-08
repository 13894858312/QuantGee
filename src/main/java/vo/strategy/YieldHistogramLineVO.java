package vo.strategy;

import logic.tools.MathHelper;

/**
 * Created by Mark.W on 2017/3/23.
 * 收益分布直方图的坐标信息
 */
public class YieldHistogramLineVO {
    private double startRate;
    private double endRate;

    private int positiveFrequency;
    private int negativeFrequency;

    /**
     * @param startRate 每一组左端值
     * @param endRate 每一组右端值
     * @param positiveFrequency 正收益频数
     * @param negativeFrequency 负收益频数
     */
    public YieldHistogramLineVO(double startRate, double endRate, int positiveFrequency, int negativeFrequency) {
        this.startRate = MathHelper.formatData(startRate * 100, 2);
        this.endRate = MathHelper.formatData(endRate * 100, 2);
        this.positiveFrequency = positiveFrequency;
        this.negativeFrequency = negativeFrequency;
    }

    public double getStartRate() {
        return startRate;
    }

    public void setStartRate(double startRate) {
        this.startRate = startRate;
    }

    public double getEndRate() {
        return endRate;
    }

    public void setEndRate(double endRate) {
        this.endRate = endRate;
    }

    public int getPositiveFrequency() {
        return positiveFrequency;
    }

    public void setPositiveFrequency(int positiveFrequency) {
        this.positiveFrequency = positiveFrequency;
    }

    public int getNegativeFrequency() {
        return negativeFrequency;
    }

    public void setNegativeFrequency(int negativeFrequency) {
        this.negativeFrequency = negativeFrequency;
    }
}
