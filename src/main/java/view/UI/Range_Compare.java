package view.UI;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

/**
 * Created by Administrator on 2017/3/12.
 */
public class Range_Compare extends Pane{

    public Range_Compare(StockVO stockVO1, StockVO stockVO2, int width, int height){

        this.getStylesheets().add("/css/range_Compare.css");
        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Name Of Share");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Range");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setBarGap(3);
        bc.setCategoryGap(30);
        bc.setPrefSize(width, height);
        bc.setTitle("Comparision Of Range");

        //data
        XYChart.Series<String, Number> series_IncreaseRange = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_DecreaseRange = new XYChart.Series<String, Number>();
        series_IncreaseRange.setName("IncreaseRange");
        series_DecreaseRange.setName("DecreaseRange");

        if(stockVO1.rate<0){
            series_DecreaseRange.getData().add(new XYChart.Data<String, Number>(stockVO1.stockName+"\n"+"("+stockVO1.rate+")", Math.abs(stockVO1.rate)));
        }else{
            series_IncreaseRange.getData().add(new XYChart.Data<String, Number>(stockVO1.stockName+"\n"+"("+stockVO1.rate+")", stockVO1.rate));
        }

        if(stockVO2.rate<0){
            series_DecreaseRange.getData().add(new XYChart.Data<String, Number>(stockVO2.stockName+"\n"+"("+stockVO2.rate+")", Math.abs(stockVO2.rate)));
        }else{
            series_IncreaseRange.getData().add(new XYChart.Data<String, Number>(stockVO2.stockName+"\n"+"("+stockVO2.rate+")", stockVO2.rate));
        }

        bc.getData().addAll(series_IncreaseRange, series_DecreaseRange);
        getChildren().add(bc);

    }

}
