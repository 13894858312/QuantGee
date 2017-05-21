package vo.stock;

/**
 * Created by Mark.W on 2017/5/21.
 * 均线图的vo
 */
public class MAVO {
    private String stockCode;
    private int period;
    private String date;
    private double averageValue;

    public MAVO() {}

    /**
     * @param stockCode 股票代码
     * @param period 周期
     * @param date 时间
     * @param averageValue 均值
     */
    public MAVO(String stockCode, int period, String date, double averageValue) {
        this.stockCode = stockCode;
        this.period = period;
        this.date = date;
        this.averageValue = averageValue;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }
}
