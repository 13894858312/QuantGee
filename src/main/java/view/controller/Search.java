package view.controller;

import javafx.application.Platform;
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
public class Search implements Callable {

    private StrategyCalculationService strategyCalculationService;
    private StrategyType strategyType;
    private StrategyInputVO strategyInputVO;
    private boolean isHold;
    private Pane root;

    public Search(StrategyType strategyType , StrategyInputVO strategyInputVO , boolean isHold , Pane root){
        strategyCalculationService = new StrategyCalculation();
        this.strategyType = strategyType;
        this.strategyInputVO = strategyInputVO;
        this.isHold = isHold;
        this.root = root;
    }

    @Override
    public Object call() {
        BackTestingResultVO backTestingResultVO = strategyCalculationService
                .getStrategyBackTestingGraphInfo(strategyType , strategyInputVO );
        AbnormalReturnGraphVO abnormalReturnGraphVO = strategyCalculationService.getAbnormalReturnGraphInfo(strategyType , strategyInputVO , isHold);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                ((Stage)root.getScene().getWindow()).close();

            }
        });

        return new AandBVO(backTestingResultVO ,abnormalReturnGraphVO);
    }


}
