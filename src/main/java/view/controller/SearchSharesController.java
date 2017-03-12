package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
public class SearchSharesController {

    private GraphCalculationService graphCalculationService;
    private Graph graph;

    private StockVO stockVO;
    private Date start;
    private Date end;

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

        name.setText(stockVO.stockName);
        num.setText(stockVO.stockCode);

        kLine.setDefaultButton(true);

        showKLine();

    }

    @FXML
    private void showKLine() {

        Pane kLinePane;

        try{
             kLinePane = graph.getKLineChart(graphCalculationService.getKLineInfoByCode(start,end,stockVO.stockCode));
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
            aveLinePane = graph.getAverageLineChart(graphCalculationService.getAverageLineInfoByCode(start,end,stockVO.stockCode,averageLineType));
            chart.getChildren().clear();
            chart.getChildren().add(aveLinePane);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
