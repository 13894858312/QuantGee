package logic.calculation;

/**
 * Created by Mark.W on 2017/5/23.
 */
public class SimpleStock {
    private String code;
    private String date;
    private double close;

    private double high;
    private double low;

    /**
     * 计算macd时用的构造方法
     * @param code 代码
     * @param date 日期
     * @param close 收盘价
     */
    public SimpleStock(String code, String date, double close) {
        this.code = code;
        this.date = date;
        this.close = close;
    }

    /**
     * 计算kdj时用的构造方法
     * @param code 代码
     * @param date 日期
     * @param close 收盘价
     * @param high 最高价
     * @param low 最低价
     */
    public SimpleStock(String code, String date, double close, double high, double low) {
        this.code = code;
        this.date = date;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
}
