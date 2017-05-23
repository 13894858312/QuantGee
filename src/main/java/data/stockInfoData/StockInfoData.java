package data.stockInfoData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wangxue on 2017/5/5.
 */
@Transactional
public class StockInfoData implements StockInfoDAO{

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /*****stock内容和tushare获取实时数据接口返回内容有差异******/
    @Override
    public Current getStockRealTimeInfo(String code) {
        Current current = (Current) hibernateTemplate.find("from Current c where c.code = ?",code).iterator().next();
        return current;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code) {
        Iterator<Stock> iterator = (Iterator<Stock>)hibernateTemplate.find("from Stock s where s.stockId = ?",code).iterator();
        return iterator;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code, String startDate, String endDate) {
        Iterator<Stock> iterator = (Iterator<Stock>) hibernateTemplate.find("from Stock where stockId =? and date> ? and date<? ", new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public MarketInfo getMarketInfo(String stockCode){
        MarketInfo marketInfo = hibernateTemplate.get(MarketInfo.class,stockCode);
        return marketInfo;
    }

    @Override
    public Iterator<String> getAllStockCodesByIndustry(String industryName) {
        Iterator<String> iterator = (Iterator<String>) hibernateTemplate.find("select m.code from MarketInfo m where m.cName =?",industryName).iterator();
        return iterator;
    }

    @Override
    public Stock getStockInfo(String code, String date) {
        Iterator<Stock> iterator = this.getStockInfo(code);
        while (iterator.hasNext()){
            Stock stock = iterator.next();
            if(stock.getDate() .equals(date)){
                return stock;
            }
        }
        return null;
    }

    @Override
    public Iterator<String> getAllStockCodesByBlock(String blockName) {

        Iterator<String> iterator ;
            switch (blockName){
                case "sh":
                     iterator = (Iterator<String>) hibernateTemplate.find("FROM MarketInfo m where m.code like ?","60%").iterator();
                    return iterator;
                case "sz":
                    iterator = (Iterator<String>) hibernateTemplate.find("FROM MarketInfo m where m.code like ?","000%").iterator();
                    return iterator;
                case "hs300":
                    return null;
                case "sz50":
                    return null;
                case "zxb":
//                    query = session.createQuery("SELECT s.code FROM Sme s ");
//                    iterator = query.list().iterator();
                    break;
//                case "cyb":
//
//                    query = session.createQuery("SELECT g.code FROM Gem g");
//                    iterator = query.list().iterator();
//                    break;
            }

    }

    @Override
    public Iterator<String> getCollectedStocks(String userID) {
        try{
            configuration.addClass(CollectStock.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("select c.stockId from CollectStock c where c.userId=:var ")
                    .setParameter("var",userID);
            Iterator<String> iterator = query.list().iterator();

            transaction.commit();
            session.close();
            sessionFactory.close();

            return iterator;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addCollectedStock(String userID, String code) {
        try{
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            CollectStock collectStock = new CollectStock();
            collectStock.setUserId(userID);
            collectStock.setStockId(code);
            session.save(collectStock);

            transaction.commit();
            session.close();
            sessionFactory.close();

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCollectedStock(String userID, String code) {
        try{
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            CollectStock collectStock = new CollectStock();
            collectStock.setUserId(userID);
            collectStock.setStockId(code);
            session.remove(collectStock);

            transaction.commit();
            session.close();
            sessionFactory.close();

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Iterator<String> getAllStockCodes() {
        try{
            configuration.addClass(MarketInfo.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("SELECT m.code from MarketInfo m");
            Iterator<String> iterator = query.list().iterator();

            transaction.commit();
            session.close();
            sessionFactory.close();

            return iterator;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
