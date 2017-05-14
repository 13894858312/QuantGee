package data.strategyData;

import DAO.strategyDAO.StrategyDAO;
import bean.Strategy;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public class StrategyData implements StrategyDAO {

    @Override
    public boolean addStrategy(Strategy strategy) {
        return false;
    }

    @Override
    public boolean removeStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public ArrayList<Strategy> getUserStrategy(String userID) {
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
    public ArrayList<Strategy> getUserCollectedStrategy(String userID) {
        return null;
    }

    @Override
    public Strategy getStrategy(String strategyID) {
        return null;
    }

    @Override
    public boolean postStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public ArrayList<Strategy> getAllPostStrategy() {
        return null;
    }

}
