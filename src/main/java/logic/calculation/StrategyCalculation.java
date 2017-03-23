package logic.calculation;

import logicService.StrategyCalculationService;
import vo.*;

/**
 * Created by Mark.W on 2017/3/23.
 */
public class StrategyCalculation implements StrategyCalculationService{
    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO) {
        return null;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        return null;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO) {
        return null;
    }
}
