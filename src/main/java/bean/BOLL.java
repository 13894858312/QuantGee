package bean;

/**
 * Created by Mark.W on 2017/5/21.
 * BOLL指标的信息
 */
public class BOLL {
    private String date;
    private String code;
    private double mid;
    private double up;
    private double lown;

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

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public double getLown() {
        return lown;
    }

    public void setLown(double lown) {
        this.lown = lown;
    }
}
