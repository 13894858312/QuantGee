package vo.stock;

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

    private ArrayList<ActualValueVO> actualValueVOS;
    private ArrayList<PredictedValueVO> predictedValueVOS;

    public StockPredictVO(String code, double predictTomorrowPrice, double predictTomorrowIncrease,
                          double historyDeviation, ArrayList<ActualValueVO> actualValueVOS,
                          ArrayList<PredictedValueVO> predictedValueVOS) {
        this.code = code;
        this.predictTomorrowPrice = predictTomorrowPrice;
        this.predictTomorrowIncrease = predictTomorrowIncrease;
        this.historyDeviation = historyDeviation;
        this.actualValueVOS = actualValueVOS;
        this.predictedValueVOS = predictedValueVOS;
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

    public ArrayList<ActualValueVO> getActualValueVOS() {
        return actualValueVOS;
    }

    public ArrayList<PredictedValueVO> getPredictedValueVOS() {
        return predictedValueVOS;
    }
}
