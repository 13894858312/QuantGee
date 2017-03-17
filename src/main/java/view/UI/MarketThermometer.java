package view.UI;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import view.controller.MarketInfoController;
import vo.MarketInfoVO;

/**
 * Created by Administrator on 2017/3/10.
 */
public class MarketThermometer extends Pane {

    public MarketThermometer(MarketInfoVO marketInfoVO){

        this.getStylesheets().add("/css/marketThermometer.css");
        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Share Type");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number Of Shares");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setPrefSize(700,500);
        bc.setCategoryGap(30);
        bc.setTitle("MarketThermometer");
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("Number Of Shares");
        series.getData().add(new XYChart.Data<String, Number>("跌停\n"+"   ("+marketInfoVO.rateNums[0]+")", marketInfoVO.rateNums[0]));
        series.getData().add(new XYChart.Data<String, Number>("跌幅5%-10%\n"+"   ("+marketInfoVO.rateNums[1]+")", marketInfoVO.rateNums[1]));
        series.getData().add(new XYChart.Data<String, Number>("跌幅0-5%\n"+"   ("+marketInfoVO.rateNums[2]+")", marketInfoVO.rateNums[2]));
        series.getData().add(new XYChart.Data<String, Number>("涨幅0-5%\n"+"   ("+marketInfoVO.rateNums[3]+")", marketInfoVO.rateNums[3]));
        series.getData().add(new XYChart.Data<String, Number>("涨幅5%-10%\n"+"   ("+marketInfoVO.rateNums[4]+")", marketInfoVO.rateNums[4]));
        series.getData().add(new XYChart.Data<String, Number>("涨停\n"+"   ("+marketInfoVO.rateNums[5]+")", marketInfoVO.rateNums[5]));
        series.getData().add(new XYChart.Data<String, Number>("开收>5%\n"+"   ("+marketInfoVO.greaterThanFiveNum+")", marketInfoVO.greaterThanFiveNum));
        series.getData().add(new XYChart.Data<String, Number>("开收<-5%\n"+"   ("+marketInfoVO.lessThanFiveNum+")", marketInfoVO.lessThanFiveNum));

        bc.getData().addAll(series);

        getChildren().add(bc);
    }

}
