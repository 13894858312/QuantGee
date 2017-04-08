package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import logic.calculation.GraphCalculation;
import logic.tools.AverageLineType;
import logicService.GraphCalculationService;
import view.graph.Graph;
import vo.StockDailyInfoVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wangxue on 2017/3/9.
 */
public class CompareSharesController {

    private GraphCalculationService graphCalculationService;
    private Graph graph;
    private Date start;
    private Date end;
    private long gap;
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

        dayLineLeft.setDisable(true);
        dayLineRight.setDisable(true);
        quarterLineLeft.setDisable(true);
        quarterLineRight.setDisable(true);
        yearLineLeft.setDisable(true);
        yearLineRight.setDisable(true);

        gap = (end.getTime()-start.getTime())/1000/60/60/24;

        if(gap>10){
            dayLineLeft.setDisable(false);
            dayLineRight.setDisable(false);
        }
        if(gap>90){
            quarterLineLeft.setDisable(false);
            quarterLineRight.setDisable(false);
        }
        if(gap>360){
            yearLineLeft.setDisable(false);
            yearLineRight.setDisable(false);
        }

        name_left.setText(stockVO_0.stockName);
        num_left.setText(stockVO_0.stockCode);

        name_right.setText(stockVO_1.stockName);
        num_right.setText(stockVO_1.stockCode);

        showLeftKLine();
        showRightKLine();

        kLineLeft.setDefaultButton(true);
        kLineRight.setDefaultButton(true);

        showFirst();
        showSecond();
        showThird();

    }

    @FXML
    private void showLeftKLine() {
        Pane kLinePane;

        try{
            kLinePane = graph.getKLineChart(graphCalculationService.getKLineInfoByCode(start,end,stockVO_0.stockCode),graphCalculationService.getAverageLineInfoByCode(start, end, stockVO_0.stockCode,AverageLineType.DAYS_5),null,null, 350, 300);
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

        Pane yieldPane;

        try{

            yieldPane = graph.getLogYieldCompareChart(stockVO_0.stockDailyInfoVOs, 350, 300);
            leftChart.getChildren().clear();
            leftChart.getChildren().add(yieldPane);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void showRightKLine() {

        Pane kLinePane;

        try{
            kLinePane = graph.getKLineChart(graphCalculationService.getKLineInfoByCode(start,end,stockVO_1.stockCode),graphCalculationService.getAverageLineInfoByCode(start, end, stockVO_1.stockCode,AverageLineType.DAYS_5),null,null, 350, 300);
            rightChart.getChildren().clear();
            rightChart.getChildren().add(kLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void showRightDayLine() {
        drawRightAveLine(AverageLineType.DAYS_10);
    }

    @FXML
    private void showRightQuarterLine() {
        drawRightAveLine(AverageLineType.DAYS_60);
    }

    @FXML
    private void showRightYearLine() {
        drawRightAveLine(AverageLineType.DAYS_240);
    }

    @FXML
    private void showRightYieldLine() {

        Pane yieldPane;

        try{

            yieldPane = graph.getLogYieldCompareChart(stockVO_1.stockDailyInfoVOs, 350, 300);
            rightChart.getChildren().clear();
            rightChart.getChildren().add(yieldPane);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showFirst(){

        Pane firstPane ;

        try{

            ArrayList<StockVO> stockVOS = new ArrayList<StockVO>();
            stockVOS.add(stockVO_0);
            stockVOS.add(stockVO_1);

            firstPane = graph.getPriceCompareChart(stockVOS,220, 250);
            highest.getChildren().clear();
            highest.getChildren().add(firstPane);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void showSecond(){

        Pane secondPane ;

        try {

            secondPane = graph.getRangeCompareChart(stockVO_0,stockVO_1,220,250);
            lowest.getChildren().clear();
            lowest.getChildren().add(secondPane);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

//待讨论
    private void showThird(){

        Pane yieldLinePane;

        try{
            yieldLinePane = graph.getLogYieldVarCompareChart(stockVO_0,stockVO_1,230, 250);
            variance.getChildren().clear();
            variance.getChildren().add(yieldLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void drawLeftAveLine(AverageLineType averageLineType) {

        Pane aveLinePane;

        try {
            aveLinePane = graph.getAverageLineChart(graphCalculationService.getAverageLineInfoByCode(start, end, stockVO_0.stockCode, averageLineType), 350, 300);
            leftChart.getChildren().clear();
            leftChart.getChildren().add(aveLinePane);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    private void drawRightAveLine(AverageLineType averageLineType){

        Pane aveLinePane;

        try{
            aveLinePane = graph.getAverageLineChart(graphCalculationService.getAverageLineInfoByCode(start,end,stockVO_1.stockCode,averageLineType), 350, 300);
            rightChart.getChildren().clear();
            rightChart.getChildren().add(aveLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }
        return;
    }

}