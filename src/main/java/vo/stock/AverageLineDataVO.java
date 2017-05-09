package vo.stock;

/**
 * Created by Mark.W on 2017/5/9.
 * 均线图每日具体数据的vo
 */
public class AverageLineDataVO {
    private String date;
    private double averageValue;

    public AverageLineDataVO() {}

    /**
     * @param date 时间
     * @param averageValue 对应平均值
     */
    public AverageLineDataVO(String date, double averageValue) {
        this.date = date;
        this.averageValue = averageValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }
}
