package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import logic.calculation.StrategyCalculation;
import logicService.StrategyCalculationService;
import view.graph.Graph;
import vo.*;

import javax.xml.crypto.dom.DOMCryptoContext;


/**
 * 展示策略的三个图
 * Created by wangxue on 2017/3/31.
 */
public class StrategyPaneController {

    StrategyCalculationService strategyCalculationService;

    Graph graph ;

    @FXML
    private AnchorPane graphA;
    @FXML
    private AnchorPane graphB_0;
    @FXML
    private AnchorPane graphB_1;
    @FXML
    private AnchorPane graphC;

    @FXML
    private Label year;
    @FXML
    private Label base;

    @FXML
    private Label sharp;
    @FXML
    private Label alpha;
    @FXML
    private Label beta;
//    @FXML
//    private Label volatility;
//    @FXML
//    private Label message;
    @FXML
    private Label max;
//    @FXML
//    private Label turnover;

    @FXML
    private Label positive;
    @FXML
    private Label negative;
    @FXML
    private Label win;

    public StrategyPaneController(){

        strategyCalculationService = new StrategyCalculation();
        graph = new Graph();

    }

    public void init(BackTestingResultVO backTestingResultVO ,
                     AbnormalReturnGraphVO abnormalReturnGraphVO ){

        CumulativeYieldGraphVO cumulativeYieldGraphVO = backTestingResultVO.cumulativeYieldGraphVO;
        YieldHistogramGraphVO yieldHistogramGraphVO = backTestingResultVO.yieldHistogramGraphVO;

        //a
        year.setText(Double.toString(cumulativeYieldGraphVO.annualRevenue * 100));
        base.setText(Double.toString(cumulativeYieldGraphVO.baseAnnualRevenue * 100));
        sharp.setText(Double.toString(cumulativeYieldGraphVO.sharpeRatio * 100));
        alpha.setText(Double.toString(cumulativeYieldGraphVO.alpha * 100));
        beta.setText(Double.toString(cumulativeYieldGraphVO.beta * 100));
        max .setText(Double.toString(cumulativeYieldGraphVO.maxDrawdown * 100));

        Pane a = graph.getCumulativeYieldChart(cumulativeYieldGraphVO.baseCumulativeYieldGraphDataVOS , cumulativeYieldGraphVO.cumulativeYieldGraphDataVOS ,660 , 400);
        graphA.getChildren().addAll(a);

        //b0
        Pane b0 = graph.getExcessEarning(true , abnormalReturnGraphVO.abnormalReturnGraphDataVOS , 600 , 360);
        graphB_0.getChildren().addAll(b0);
        //b1
        Pane b1 = graph.getWinningStrategy(true , abnormalReturnGraphVO.abnormalReturnGraphDataVOS , 600 , 360);
        graphB_1.getChildren().addAll(b1);

        //c
        positive.setText(Double.toString(yieldHistogramGraphVO.positiveEarningNum));
        negative.setText(Double.toString(yieldHistogramGraphVO.negativeEarningNum));
        win.setText(Double.toString(yieldHistogramGraphVO.winRate * 100));

        Pane c = graph.getDistributionYield(yieldHistogramGraphVO.yieldHistogramGraphDataVOS , 660 , 400 );
        graphC.getChildren().addAll(c);

    }

}
