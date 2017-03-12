package view.controller;

import dataDao.StockDataDao;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import logic.calculation.GraphCalculation;
import logic.tools.DateHelper;
import logicService.GraphCalculationService;
import vo.KLineVO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
//    private StockDataDao stockDataDao;

    public void init(){
//        graphCalculation = new GraphCalculation(stockDataDao);
        mainPageController = new MainPageController();
    }

    public ArrayList<KLineVO> getKlineVoList() throws Exception{
        String startTime = mainPageController.getStartTime();
        String endTime = mainPageController.getEndTime();
        ArrayList<KLineVO> kLineVOArrayList = graphCalculation.getKLineInfoByName(DateHelper.getInstance().stringTransToDate(startTime),
                DateHelper.getInstance().stringTransToDate(endTime), name.getText());
        return kLineVOArrayList;
    }
}
