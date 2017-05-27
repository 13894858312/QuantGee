package service.strategy;


import vo.strategy.AbnormalReturnGraphVO;
import vo.strategy.StrategyBackTestInputVO;
import vo.strategy.StrategyBackTestResultVO;

/**
 * Created by Mark.W on 2017/5/5.
 * 股票回测的接口
 */
public interface StrategyBackTestingService {

    /**
     * 股票回测
     * @param inputVO 策略回测输入信息
     * @return  StrategyBackTestResultVO
     */
    public StrategyBackTestResultVO getStrategyBackTesting(StrategyBackTestInputVO inputVO);

    /**
     * 计算收益率和策略胜率的图
     * @param inputVO 股票信息
     * @return AbnormalReturnGraphVO
     */
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyBackTestInputVO inputVO);
}
