package bean;

/**
 * Created by Mark.W on 2017/5/21.
 * RSI指标的信息
 */
public class RSI {
    private String date;
    private String code;
    private double rsi6;
    private double rsi12;
    private double rsi24;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRsi6() {
        return rsi6;
    }

    public void setRsi6(double rsi6) {
        this.rsi6 = rsi6;
    }

    public double getRsi12() {
        return rsi12;
    }

    public void setRsi12(double rsi12) {
        this.rsi12 = rsi12;
    }

    public double getRsi24() {
        return rsi24;
    }

    public void setRsi24(double rsi24) {
        this.rsi24 = rsi24;
    }
}
