package DAO.strategyDAO;

import bean.Strategy;

import java.util.ArrayList;
import java.util.Iterator;

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
     * 删除策略并删除对应策略收藏
     * @param strategyID 要删除的策略编号
     * @return boolean 是否添加成功
     */
    public boolean removeStrategy(int strategyID);

    /**
     * 得到用户创建的全部策略
     * @param userID 用户ID
     * @return 策略列表
     */
    public Iterator<Strategy> getUserStrategy(String userID);

    /**
     * 添加收藏策略
     * @param userID 用户ID
     * @param strategyID 要收藏的策略编号
     * @return boolean 是否收藏成功
     */
    public boolean addCollectedStrategy(String userID , int strategyID);

    /**
     * 取消收藏策略
     * @param userID 用户ID
     * @param strategyID 要取消收藏的策略编号
     * @return boolean 是否取消成功
     */
    public boolean removeCollectedStrategy(String userID ,int strategyID);

    /**
     * 得到用户收藏的全部策略
     * @param userID 用户ID
     * @return 策略ID
     */
    public Iterator<Integer> getUserCollectedStrategy(String userID);

    /**
     * 按策略编号得到策略信息
     * @param strategyID 策略编号
     * @return StrategyPO 策略信息
     */
    public Strategy getStrategy(int strategyID);

    /**
     * 用户登录策略
     * @param strategyID
     * @return boolean 是否成功
     */
    public boolean postStrategy(int strategyID);

    /**
     * 得到所有登录的策略
     * @return  策略列表
     */
    public Iterator<Strategy> getAllPostStrategy();

}
