package vo.stock;

/**
 * Created by Mark.W on 2017/5/21.
 */
public class MACDVO {
    private String date;
    private String code;
    private double diff;
    private double dea;
    private double macd;

    public MACDVO() {}

    public MACDVO(String date, String code, double diff, double dea, double macd) {
        this.date = date;
        this.code = code;
        this.diff = diff;
        this.dea = dea;
        this.macd = macd;
    }

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

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getDea() {
        return dea;
    }

    public void setDea(double dea) {
        this.dea = dea;
    }

    public double getMacd() {
        return macd;
    }

    public void setMacd(double macd) {
        this.macd = macd;
    }
}
