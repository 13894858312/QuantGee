package data.stockInfoData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.MarketInfo;
import bean.Stock;
import bean.StockPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
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
