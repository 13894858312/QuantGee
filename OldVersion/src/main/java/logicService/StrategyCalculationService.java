package logicService;

import vo.*;

/**
 * Created by Mark.W on 2017/3/23.
 */
public interface StrategyCalculationService {

    /**
     * 策略回测
     * 计算累计收益率的图和频率分布直方图
     * @param strategyInputVO 股票信息
     * @return BackTestingResultVO
     */
    public BackTestingResultVO getStrategyBackTestingGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO);

    /**
     * 计算收益率和策略胜率的图
     * @param strategyType 策略类型
     * @param strategyInputVO 股票信息
     * @param isHoldingPeriod period参数是否是持有期，true为持有期，false为形成期
     * @return AbnormalReturnGraphVO
     */
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyType strategyType,StrategyInputVO strategyInputVO, boolean isHoldingPeriod);
}
