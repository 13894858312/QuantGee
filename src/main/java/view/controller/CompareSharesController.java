package view.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import logic.calculation.GraphCalculation;
import logic.tools.AverageLineType;
import logicService.GraphCalculationService;
import view.graph.Graph;
import vo.StockVO;

import java.util.Date;

/**
 * Created by wangxue on 2017/3/9.
 */
public class CompareSharesController {

    private GraphCalculationService graphCalculationService;
    private Graph graph;
    private Date start;
    private Date end;
    private StockVO stockVO_0;
    private StockVO stockVO_1;

    @FXML
    private Label name_left;
    @FXML
    private Label num_left;
    @FXML
    private Label name_right;
    @FXML
    private Label num_right;

    @FXML
    private Button kLineLeft;
    @FXML
    private Button dayLineLeft;
    @FXML
    private Button quarterLineLeft;
    @FXML
    private Button yearLineLeft;
    @FXML
    private Button yieldLineLeft;

    @FXML
    private Button kLineRight;
    @FXML
    private Button dayLineRight;
    @FXML
    private Button quarterLineRight;
    @FXML
    private Button yearLineRight;
    @FXML
    private Button yieldLineRight;

    @FXML
    private Pane leftChart;
    @FXML
    private Pane rightChart;

    @FXML
    private Pane highest;
    @FXML
    private Pane lowest;
    @FXML
    private Pane variance;

    public CompareSharesController(){

        graphCalculationService = new GraphCalculation();
        graph = new Graph();

    }

    public void init(StockVO stockVO_0, StockVO stockVO_1, Date start, Date end) {

        this.stockVO_0 = stockVO_0;
        this.stockVO_1 = stockVO_1;
        this.start = start;
        this.end = end;

        name_left.setText(stockVO_0.stockName);
        num_left.setText(stockVO_0.stockCode);

        name_right.setText(stockVO_1.stockName);
        num_right.setText(stockVO_1.stockCode);

        showLeftKLine();
        showRightKLine();

        kLineLeft.setDefaultButton(true);
        kLineRight.setDefaultButton(true);

        showHighest();
        showLowest();
        showVariance();

    }

    @FXML
    private void showLeftKLine() {
        Pane kLinePane;

        try{
            kLinePane = graph.getKLineChart(graphCalculationService.getKLineInfoByCode(start,end,stockVO_0.stockCode));
            leftChart.getChildren().clear();
            leftChart.getChildren().add(kLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void showLeftDayLine() {
        drawLeftAveLine(AverageLineType.DAYS_5);
    }

    @FXML
    private void showLeftQuarterLine() {
        drawLeftAveLine(AverageLineType.DAYS_60);
    }

    @FXML
    private void showLeftYearLine() {
        drawLeftAveLine(AverageLineType.DAYS_240);
    }

    @FXML
    private void showLeftYieldLine() {

    }

    @FXML
    private void showRightKLine() {

        Pane kLinePane;

        try{
            kLinePane = graph.getKLineChart(graphCalculationService.getKLineInfoByCode(start,end,stockVO_1.stockCode));
            rightChart.getChildren().clear();
            rightChart.getChildren().add(kLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void showRightDayLine() {
        drawLeftAveLine(AverageLineType.DAYS_5);
    }

    @FXML
    private void showRightQuarterLine() {
        drawLeftAveLine(AverageLineType.DAYS_60);
    }

    @FXML
    private void showRightYearLine() {
        drawLeftAveLine(AverageLineType.DAYS_240);
    }

    @FXML
    private void showRightYieldLine() {
//待补充
    }
//待讨论
    private void showHighest(){

    }
//待讨论
    private void showLowest(){

    }

//待讨论
    private void showVariance(){

        Pane yieldLinePane;

        try{
            yieldLinePane = graph.getLogYieldVarCompareChart(stockVO_0,stockVO_1);
            leftChart.getChildren().clear();
            leftChart.getChildren().add(yieldLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void drawLeftAveLine(AverageLineType averageLineType) {

        Pane aveLinePane;

        try {
            aveLinePane = graph.getAverageLineChart(graphCalculationService.getAverageLineInfoByCode(start, end, stockVO_0.stockCode, averageLineType));
            leftChart.getChildren().clear();
            rightChart.getChildren().add(aveLinePane);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    private void drawRightAveLine(AverageLineType averageLineType){

        Pane aveLinePane;

        try{
            aveLinePane = graph.getAverageLineChart(graphCalculationService.getAverageLineInfoByCode(start,end,stockVO_1.stockCode,averageLineType));
            rightChart.getChildren().clear();
            rightChart.getChildren().add(aveLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }
        return;
    }
}