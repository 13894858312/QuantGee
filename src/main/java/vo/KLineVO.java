package vo;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class KLineVO {
    public String kLineX;
    public double upperShadow;
    public double lowerShadow;
    public double maxValue;
    public double minValue;

    /**
     * @param kLineX 横坐标
     * @param upperShadow 上影线值
     * @param lowerShadow  下影线值
     * @param maxValue   最高值
     * @param minValue   最低值
     */
    public KLineVO(String kLineX, double upperShadow, double lowerShadow, double maxValue, double minValue) {
        this.kLineX = kLineX;
        this.upperShadow = upperShadow;
        this.lowerShadow = lowerShadow;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
