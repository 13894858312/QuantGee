package logic.strategy;

import vo.*;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
public class MomentumDriveStrategy implements Strategy {

    @Override
    public BackTestingResultVO getStrategyBackTestingGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO) {

        MomentumBackTesting momentumBackTesting = new MomentumBackTesting(stockPool,
                strategyInputVO.holdingPeriod, strategyInputVO.returnPeriod);

        momentumBackTesting.start();

        BackTestingResultVO backTestingResultVO = momentumBackTesting.getBackTestingResultVO();

        return backTestingResultVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO,  boolean isHoldingPeriod) {

        int period;
        if(isHoldingPeriod) {
            period = strategyInputVO.holdingPeriod;
        } else {
            period = strategyInputVO.returnPeriod;
        }

        MomentumAbnormalReturn momentumAbnormalReturn = new MomentumAbnormalReturn(stockPool, period, isHoldingPeriod);

        momentumAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = momentumAbnormalReturn.getAbnormalReturnGraphVO();
        return abnormalReturnGraphVO;
    }

}
