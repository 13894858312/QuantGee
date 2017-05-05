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
 * Created by Administrator on 2017/3/11.
 */
public class Price_Compare extends Pane{

    public Price_Compare(ArrayList<StockVO> stockVOArrayList, int width, int height){

        this.getStylesheets().add("/css/price_Compare.css");

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("股票名称");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("价格");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setCategoryGap(20);
        bc.setBarGap(3);
        bc.setPrefSize(width, height);

        //data
        XYChart.Series<String, Number> series_MaxPrice = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_MinPrice = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series_ClosePrice = new XYChart.Series<String, Number>();
        series_MaxPrice.setName("最高价");
        series_MinPrice.setName("最低价");
        series_ClosePrice.setName("收盘价");
        for(int i=0;i<stockVOArrayList.size();i++){
            StockVO stockVO = stockVOArrayList.get(i);
            ArrayList<StockDailyInfoVO> stockDailyInfoVOArrayList = stockVO.stockDailyInfoVOs;
            for(int j=0;j<stockDailyInfoVOArrayList.size();j++) {
                series_MaxPrice.getData().add(new XYChart.Data<String, Number>(stockVO.stockName+"\n"+"("+stockVO.maxValue+")"+"\n"+"("+stockVO.minValue+")"+"\n"+"("+stockDailyInfoVOArrayList.get(i).closePrice+")", stockVO.maxValue));
                series_MinPrice.getData().add(new XYChart.Data<String, Number>(stockVO.stockName+"\n"+"("+stockVO.maxValue+")"+"\n"+"("+stockVO.minValue+")"+"\n"+"("+stockDailyInfoVOArrayList.get(i).closePrice+")", stockVO.minValue));
                series_ClosePrice.getData().add(new XYChart.Data<String, Number>(stockVO.stockName+"\n"+"("+stockVO.maxValue+")"+"\n"+"("+stockVO.minValue+")"+"\n"+"("+stockDailyInfoVOArrayList.get(i).closePrice+")", stockDailyInfoVOArrayList.get(i).closePrice));
            }
        }

        bc.getData().addAll(series_MaxPrice, series_MinPrice, series_ClosePrice);
        getChildren().add(bc);
    }
}
