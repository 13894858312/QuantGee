package logic.strategy;

import logic.tools.DateHelper;
import vo.*;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
public class MomentumDriveStrategy implements Strategy {

    private StockPool stockPool;

    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyInputVO strategyInputVO) {

        this.initStockPool(strategyInputVO);

        MomentumCumlativeYield momentumCumlativeYield = new MomentumCumlativeYield(stockPool,
                strategyInputVO.holdingPeriod, strategyInputVO.returnPeriod, strategyInputVO.holdingStockNum);

        momentumCumlativeYield.start();

        CumulativeYieldGraphVO cumulativeYieldGraphVO = momentumCumlativeYield.getCumulativeYieldGraphVO();

        return cumulativeYieldGraphVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        this.initStockPool(strategyInputVO);

        MomentumAbnormalReturn momentumAbnormalReturn = new MomentumAbnormalReturn(stockPool, period, isHoldingPeriod);

        momentumAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = momentumAbnormalReturn.getAbnormalReturnGraphVO();
        return abnormalReturnGraphVO;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyInputVO strategyInputVO) {
        this.initStockPool(strategyInputVO);

        MomentumYieldHistogram momentumYieldHistogram = new MomentumYieldHistogram(stockPool);

        momentumYieldHistogram.start();

        YieldHistogramGraphVO yieldHistogramGraphVO = momentumYieldHistogram.getYieldHistogramGraphVO();

        return yieldHistogramGraphVO;
    }

    private void initStockPool(StrategyInputVO strategyInputVO) {
        if(stockPool == null) {
            stockPool = new StockPool(strategyInputVO);
        } else {

            String s1 = DateHelper.getInstance().dateTransToString(stockPool.getStartDate());
            String e1 = DateHelper.getInstance().dateTransToString(stockPool.getEndDate());

            String s2 = DateHelper.getInstance().dateTransToString(strategyInputVO.startDate);
            String e2 = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);

            if(!(s1.equals(s2) && e1.equals(e2))) {
                stockPool = new StockPool(strategyInputVO);
            }

        }
    }

}
