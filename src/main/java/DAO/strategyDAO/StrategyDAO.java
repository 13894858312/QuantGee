package DAO.strategyDAO;

import input.StrategyInput;
import logic.strategy.Strategy;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface StrategyDAO {

    public boolean addStrategy(Strategy strategy);

    public boolean removeStrategy(String strategyID);

    public Strategy getStrategy(String strategyID);

    public ArrayList<Strategy> getUSerStrategy(String userID);

}
