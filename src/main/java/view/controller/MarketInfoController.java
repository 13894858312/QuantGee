package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import logic.calculation.DataCalculation;
import logicService.DataCalculationService;
import view.UI.MarketThermometer;
import view.graph.Graph;
import vo.MarketInfoVO;

import java.util.Date;
import java.util.DoubleSummaryStatistics;

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

        date.setText(marketInfoVO.date.toString());
        all.setText(Double.toString(marketInfoVO.volume));
        larger.setText(Integer.toString(marketInfoVO.greaterThanFiveNum));
        smaller.setText(Integer.toString(marketInfoVO.lessThanFiveNum));

        chart.getChildren().add(marketThermometer);

        return;

    }

}
