package logic.strategy;

import vo.AbnormalReturnGraphVO;
import vo.CumulativeYieldGraphVO;
import vo.StrategyInputVO;
import vo.YieldHistogramGraphVO;

/**
 * Created by Mark.W on 2017/3/29.
 */
public class MeanReversionStrategy implements Strategy {
    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyInputVO strategyInputVO) {
        return null;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        return null;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyInputVO strategyInputVO) {
        return null;
    }
}
