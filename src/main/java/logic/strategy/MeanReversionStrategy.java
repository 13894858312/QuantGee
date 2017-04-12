package logic.strategy;

import vo.AbnormalReturnGraphVO;
import vo.BackTestingResultVO;
import vo.StrategyInputVO;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
public class MeanReversionStrategy implements Strategy {

    @Override
    public BackTestingResultVO getStrategyBackTestingGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO) {

        MeanReversionBackTesting meanReversionBackTesting = new MeanReversionBackTesting(stockPool, strategyInputVO.holdingPeriod,
                strategyInputVO.returnPeriod, strategyInputVO.holdingStockNum);

        meanReversionBackTesting.start();

        BackTestingResultVO backTestingResultVO = meanReversionBackTesting.getBackTestingResultVO();

        return backTestingResultVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {

        MeanReversionAbnormalReturn meanReversionAbnormalReturn = new MeanReversionAbnormalReturn(stockPool, period, isHoldingPeriod);

        meanReversionAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = meanReversionAbnormalReturn.getAbnormalReturnGraphVO();

        return abnormalReturnGraphVO;
    }

}
