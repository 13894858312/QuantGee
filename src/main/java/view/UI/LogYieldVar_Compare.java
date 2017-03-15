package view.UI;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import vo.StockDailyInfoVO;
import vo.StockVO;

/**
 * Created by Administrator on 2017/3/12.
 */
public class LogYieldVar_Compare extends Pane{

    public LogYieldVar_Compare(StockVO stockVO1, StockVO stockVO2, int width, int height){

        this.getStylesheets().add("/css/logYieldVar_Compare.css");

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Name Of Share");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Logarithmic Yield Variance");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setPrefSize(width, height);
        bc.setCategoryGap(30);
        bc.setTitle("Comparision Of Logarithmic yield variance");

        //data
        XYChart.Series<String, Number> series_LogYieldVar = new XYChart.Series<String, Number>();
        series_LogYieldVar.getData().add(new XYChart.Data<String, Number>(stockVO1.stockName, stockVO1.logarithmYieldVariance));
        series_LogYieldVar.getData().add(new XYChart.Data<String, Number>(stockVO2.stockName, stockVO2.logarithmYieldVariance));

        bc.getData().addAll(series_LogYieldVar);
        getChildren().add(bc);
    }
}
