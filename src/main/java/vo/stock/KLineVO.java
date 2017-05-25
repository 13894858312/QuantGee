package vo.stock;

/**
 * Created by Mark.W on 2017/5/16.
 */
public class KLineVO {

    private String date;
    private double open;
    private double close;
    private double low;
    private double high;

    public KLineVO(String date, double open, double close, double low, double high) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
    }

    public String getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getClose() {
        return close;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }
}