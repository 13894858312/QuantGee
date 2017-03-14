package view.UI;

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

    public Range_Compare(ArrayList<StockVO> stockVOArrayList){

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
        series_IncreaseRange.setName("IncreaseRange");
        series_DecreaseRange.setName("DecreaseRange");
        StockVO stockVO1 = stockVOArrayList.get(0);
        StockVO stockVO2 = stockVOArrayList.get(1);



        bc.getData().addAll(series_IncreaseRange, series_DecreaseRange);
        getChildren().add(bc);

    }

    private boolean judgeInOrDeRange(double d){
        if(d >= 0){
            return true;
        }else{
            return false;
        }
    }
}
