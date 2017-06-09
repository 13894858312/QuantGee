package data.strategyData;

import DAO.strategyDAO.StrategyDAO;
import bean.CollectStock;
import bean.CollectStrategy;
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
    public boolean addMyStrategy(Strategy strategy) {
        try{
            hibernateTemplate.save(strategy);
            hibernateTemplate.flush();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removeMyStrategy(String userID, int strategyID) {
        try{
            Strategy strategy = hibernateTemplate.get(Strategy.class, strategyID);
            if(strategy.getUserId() == userID){
                hibernateTemplate.delete(strategy);
                hibernateTemplate.flush();
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Iterator<Strategy> getMyStrategy(String userID) {
        Iterator<Strategy> iterator = (Iterator<Strategy>) hibernateTemplate
                .find("from Strategy where userId = ?", userID).iterator();
        return iterator;
    }

//
//    @Override
//    public boolean addMyStrategy(Strategy strategy) {
//        hibernateTemplate.save(strategy);
//        hibernateTemplate.flush();
//        return true;
//    }
//
//    @Override
//    public boolean removeMyStrategy(int strategyID) {
//
//        Strategy strategy = hibernateTemplate.get(Strategy.class, strategyID);
//        Iterator<Strategy> iterator = (Iterator<Strategy>) hibernateTemplate
//                .find("from CollectStrategy c where c.strategyId = ?" , strategyID).iterator();
//
//        hibernateTemplate.delete(strategy);
//        while (iterator.hasNext()){
//            hibernateTemplate.delete(iterator.next());
//        }
//        return true;
//    }
//
//    @Override
//    public Iterator<Strategy> getMyStrategy(String userID) {
//        Iterator<Strategy> strategyIterator = (Iterator<Strategy>) hibernateTemplate
//                .find("from Strategy s where s.userId = ?",userID).iterator();
//        return strategyIterator;
//    }
//
//    @Override
//    public boolean addCollectedStrategy(String userID, int strategyID) {
//        CollectStrategy collectStrategy = new CollectStrategy();
//        collectStrategy.setUserId(userID);
//        collectStrategy.setStrategyId(strategyID);
//        hibernateTemplate.save(collectStrategy);
//        hibernateTemplate.flush();
//        return true;
//    }
//
//    @Override
//    public boolean removeCollectedStrategy(String userID, int strategyID) {
//        CollectStrategy collectStrategy = new CollectStrategy();
//        collectStrategy.setUserId(userID);
//        collectStrategy.setStrategyId(strategyID);
//        hibernateTemplate.delete(collectStrategy);
//        return true;
//    }
//
//    @Override
//    public Iterator<Integer> getUserCollectedStrategy(String userID) {
//        Iterator<Integer> iterator = (Iterator<Integer>) hibernateTemplate
//                .find("select c.strategyId from CollectStrategy c where c.userId = ?",userID).iterator();
//        return iterator;
//    }
//
//    @Override
//    public Strategy getStrategy(int strategyID) {
//        return hibernateTemplate.get(Strategy.class,strategyID);
//    }
//
//    @Override
//    public boolean postStrategy(int strategyID) {
//        Strategy strategy = hibernateTemplate.get(Strategy.class, strategyID);
//        strategy.setPosted(1);
//        hibernateTemplate.update(strategy);
//        return true;
//    }
//
//    @Override
//    public Iterator<Strategy> getAllPostStrategy() {
//        Iterator<Strategy> strategyIterator = (Iterator<Strategy>) hibernateTemplate.
//                find("from Strategy where posted = 1").iterator();
//        return strategyIterator;
//    }

}
