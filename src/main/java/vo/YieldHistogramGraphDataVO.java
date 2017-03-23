package vo;

/**
 * Created by Mark.W on 2017/3/23.
 * 收益分布直方图的坐标信息
 */
public class YieldHistogramGraphDataVO {
    public double startRate;
    public double endRate;

    public int Frequency;

    /**
     *
     * @param startRate 每一组左端值
     * @param endRate 每一组右端值
     * @param frequency 频数
     */
    public YieldHistogramGraphDataVO(double startRate, double endRate, int frequency) {
        this.startRate = startRate;
        this.endRate = endRate;
        this.Frequency = frequency;
    }
}
