package view.controller;

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

    public Search(StrategyType strategyType , StrategyInputVO strategyInputVO , boolean isHold){
        strategyCalculationService = new StrategyCalculation();
        this.strategyType = strategyType;
        this.strategyInputVO = strategyInputVO;
        this.isHold = isHold;
    }

    @Override
    public Object call() {
        BackTestingResultVO backTestingResultVO = strategyCalculationService
                .getStrategyBackTestingGraphInfo(strategyType , strategyInputVO );
        AbnormalReturnGraphVO abnormalReturnGraphVO = strategyCalculationService.getAbnormalReturnGraphInfo(strategyType , strategyInputVO , isHold);

        return new AandBVO(backTestingResultVO ,abnormalReturnGraphVO);
    }


}
