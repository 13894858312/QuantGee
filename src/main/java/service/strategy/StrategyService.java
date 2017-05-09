package service.strategy;

import bean.Strategy;
import bean.StrategyBackTesting;
import vo.CollectStrategyForm;
import vo.StrategyForm;

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



    /**
     * 获取所有收藏的策略
     * @param userID userid
     * @return  ArrayList<Strategy>
     */
    public ArrayList<Strategy> getCollectedStrategy(String userID);

    /**
     * 收藏策略
     * @param collectStrategyForm userid和策略id
     * @return boolean
     */
    public boolean collectStrategy(CollectStrategyForm collectStrategyForm);

    /**
     * 删除收藏的策略
     * @param collectStrategyForm userid和策略id
     * @return boolean
     */
    public boolean deleteCollectedStrategy(CollectStrategyForm collectStrategyForm);



}
