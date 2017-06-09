package vo.stock;

/**
 * Created by Mark.W on 2017/5/21.
 * 均线图的vo
 */
public class MaVO {
    private String code;
    private int period;
    private String date;
    private double ma;

    /**
     * @param code 股票代码
     * @param period 周期
     * @param date 时间
     * @param ma 均值
     */
    public MaVO(String code, int period, String date, double ma) {
        this.code = code;
        this.period = period;
        this.date = date;
        this.ma = ma;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public double getMa() {
        return ma;
    }

    public void setMa(double ma) {
        this.ma = ma;
    }
}
