package service.strategy;

import vo.strategy.CollectStrategyForm;


/**
 * Created by Mark.W on 2017/5/11.
 */
public interface MyStrategyService {
    /**
     * 添加自己的量化策略
     * @param strategy Strategy
     * @return boolean
     */
    public boolean addMyStartegy(Strategy strategy);

    /**
     * 获取我自己的的所有策略
     * @param userID
     * @return
     */
    public ArrayList<Strategy> getMyStrategy(String userID);

    /**
     * 删除自己的策略
     * @param collectStrategyForm userid和策略id
     * @return boolean
     */
    public boolean deleteMyStrategy(CollectStrategyForm collectStrategyForm);
}
