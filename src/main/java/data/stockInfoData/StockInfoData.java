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

import java.util.Iterator;
import java.util.List;

/**
 * Created by wangxue on 2017/5/5.
 */
public class StockInfoData implements StockInfoDAO{

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    Configuration configuration = new Configuration().configure();

    /*****stock内容和tushare获取实时数据接口返回内容有差异******/
    @Override
    public Current getStockRealTimeInfo(String code) {
        try{
            configuration.addClass(Current.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from Current c where c.code =:code").setParameter("code",code);
            Current current = (Current) query.uniqueResult();

            transaction.commit();
            session.close();
            sessionFactory.close();

            return current;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterator<Stock> getStockInfo(String code) {

        try{
            configuration.addClass(Stock.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery( "from Stock where stockId =:var ").setParameter("var", code);

            List<Stock> list = query.list();
            for(Stock s :list){
                System.out.print(s.getDate());
            }
            Iterator<Stock> stockIterator = query.list().iterator();

            transaction.commit();
            session.close();
            sessionFactory.close();
            return stockIterator;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterator<Stock> getStockInfo(String code, String startDate, String endDate) {

        try{
            configuration.addClass(Stock.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery( "from Stock where stockId =:var and date>:start and date<:end ")
                    .setParameter("var", code).setParameter("start",startDate).setParameter("end",endDate);

            List<Stock> list = query.list();
            for(Stock s :list){
                System.out.print(s.getDate());
            }
            Iterator<Stock> stockIterator = query.list().iterator();

            transaction.commit();
            session.close();
            sessionFactory.close();
            return stockIterator;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public MarketInfo getMarketInfo(String stockCode){
        try {
            configuration.addClass(MarketInfo.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            MarketInfo marketInfo = (MarketInfo)session.get(MarketInfo.class,stockCode);

            transaction.commit();
            session.close();
            sessionFactory.close();

            return marketInfo;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterator<String> getAllStockCodesByIndustry(String industryName) {
        try {
            configuration.addClass(MarketInfo.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("select m.stockID from MarketInfo m where m.market =:c_name")
                    .setParameter("c_name",industryName);
            Iterator<String> stringIterator = query.list().iterator();

            transaction.commit();
            session.close();
            sessionFactory.close();

            return stringIterator;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
        try {
            configuration.addClass(Sme.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Iterator<String> iterator;
            Query query;

            switch (blockName){
                case "sh":
                    query = session.createQuery("FROM MarketInfo m where m.stockID like :var")
                            .setParameter("var","60"+"%");
                    iterator = query.list().iterator();
                    break;
                case "sz":
                    query = session.createQuery("FROM MarketInfo m where m.stockID like :var")
                            .setParameter("var","000"+"%");
                    iterator = query.list().iterator();
                    break;
                case "hs300":
                    return null;
                case "sz50":
                    return null;
                case "zxb":
                    query = session.createQuery("SELECT s.stockCode FROM Sme s ");
                    iterator = query.list().iterator();
                    break;
                case "cyb":

                    query = session.createQuery("SELECT g.stockCode FROM Gem g");
                    iterator = query.list().iterator();
                    break;
            }

            transaction.commit();
            session.close();
            sessionFactory.close();

            return null;

        }catch (Exception e){
            e.printStackTrace();
            return null;
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

            Query query = session.createQuery("SELECT m.stockID from MarketInfo m");
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
