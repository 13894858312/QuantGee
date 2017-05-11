package service.strategy;

import vo.strategy.StrategyUserInputVO;
import vo.strategy.StrategyVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/11.
 * 收藏策略的接口
 */
public interface CollectStrategyService {
    /**
     * 获取所有收藏的策略
     * @param userID userid
     * @return  ArrayList<Strategy>
     */
    public ArrayList<StrategyVO> getCollectedStrategys(String userID);

    /**
     * 收藏策略
     * @param strategyUserInputVO userid和策略id
     * @return boolean
     */
    public boolean collectStrategy(StrategyUserInputVO strategyUserInputVO);

    /**
     * 删除收藏的策略
     * @param strategyUserInputVO userid和策略id
     * @return boolean
     */
    public boolean deleteCollectedStrategy(StrategyUserInputVO strategyUserInputVO);

}
