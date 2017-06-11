package vo.stock;

import logic.tools.MathHelper;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/25.
 * 股票预测信息的vo
 */
public class StockPredictVO {
    private String code;
    private double predictTomorrowPrice;
    private double predictTomorrowIncrease;
    private double historyDeviation;

    private ArrayList<LineVO> actualValues;
    private ArrayList<LineVO> predictedValues;

    public StockPredictVO(String code,  double predictTomorrowPrice, double predictTomorrowIncrease,
                          double historyDeviation, ArrayList<LineVO> actualValues, ArrayList<LineVO> predictedValues) {
        this.code = code;
        this.predictTomorrowPrice = MathHelper.formatData(predictTomorrowPrice,2);
        this.predictTomorrowIncrease = MathHelper.formatData(predictTomorrowIncrease*100,2);
        this.historyDeviation = MathHelper.formatData(historyDeviation*100,2);
        this.actualValues = actualValues;
        this.predictedValues = predictedValues;
    }

    public String getCode() {
        return code;
    }

    public double getPredictTomorrowPrice() {
        return predictTomorrowPrice;
    }

    public double getPredictTomorrowIncrease() {
        return predictTomorrowIncrease;
    }

    public double getHistoryDeviation() {
        return historyDeviation;
    }


    public ArrayList<LineVO> getActualValues() {
        return actualValues;
    }

    public ArrayList<LineVO> getPredictedValues() {
        return predictedValues;
    }
}
