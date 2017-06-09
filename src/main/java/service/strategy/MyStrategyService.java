package service.strategy;

import vo.strategy.StrategyUserInputVO;
import vo.strategy.StrategyVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/11.
 * 个人自己指定的策略的相关操作
 */
public interface MyStrategyService {
    /**
     * 添加自己的量化策略
     * @param strategyVO StrategyVO和useID
     * @return boolean
     */
    public boolean addMyStartegy(StrategyVO strategyVO);

    /**
     * 获取我自己的的所有策略
     * @param userID 用户ID
     * @return ArrayList<StrategyVO>
     */
    public ArrayList<StrategyVO> getMyStrategys(String userID);

    /**
     * 删除自己的策略
     * @param strategyUserInputVO userID和策略ID
     * @return boolean
     */
    public boolean deleteMyStrategy(StrategyUserInputVO strategyUserInputVO);
}
