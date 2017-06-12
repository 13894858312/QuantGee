package logic.strategy;

import DAO.strategyDAO.StrategyDAO;
import bean.Strategy;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.strategy.MyStrategyService;
import vo.strategy.StrategyAddInputVO;
import vo.strategy.StrategyUserInputVO;
import vo.strategy.StrategyVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/26.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyStrategyServiceImp implements MyStrategyService {

    @Autowired
    private StrategyDAO strategyDAO;

    @Autowired
    private TransferHelper transferHelper;

    @Override
    public boolean addMyStartegy(StrategyVO strategyVO) {
        Strategy strategy = transferHelper.transToStrategy(strategyVO);
        if (strategyDAO.addMyStrategy(strategy)) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<StrategyVO> getMyStrategys(String userID) {
        Iterator<Strategy> strategys = strategyDAO.getMyStrategy(userID);
        ArrayList<StrategyVO> result = new ArrayList<>();
        while(strategys.hasNext()) {
            result.add(transferHelper.transToStrategyVO(strategys.next()));
        }

        return result;
    }

    @Override
    public boolean deleteMyStrategy(StrategyUserInputVO input) {
//        if (strategyDAO.removeMyStrategy(input.getUserID(), input.getStrategyName())) {
//            return true;
//        }
        return false;
    }
}
