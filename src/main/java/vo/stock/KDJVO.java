package vo.stock;

/**
 * Created by Mark.W on 2017/5/21.
 */
public class KDJVO {
    private String date;
    private String code;
    private double k;
    private double d;
    private double j;

    public KDJVO() {}

    public KDJVO(String date, String code, double k, double d, double j) {
        this.date = date;
        this.code = code;
        this.k = k;
        this.d = d;
        this.j = j;
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

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }
}
