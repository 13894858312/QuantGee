package logic.strategy;

import vo.AbnormalReturnGraphVO;
import vo.CumulativeYieldGraphVO;
import vo.StrategyInputVO;
import vo.YieldHistogramGraphVO;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
public class MeanReversionStrategy implements Strategy {

    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO) {

        MeanReversionCumlativeYield meanReversionCumlativeYield = new MeanReversionCumlativeYield(stockPool, strategyInputVO.holdingPeriod,
                strategyInputVO.returnPeriod, strategyInputVO.holdingStockNum);

        meanReversionCumlativeYield.start();

        CumulativeYieldGraphVO cumulativeYieldGraphVO = meanReversionCumlativeYield.getCumulativeYieldGraphVO();

        return cumulativeYieldGraphVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {

        MeanReversionAbnormalReturn meanReversionAbnormalReturn = new MeanReversionAbnormalReturn(stockPool, period, isHoldingPeriod);

        meanReversionAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = meanReversionAbnormalReturn.getAbnormalReturnGraphVO();

        return abnormalReturnGraphVO;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO) {

        MeanReversionYieldHistogram meanReversionYieldHistogram = new MeanReversionYieldHistogram(stockPool);

        meanReversionYieldHistogram.start();

        YieldHistogramGraphVO yieldHistogramGraphVO = meanReversionYieldHistogram.getYieldHistogramGraphVO();

        return yieldHistogramGraphVO;
    }

}
