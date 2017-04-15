package view.UI;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import vo.StockDailyInfoVO;
import vo.StockVO;
import vo.YieldHistogramGraphDataVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/15.
 */
public class DistributionYield extends Pane {
    public DistributionYield(ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOArrayList, int width, int height){

        this.getStylesheets().add("/css/price_Compare.css");

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Yield");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setCategoryGap(20);
        bc.setBarGap(3);
        bc.setPrefSize(width, height);
        bc.setTitle("Distribution Yield Chart");

        XYChart.Series<String, Number> series_plus = new XYChart.Series<>();
        XYChart.Series<String, Number> series_minus = new XYChart.Series<>();
        for(int i = yieldHistogramGraphDataVOArrayList.size()-1;i>=0;i--){

        }
        //data

        bc.getData().addAll();
        getChildren().add(bc);
    }
}
