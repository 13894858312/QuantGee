package vo.stock;

/**
 * Created by Mark.W on 2017/5/25.
 * 股票预测值
 */
public class PredictedValueVO {
    private String date;
    private double predictedValue;

    public PredictedValueVO(String date,  double predictedValue) {
        this.date = date;
        this.predictedValue = predictedValue;
    }

    public String getDate() {
        return date;
    }

    public double getPredictedValue() {
        return predictedValue;
    }
}
