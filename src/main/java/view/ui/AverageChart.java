package view.ui;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import view.controller.SearchSharesController;
import javafx.scene.chart.XYChart;
import vo.AverageLineVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */
public class AverageChart {

    private SearchSharesController searchSharesController;

    public AverageChart(SearchSharesController searchSharesController){
        this.searchSharesController = searchSharesController;

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Day");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price");
        yAxis.setForceZeroInRange(false);

        //chart
        final LineChart<String, Number> averageLineChart = new LineChart<String, Number>(xAxis, yAxis);
        averageLineChart.setTitle("AverageLine Chart");

        //date
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("My portfolio");

    }

    private ArrayList<AverageLineVO> getAverageLineDate(){
        return null;
    }
}
