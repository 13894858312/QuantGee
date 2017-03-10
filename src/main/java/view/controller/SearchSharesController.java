package view.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Created by wangxue on 2017/3/9.
 */
public class SearchSharesController {

    @FXML private Label name;
    @FXML private Label num;

    @FXML private LineChart kLine;
    @FXML private LineChart dayLine;
    @FXML private LineChart quarterLine;
    @FXML private LineChart yearLine;

    public void init(){

    }

}
