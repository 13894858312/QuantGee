package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import logic.calculation.GraphCalculation;
import logic.tools.AverageLineType;
import logicService.GraphCalculationService;
import view.UI.AdvCandleStickChart;
import view.graph.Graph;
import vo.StockVO;

import java.util.Date;

/**
 * Created by wangxue on 2017/3/9.
 */
public class SearchSharesController {

    private GraphCalculationService graphCalculationService;
    private Graph graph;

    private StockVO stockVO;
    private Date start;
    private Date end;
    private long gap;

    @FXML private Label name;
    @FXML private Label num;

    @FXML private Pane chart;

    @FXML private Button kLine;
    @FXML private Button dayLine;
    @FXML private Button quarterLine;
    @FXML private Button yearLine;

    public SearchSharesController(){

        graphCalculationService = new GraphCalculation();
        graph = new Graph();

    }

    public void init(StockVO stockVO, Date start, Date end){

        this.stockVO = stockVO;
        this.start = start;
        this.end = end;

        dayLine.setDisable(true);
        quarterLine.setDisable(true);
        yearLine.setDisable(true);

        gap = ( end.getTime() - start.getTime() )/1000/60/60/24;

        if(gap>10){
            dayLine.setDisable(false);
        }
        if(gap>90){
            quarterLine.setDisable(false);
        }
        if(gap>360){
            yearLine.setDisable(false);
        }

        name.setText(stockVO.stockName);
        num.setText(stockVO.stockCode);

        kLine.setDefaultButton(true);

        showKLine();

    }

    @FXML
    private void showKLine() {

        Pane kLinePane;

        try{
             kLinePane = graph.getKLineChart(graphCalculationService.getKLineInfoByCode(start,end,stockVO.stockCode), graphCalculationService.getAverageLineInfoByCode(start, end, stockVO.stockCode,AverageLineType.DAYS_5),null,null,680, 600);
             chart.getChildren().clear();
             chart.getChildren().add(kLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void showDayLine(){
        drawAveLine(AverageLineType.DAYS_5);
    }

    @FXML
    private void showQuarterLine(){
        drawAveLine(AverageLineType.DAYS_60);
    }

    @FXML
    private void showYearLine(){
        drawAveLine(AverageLineType.DAYS_240);
    }

    private void drawAveLine(AverageLineType averageLineType){

        Pane aveLinePane;

        try{
            aveLinePane = graph.getAverageLineChart(graphCalculationService.getAverageLineInfoByCode(start,end,stockVO.stockCode,averageLineType),680, 600);
            chart.getChildren().clear();
            chart.getChildren().add(aveLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
