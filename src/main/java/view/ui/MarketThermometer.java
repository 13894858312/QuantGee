package view.ui;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import view.controller.MarketInfoController;
import vo.MarketInfoVO;

/**
 * Created by Administrator on 2017/3/10.
 */
public class MarketThermometer {

    private MarketInfoController marketInfoController;

    public MarketThermometer(MarketInfoController marketInfoController){
        this.marketInfoController = marketInfoController;

        //x-xAxis
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Type");

        //y-yAxis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number Of Shares");

        //chart
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("MarketThermometer");
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
    }

    private MarketInfoVO getMarketInfo(){
        return null;
    }
}
