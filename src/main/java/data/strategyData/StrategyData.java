package data.strategyData;

import DAO.strategyDAO.StrategyDAO;
import bean.Strategy;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
@Transactional
public class StrategyData implements StrategyDAO {

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean addStrategy(Strategy strategy) {
        return false;
    }

    @Override
    public boolean removeStrategy(String userID, String strategyID) {
        return false;
    }

    @Override
    public Iterator<Strategy> getUserStrategy(String userID) {
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
    public Iterator<Strategy> getUserCollectedStrategy(String userID) {
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
    public Iterator<Strategy> getAllPostStrategy() {
        return null;
    }

}
