package vo;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 * k线图的数据
 */
public class KLineVO {
    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param isPositive 是否为阳线
     * @param date 时间
     * @param upperShadow 上影线值
     * @param lowerShadow  下影线值
     * @param maxValue   最高值
     * @param minValue   最低值
     * @param openPrice   开盘价
     * @param closePrice   收盘价
     */
    private String stockCode;
    private String stockName;
    private boolean isPositive;
    private Date date;
    private double upperShadow;
    private double lowerShadow;
    private double maxValue;
    private double minValue;
    private double openPrice;
    private double closePrice;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
