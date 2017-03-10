package view.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;

/**
 * Created by wangxue on 2017/3/9.
 */
public class CompareSharesController {

    @FXML private Label name_left;
    @FXML private Label num_left;
    @FXML private Label name_right;
    @FXML private Label num_right;

    @FXML private LineChart kLine_left;
    @FXML private LineChart dayLine_left;
    @FXML private LineChart quarterLine_left;
    @FXML private LineChart yearLine_left;
    @FXML private LineChart yield_left;

    @FXML private LineChart kLine_right;
    @FXML private LineChart dayLine_right;
    @FXML private LineChart quarterLine_right;
    @FXML private LineChart yearLine_right;
    @FXML private LineChart yield_right;

    @FXML private BarChart highest;
    @FXML private BarChart lowest;
    @FXML private BarChart variance;

    public void init(){

    }

}
