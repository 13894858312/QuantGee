package vo.stock;

import logic.tools.MathHelper;

/**
 * Created by Mark.W on 2017/5/25.
 */
public class LineVO {
    private String date;
    private double value;

    public LineVO(String date, double value) {
        this.date = date;
        this.value = MathHelper.formatData(value,2);
    }

    public double getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }
}
