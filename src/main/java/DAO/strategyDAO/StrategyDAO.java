package DAO.strategyDAO;

import logic.strategy.Strategy;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface StrategyDAO {

    /**
     * 创建策略
     * @param strategy 要创建的策略
     * @return boolean 是否添加成功
     */
    public boolean addStrategy(Strategy strategy);

    /**
     * 删除策略
     * @param userID 用户ID
     * @param strategyID 要删除的策略编号
     * @return boolean 是否添加成功
     */
    public boolean removeStrategy(String userID , String strategyID);

    /**
     * 得到用户创建的全部策略
     * @param userID 用户ID
     * @return ArrayList<Strategy> 策略列表
     */
    public ArrayList<Strategy> getUserStrategy(String userID);

    /**
     * 添加收藏策略
     * @param userID 用户ID
     * @param strategyID 要收藏的策略编号
     * @return boolean 是否收藏成功
     */
    public boolean addCollectedStrategy(String userID , String strategyID);

    /**
     * 取消收藏策略
     * @param userID 用户ID
     * @param strategyID 要取消收藏的策略编号
     * @return boolean 是否取消成功
     */
    public boolean removeCollectedStrategy(String userID , String strategyID);

    /**
     * 得到用户收藏的全部策略
     * @param userID 用户ID
     * @return ArrayList<Strategy> 策略列表
     */
    public ArrayList<Strategy> getUserCollectedStrategy(String userID);

    /**
     * 按策略编号得到策略信息
     * @param strategyID 策略编号
     * @return Strategy 策略信息
     */
    public Strategy getStrategy(String strategyID);


}
