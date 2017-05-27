package logic.strategy;

import service.strategy.PostStrategyService;
import vo.strategy.StrategyPostVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 */
public class PostStrategyServiceImp implements PostStrategyService {
    @Override
    public boolean postStrategy(StrategyPostVO strategyPostVO) {
        return false;
    }

    @Override
    public ArrayList<StrategyPostVO> getAllPostedStrategy() {
        return null;
    }
}
