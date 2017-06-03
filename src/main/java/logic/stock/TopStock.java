package logic.stock;

/**
 * Created by Mark.W on 2017/6/3.
 * 用于排序的股票对象
 */
public class TopStock {
    private String code;
    private double increaseRate;
    private double nowPrice;

    private String topCode;     // 领涨股或者领跌股

    public TopStock(String code, double increaseRate, String topCode) {
        this.code = code;
        this.increaseRate = increaseRate;
        this.topCode = topCode;
    }

    public TopStock(String code, double increaseRate, double nowPrice) {
        this.code = code;
        this.increaseRate = increaseRate;
        this.nowPrice = nowPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getIncreaseRate() {
        return increaseRate;
    }

    public void setIncreaseRate(double increaseRate) {
        this.increaseRate = increaseRate;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getTopCode() {
        return topCode;
    }

    public void setTopCode(String topCode) {
        this.topCode = topCode;
    }
}
