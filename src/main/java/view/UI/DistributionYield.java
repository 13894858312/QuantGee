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
        System.out.print(yieldHistogramGraphDataVOArrayList.size());
        for(int i = 0;i<yieldHistogramGraphDataVOArrayList.size();i++){
            YieldHistogramGraphDataVO yieldHistogramGraphDataVO = yieldHistogramGraphDataVOArrayList.get(i);
            series_minus.getData().add(new XYChart.Data<String, Number>(String.valueOf(yieldHistogramGraphDataVO.startRate*100)+"% - "+String.valueOf(yieldHistogramGraphDataVO.endRate*100)+"%",
                    yieldHistogramGraphDataVO.negativeFrequency));
            series_plus.getData().add(new XYChart.Data<String, Number>(String.valueOf(yieldHistogramGraphDataVO.startRate*100)+"% - "+String.valueOf(yieldHistogramGraphDataVO.endRate*100)+"%",
                    yieldHistogramGraphDataVO.positiveFrequency));
        }
//        for(int i=0;i<test1.length;i++){
//            double [] date = test1[i];
//            series_minus.getData().add(new XYChart.Data<String, Number>(String.valueOf(date[4])+"%", Math.abs(date[3])));
//            series_plus.getData().add(new XYChart.Data<String, Number>(String.valueOf(date[4])+"%", date[2]));
//        }
        //data

        bc.getData().addAll(series_minus,series_plus);
        getChildren().add(bc);
    }
}
