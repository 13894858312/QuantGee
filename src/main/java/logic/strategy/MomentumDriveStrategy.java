package logic.strategy;

import logic.tools.DateHelper;
import vo.*;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
public class MomentumDriveStrategy implements Strategy {

    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO) {


        MomentumCumlativeYield momentumCumlativeYield = new MomentumCumlativeYield(stockPool,
                strategyInputVO.holdingPeriod, strategyInputVO.returnPeriod, strategyInputVO.holdingStockNum);

        momentumCumlativeYield.start();

        CumulativeYieldGraphVO cumulativeYieldGraphVO = momentumCumlativeYield.getCumulativeYieldGraphVO();

        return cumulativeYieldGraphVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {

        MomentumAbnormalReturn momentumAbnormalReturn = new MomentumAbnormalReturn(stockPool, period, isHoldingPeriod);

        momentumAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = momentumAbnormalReturn.getAbnormalReturnGraphVO();
        return abnormalReturnGraphVO;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO) {

        MomentumYieldHistogram momentumYieldHistogram = new MomentumYieldHistogram(stockPool);

        momentumYieldHistogram.start();

        YieldHistogramGraphVO yieldHistogramGraphVO = momentumYieldHistogram.getYieldHistogramGraphVO();

        return yieldHistogramGraphVO;
    }

}
