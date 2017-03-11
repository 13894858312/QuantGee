package vo;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class KLineVO {
    public boolean isPositive;
    public Date date;
    public double upperShadow;
    public double lowerShadow;
    public double maxValue;
    public double minValue;
    public double openPrice;
    public double closePrice;

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
    public KLineVO(boolean isPositive, Date date, double upperShadow, double lowerShadow,
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
}
