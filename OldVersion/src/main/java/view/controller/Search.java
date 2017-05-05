package view.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.calculation.StrategyCalculation;
import logicService.StrategyCalculationService;
import vo.*;

import java.util.concurrent.Callable;

/**
 * Created by wangxue on 2017/4/18.
 */
public class Search extends Thread {

    private StrategyCalculationService strategyCalculationService;
    private StrategyType strategyType;
    private StrategyInputVO strategyInputVO;
    private boolean isHold;
    private Pane root;
    private MainPageController mainPageController;

    private BackTestingResultVO backTestingResultVO;
    private AbnormalReturnGraphVO abnormalReturnGraphVO;

    public Search(StrategyType strategyType , StrategyInputVO strategyInputVO , boolean isHold , Pane root , MainPageController mainPageController){
        strategyCalculationService = new StrategyCalculation();
        this.strategyType = strategyType;
        this.strategyInputVO = strategyInputVO;
        this.isHold = isHold;
        this.root = root;
        this.mainPageController = mainPageController;
    }

    @Override
    public void run() {
         try {
             backTestingResultVO = strategyCalculationService
                    .getStrategyBackTestingGraphInfo(strategyType, strategyInputVO);
             abnormalReturnGraphVO = strategyCalculationService.getAbnormalReturnGraphInfo(strategyType, strategyInputVO, isHold);

            if (backTestingResultVO == null || strategyInputVO == null) {throw new Exception();}

         }catch (Exception e){
             mainPageController.showMessage("无数据");
             ((Stage) root.getScene().getWindow()).close();
             return;
         }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/fxml/StrategyPane.fxml"));
                    Pane right = fxmlLoader.load();
                    StrategyPaneController strategyPaneController = fxmlLoader.getController();

                    strategyPaneController.init(backTestingResultVO , abnormalReturnGraphVO , isHold);
                    mainPageController.showRightPane(right);

                    ((Stage)root.getScene().getWindow()).close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        return;

    }


}
