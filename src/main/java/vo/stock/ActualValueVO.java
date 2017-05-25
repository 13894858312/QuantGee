package vo.stock;

/**
 * Created by Mark.W on 2017/5/25.
 * 股票实际值
 */
public class ActualValueVO {
    private String date;
    private double actualValue;

    public ActualValueVO(String date, double actualValue) {
        this.date = date;
        this.actualValue = actualValue;
    }

    public String getDate() {
        return date;
    }

    public double getActualValue() {
        return actualValue;
    }
}
