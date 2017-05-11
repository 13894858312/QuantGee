package service.strategy;

import bean.Strategy;
import bean.StrategyBackTesting;
import vo.strategy.CollectStrategyForm;
import vo.strategy.StrategyForm;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface StrategyService {

    /**
     * 股票回测
     * @param strategyForm 股票回测输入信息
     * @return  StrategyBackTesting
     */
    public StrategyBackTesting getStrategyBackTesting(StrategyForm strategyForm);






}
