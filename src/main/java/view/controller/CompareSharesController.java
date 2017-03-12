package view.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * Created by wangxue on 2017/3/9.
 */
public class CompareSharesController {

    @FXML private Label name_left;
    @FXML private Label num_left;
    @FXML private Label name_right;
    @FXML private Label num_right;

    @FXML private Button kLineLeft;
    @FXML private Button dayLineLeft;
    @FXML private Button quarterLineLeft;
    @FXML private Button yearLineLeft;
    @FXML private Button yieldLineLeft;

    @FXML private Button kLineRight;
    @FXML private Button dayLineRight;
    @FXML private Button quarterLineRight;
    @FXML private Button yearLineRight;
    @FXML private Button yieldLineRight;

    @FXML private Pane highest;
    @FXML private Pane lowest;
    @FXML private Pane variance;

    public void init(){

    }

    @FXML
    private void showLeftKLine() {
    }

    @FXML
    private void showLeftDayLine() {
    }

    @FXML
    private void showLeftQuarterLine() {
    }

    @FXML
    private void showLeftYearLine() {
    }

    @FXML
    private void showLeftYieldLine() {
    }

    @FXML
    private void showRightKLine() {
    }

    @FXML
    private void showRightDayLine() {
    }

    @FXML
    private void showRightQuarterLine() {
    }

    @FXML
    private void showRightYearLine() {
    }

    @FXML
    private void showRightYieldLine() {
    }

}
