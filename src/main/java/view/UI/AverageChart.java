package view.UI;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;
import logic.tools.DateHelper;
import javafx.scene.chart.XYChart;
import vo.AverageLineVO;
import vo.CumulativeYieldGraphDataVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */
public class AverageChart extends Pane{

//    public AverageChart(ArrayList<AverageLineVO> averageLineVOArrayList, int width, int height){
//
//            this.getStylesheets().add("/css/averageChart.css");
//            //x-xAxis
//            final CategoryAxis xAxis = new CategoryAxis();
//            xAxis.setLabel("Day");
//
//            //y-yAxis
//            final NumberAxis yAxis = new NumberAxis();
//            yAxis.setLabel("Price");
//            yAxis.setForceZeroInRange(false);
//
//            //chart
//            final LineChart<String, Number> averageLineChart = new LineChart<String, Number>(xAxis, yAxis);
//            averageLineChart.setPrefSize(width, height);
//            averageLineChart.setCreateSymbols(false);
//            averageLineChart.setTitle("AverageLine Chart");
//
//            //date
//            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
//            series.setName("Data");
//            for (int i = averageLineVOArrayList.size() - 1; i >= 0; i--) {
//                AverageLineVO averageLineVO = averageLineVOArrayList.get(i);
//                series.getData().add(new XYChart.Data<String, Number>(
//                        DateHelper.getInstance().dateTransToString(averageLineVO.date), averageLineVO.averageValue));
//            }
//
//            averageLineChart.getData().addAll(series);
//            getChildren().add(averageLineChart);
//    }

    //累计收益率
    public AverageChart(ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOArrayList1, ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOArrayList2
            , int width, int height){
            this.getStylesheets().add("/css/averageChart.css");
            //x-xAxis
            final CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Day");

            //y-yAxis
            final NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Cumulative Yield");
            yAxis.setForceZeroInRange(false);

            //chart
            final LineChart<String, Number> averageLineChart = new LineChart<String, Number>(xAxis, yAxis);
            averageLineChart.setPrefSize(width, height);
//            averageLineChart.setCreateSymbols(false);
            averageLineChart.setTitle("Cumulative Yield Graph");

            //date
            XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
            series1.setName("Basic Yield");
            for (int i = cumulativeYieldGraphDataVOArrayList1.size() - 1; i >= 0; i--) {
                CumulativeYieldGraphDataVO cumulativeYieldGraphDataVO = cumulativeYieldGraphDataVOArrayList1.get(i);
                series1.getData().add(new XYChart.Data<String, Number>(
                        DateHelper.getInstance().dateTransToString(cumulativeYieldGraphDataVO.date), cumulativeYieldGraphDataVO.ratio));
            }
            XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
            series2.setName("Strategy Yield");
            for (int i = cumulativeYieldGraphDataVOArrayList2.size() - 1; i >= 0; i--) {
                CumulativeYieldGraphDataVO cumulativeYieldGraphDataVO = cumulativeYieldGraphDataVOArrayList2.get(i);
                series2.getData().add(new XYChart.Data<String, Number>(
                    DateHelper.getInstance().dateTransToString(cumulativeYieldGraphDataVO.date), cumulativeYieldGraphDataVO.ratio));
            }


            averageLineChart.getData().addAll(series1,series2);
            getChildren().add(averageLineChart);
    }



}
