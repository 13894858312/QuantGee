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
 * Created by Administrator on 2017/3/11.
 */
public class Price_Compare extends Pane{

    public Price_Compare(ArrayList<StockVO> stockVOArrayList, ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList){

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Name Of Share");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Comparision Of Price");

        //data
        XYChart.Series<String, Number> series_MaxPrice = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_MinPrice = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_ClosePrice = new XYChart.Series<String, Number>();
        series_MaxPrice.setName("MaxPrice");
        series_MinPrice.setName("MinPrice");
        series_ClosePrice.setName("ClosePrice");
        for(int i=0;i<stockVOArrayList.size();i++){
            StockVO stockVO = stockVOArrayList.get(i);
            StockDailyInfoVO stockDailyInfoVO = stockDailyInfoVOArrayList.get(i);
            series_MaxPrice.getData().add(new XYChart.Data<String, Number>(stockVO.stockName, stockVO.maxValue));
            series_MinPrice.getData().add(new XYChart.Data<String, Number>(stockVO.stockName, stockVO.minValue));
            series_ClosePrice.getData().add(new XYChart.Data<String, Number>(stockVO.stockName, stockDailyInfoVO.closePrice));
        }

        bc.getData().addAll(series_MaxPrice, series_MinPrice, series_ClosePrice);
        getChildren().add(bc);
    }
}
