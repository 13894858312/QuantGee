package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import view.UI.MarketThermometer;
import view.graph.Graph;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wangxue on 2017/3/9.
 */
public class MarketInfoController {


    Graph graph;

    @FXML private Label date;
    @FXML private Label all;
    @FXML private Label larger;
    @FXML private Label smaller;

    @FXML private Pane chart;

    public MarketInfoController(){
        graph = new Graph();
    }

    public void init(MarketInfoVO marketInfoVO){


        graph = new Graph();

        MarketThermometer marketThermometer = graph.getMarketThermometerChart(marketInfoVO);

        BigDecimal bd = new BigDecimal(marketInfoVO.volume);


        Date d = marketInfoVO.date;
        String str = " " +( d.getYear() +1900 ) + " 年 " + ( d.getMonth()+1 ) + " 月 " + d.getDate() + " 日 星期 " + d.getDay() ;

        date.setText(str);
        all.setText(bd.toPlainString());
        larger.setText(Integer.toString(marketInfoVO.greaterThanFiveNum));
        smaller.setText(Integer.toString(marketInfoVO.lessThanFiveNum));

        chart.getChildren().add(marketThermometer);

        return;

    }

}
