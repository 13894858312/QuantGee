package logic.strategy;

import vo.*;
import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
public class MomentumDriveStrategy implements Strategy {

    private StockPool stockPool;

    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyInputVO strategyInputVO) {

        stockPool = new StockPool(strategyInputVO);

        MomentumCumlativeYield momentumCumlativeYield = new MomentumCumlativeYield(stockPool);

        momentumCumlativeYield.start();

        CumulativeYieldGraphVO cumulativeYieldGraphVO = momentumCumlativeYield.getCumulativeYieldGraphVO();

        return cumulativeYieldGraphVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        stockPool = new StockPool(strategyInputVO);

        MomentumAbnormalReturn momentumAbnormalReturn = new MomentumAbnormalReturn(stockPool, period, isHoldingPeriod);

        momentumAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = momentumAbnormalReturn.getAbnormalReturnGraphVO();
        return abnormalReturnGraphVO;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyInputVO strategyInputVO) {
        stockPool = new StockPool(strategyInputVO);

        MomentumYieldHistogram momentumYieldHistogram = new MomentumYieldHistogram(stockPool);

        momentumYieldHistogram.start();

        YieldHistogramGraphVO yieldHistogramGraphVO = momentumYieldHistogram.getYieldHistogramGraphVO();

        return yieldHistogramGraphVO;
    }
}
