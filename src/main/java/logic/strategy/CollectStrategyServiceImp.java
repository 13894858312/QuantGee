package logic.strategy;

import DAO.strategyDAO.StrategyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.strategy.CollectStrategyService;
import vo.strategy.StrategyUserInputVO;
import vo.strategy.StrategyVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollectStrategyServiceImp implements CollectStrategyService {

    @Autowired
    private StrategyDAO strategyDAO;

    @Override
    public ArrayList<StrategyVO> getCollectedStrategys(String userID) {
        return null;
    }

    @Override
    public boolean collectStrategy(StrategyUserInputVO strategyUserInputVO) {
        return false;
    }

    @Override
    public boolean deleteCollectedStrategy(StrategyUserInputVO strategyUserInputVO) {
        return false;
    }
}
