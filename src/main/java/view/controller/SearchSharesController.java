package view.controller;

import dataDao.StockDataDao;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import logic.calculation.GraphCalculation;
import logicService.GraphCalculationService;
import vo.KLineVO;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

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

    private GraphCalculationService graphCalculation;
    private MainPageController mainPageController;
    private StockDataDao stockDataDao;

    public void init(){
        graphCalculation = new GraphCalculation(stockDataDao);
        mainPageController = new MainPageController();
    }

    public ArrayList<KLineVO> getKlineVoList() throws Exception{
        String startTime = mainPageController.getStartTime();
        String endTime = mainPageController.getEndTime();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yy");
        ArrayList<KLineVO> kLineVOArrayList = graphCalculation.getKLineInfoByName(formatter.parse(startTime), formatter.parse(endTime), name.getText());

        return kLineVOArrayList;
    }
}
