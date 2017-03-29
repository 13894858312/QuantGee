package logic.calculation;

import logic.tools.StrategyFactory;
import logicService.StrategyCalculationService;
import vo.*;

/**
 * Created by Mark.W on 2017/3/23.
 */
public class StrategyCalculation implements StrategyCalculationService{

    private Strategy strategy;

    public StrategyCalculation() {
        this.strategy = new MomentumDriveStrategy();
    }

    /**
     * 计算累计收益率的图
     * @param strategyInputVO 股票信息
     * @return CumulativeYieldGraphVO
     */
    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO) {
        this.initStrategy(strategyType);
        CumulativeYieldGraphVO cumulativeYieldGraphVO = strategy.getCumulativeYieldGraphInfo(strategyInputVO);

        assert (cumulativeYieldGraphVO != null) : "logic.calculation.StrategyCalculation.getCumulativeYieldGraphInfo返回值异常" ;

        return cumulativeYieldGraphVO;
    }

    /**
     * 计算收益率和策略胜率的图
     * @param strategyType 策略类型
     * @param strategyInputVO 股票信息
     * @param period 周期
     * @param isHoldingPeriod period参数是否是持有期，true为持有期，false为形成期
     * @return AbnormalReturnGraphVO
     */
    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        this.initStrategy(strategyType);
        AbnormalReturnGraphVO abnormalReturnGraphVO = strategy.getAbnormalReturnGraphInfo(strategyInputVO, period, isHoldingPeriod);

        assert (abnormalReturnGraphVO != null) : "logic.calculation.StrategyCalculation.getAbnormalReturnGraphInfo返回值异常" ;

        return abnormalReturnGraphVO;
    }

    /**
     * 计算收益分布直方图
     * @param strategyType 策略类型
     * @param strategyInputVO 股票信息
     * @return YieldHistogramGraphVO
     */
    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO) {
        this.initStrategy(strategyType);
        YieldHistogramGraphVO yieldHistogramGraphVO = strategy.getYieldHistogramGraphInfo(strategyInputVO);

        assert (yieldHistogramGraphVO != null) : "logic.calculation.StrategyCalculation.getYieldHistogramGraphInfo返回值异常" ;

        return yieldHistogramGraphVO;
    }

    private void initStrategy(StrategyType strategyType) {
        this.strategy = StrategyFactory.getInstance().getStrategy(strategyType);

        assert (strategy != null) : "logic.calculation成员变量strategy异常" ;
    }
}
