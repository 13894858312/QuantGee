package view.ui;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import vo.StockDailyInfoVO;
import vo.StockVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/12.
 */
public class Range_Compare extends Pane{

    public Range_Compare(ArrayList<StockVO> stockVOArrayList, ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList){

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Name Of Share");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Range");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Comparision Of Range");

        //data
        XYChart.Series<String, Number> series_IncreaseRange = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_DecreaseRange = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_LogYieldRnage = new XYChart.Series<String, Number>();
        series_IncreaseRange.setName("IncreaseRange");
        series_DecreaseRange.setName("DecreaseRange");
        series_LogYieldRnage.setName("LogYieldRnage");
        for(int i=0;i<stockVOArrayList.size();i++){
            StockVO stockVO = stockVOArrayList.get(i);
            StockDailyInfoVO stockDailyInfoVO = stockDailyInfoVOArrayList.get(i);
            series_IncreaseRange.getData().add(new XYChart.Data<String, Number>(stockVO.stockName, Math.abs(stockDailyInfoVO.inOrDecreaseRate)));
            series_DecreaseRange.getData().add(new XYChart.Data<String, Number>(stockVO.stockName, Math.abs(stockDailyInfoVO.inOrDecreaseRate)));
            series_LogYieldRnage.getData().add(new XYChart.Data<String, Number>(stockVO.stockName, stockDailyInfoVO.logarithmYield));
        }

        bc.getData().addAll(series_IncreaseRange, series_DecreaseRange, series_LogYieldRnage);
        getChildren().add(bc);

    }
}
