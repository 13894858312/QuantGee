package service.strategy;


import vo.strategy.StrategyBackTestInputVO;
import vo.strategy.StrategyBackTestingVO;

/**
 * Created by Mark.W on 2017/5/5.
 * 股票回测的接口
 */
public interface StrategyBackTestingService {

    /**
     * 股票回测
     * @param inputVO 策略回测输入信息
     * @return  StrategyBackTestingVO
     */
    public StrategyBackTestingVO getStrategyBackTesting(StrategyBackTestInputVO inputVO);
}
