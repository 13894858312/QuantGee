package view.UI;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import logic.tools.DateHelper;
import vo.StockDailyInfoVO;
import vo.StockVO;
import vo.YieldHistogramGraphDataVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/15.
 */
public class DistributionYield extends Pane {
    double [][] test1 = new double[][]{
            {0,5,10,-10,1},
            {0,5,20,-20,2},
            {0,5,30,-30,2.5},
            {0,5,40,-40,3},
            {0,5,50,-50,3.5},
            {0,5,60,-60,4},
            {5,10,10,-10,5.8},
            {5,10,10,-10,6.5},
            {5,10,10,-10,7},
            {5,10,10,-10,8},
    };
    public DistributionYield(ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOArrayList, int width, int height){

        this.getStylesheets().add("/css/distributionYield.css");

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setTickLabelGap(2);
        xAxis.setLabel("Yield");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setCategoryGap(10);
        bc.setBarGap(3);
        bc.setPrefSize(width, height);
        bc.setTitle("Distribution Yield Chart");

        XYChart.Series<String, Number> series_plus = new XYChart.Series<>();
        XYChart.Series<String, Number> series_minus = new XYChart.Series<>();
        series_minus.setName("负收益周期数");
        series_plus.setName("正收益周期数");
//        for(int i = yieldHistogramGraphDataVOArrayList.size()-1;i>=0;i--){
//            YieldHistogramGraphDataVO yieldHistogramGraphDataVO = yieldHistogramGraphDataVOArrayList.get(i);
////            series_minus.getData().add(new XYChart.Data<>())
//        }
        for(int i=0;i<test1.length;i++){
            double [] date = test1[i];
            series_minus.getData().add(new XYChart.Data<String, Number>(String.valueOf(date[4])+"%", Math.abs(date[3])));
            series_plus.getData().add(new XYChart.Data<String, Number>(String.valueOf(date[4])+"%", date[2]));
        }
        //data

        bc.getData().addAll(series_minus,series_plus);
        getChildren().add(bc);
    }
}
