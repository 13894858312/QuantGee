package data.strategyData;

import DAO.strategyDAO.StrategyDAO;
import PO.StrategyPO;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public class StrategyData implements StrategyDAO {

    @Override
    public boolean addStrategy(StrategyPO strategy) {
        return false;
    }

    @Override
    public boolean removeStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public ArrayList<StrategyPO> getUserStrategy(String userID) {
        return null;
    }

    @Override
    public boolean addCollectedStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public boolean removeCollectedStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public ArrayList<StrategyPO> getUserCollectedStrategy(String userID) {
        return null;
    }

    @Override
    public StrategyPO getStrategy(String strategyID) {
        return null;
    }

    @Override
    public boolean postStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public ArrayList<StrategyPO> getAllPostStrategy() {
        return null;
    }

}
