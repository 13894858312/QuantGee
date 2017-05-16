package logic.stock;

/**
 * Created by Mark.W on 2017/5/16.
 */
public class KLineData {

    private boolean isPositive;
    private double upperShadow;
    private double lowerShadow;

    /**
     * @param isPositive  是否为阳线
     * @param upperShadow 上影线值
     * @param lowerShadow 下影线值
     */
    public KLineData(boolean isPositive, double upperShadow, double lowerShadow) {
        this.isPositive = isPositive;
        this.upperShadow = upperShadow;
        this.lowerShadow = lowerShadow;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public double getUpperShadow() {
        return upperShadow;
    }

    public double getLowerShadow() {
        return lowerShadow;
    }
}