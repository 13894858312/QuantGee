package logic.strategy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.strategy.PostStrategyService;
import vo.strategy.StrategyPostVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
