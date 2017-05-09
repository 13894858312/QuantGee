package vo.stock;

/**
 * Created by Mark.W on 2017/5/9.
 * k线图具体的每日数据
 */
public class KLineDataVO {

    private boolean isPositive;
    private String date;
    private double upperShadow;
    private double lowerShadow;
    private double maxValue;
    private double minValue;
    private double openPrice;
    private double closePrice;

    public KLineDataVO() {}

    /**
     * @param isPositive 是否为阳线
     * @param date 时间
     * @param upperShadow 上影线值
     * @param lowerShadow  下影线值
     * @param maxValue   最高值
     * @param minValue   最低值
     * @param openPrice   开盘价
     * @param closePrice   收盘价
     */
    public KLineDataVO(boolean isPositive, String date, double upperShadow, double lowerShadow,
                       double maxValue, double minValue, double openPrice, double closePrice) {
        this.isPositive = isPositive;
        this.date = date;
        this.upperShadow = upperShadow;
        this.lowerShadow = lowerShadow;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getUpperShadow() {
        return upperShadow;
    }

    public void setUpperShadow(double upperShadow) {
        this.upperShadow = upperShadow;
    }

    public double getLowerShadow() {
        return lowerShadow;
    }

    public void setLowerShadow(double lowerShadow) {
        this.lowerShadow = lowerShadow;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }
}
