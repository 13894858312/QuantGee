package logic.strategy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.strategy.MyStrategyService;
import vo.strategy.StrategyAddInputVO;
import vo.strategy.StrategyUserInputVO;
import vo.strategy.StrategyVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyStrategyServiceImp implements MyStrategyService {
    @Override
    public boolean addMyStartegy(StrategyAddInputVO strategyAddInputVO) {
        return false;
    }

    @Override
    public ArrayList<StrategyVO> getMyStrategys(String userID) {
        return null;
    }

    @Override
    public boolean deleteMyStrategy(StrategyUserInputVO strategyUserInputVO) {
        return false;
    }
}
