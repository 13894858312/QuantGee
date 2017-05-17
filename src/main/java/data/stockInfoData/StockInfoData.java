package data.stockInfoData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.MarketInfo;
import bean.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
public class StockInfoData implements StockInfoDAO{

    /*****stock内容和tushare获取实时数据接口返回内容有差异******/
    @Override
    public Stock getStockRealTimeInfo(String code) {
        return null;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code) {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addClass(MarketInfo.class);
            configuration.addClass(Stock.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            transaction.commit();
            session.close();
            sessionFactory.close();


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code, String startDate, String endDate, String kType) {
        return null;
    }

    @Override
    public MarketInfo getMarketInfo(String stockCode){
        return null;
    }

    @Override
    public Iterator<String> getAllStockCodesByIndustry(String industryName) {
        return null;
    }

    @Override
    public Stock getStockInfo(String code, String date) {
        return null;
    }

    @Override
    public Iterator<String> getAllStockCodesByBlock(String blockName) {
        return null;
    }

    @Override
    public Iterator<Stock> getCollectedStocks(String userID) {
        return null;
    }

    @Override
    public boolean addCollectedStock(String userID, String code) {
        return false;
    }

    @Override
    public boolean removeCollectedStock(String userID, String code) {
        return false;
    }

    @Override
    public Iterator<String> getAllStockCodes() {
        return null;
    }

}
