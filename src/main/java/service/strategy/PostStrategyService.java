package service.strategy;

import vo.strategy.StrategyPostVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/11.
 * 发布策略的相关操作
 */
public interface PostStrategyService {
    /**
     * 发布策略
     * @param strategyPostVO 发布策略
     * @return 成功与否
     */
    public boolean postStrategy(StrategyPostVO strategyPostVO);

    /**
     * 获取所有用户发布的内容
     * @return ArrayList<StrategyPostVO>
     */
    public ArrayList<StrategyPostVO> getAllPostedStrategy();
}

