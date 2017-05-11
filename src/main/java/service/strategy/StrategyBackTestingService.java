package service.strategy;


import vo.strategy.StrategyBackTestingVO;

/**
 * Created by Mark.W on 2017/5/5.
 * 股票回测的接口
 */
public interface StrategyBackTestingService {

    /**
     * 股票回测
     * @param strategyID 策略ID
     * @return  StrategyBackTestingVO
     */
    public StrategyBackTestingVO getStrategyBackTesting(String strategyID);
}
