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

import java.util.ArrayList;
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
        Current current = (Current) hibernateTemplate
                .find("from Current c where c.code = ?",code).iterator().next();
        return current;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code) {
        Iterator<Stock> iterator = (Iterator<Stock>)hibernateTemplate
                .find("from Stock s where s.stockId = ? order by s.date asc ",code).iterator();
        return iterator;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code, String startDate, String endDate) {
        Iterator<Stock> iterator = (Iterator<Stock>) hibernateTemplate
                .find("from Stock s where s.stockId =? and s.date> ? and s.date<? order by s.date asc ", new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public MarketInfo getMarketInfo(String stockCode){
        MarketInfo marketInfo = hibernateTemplate.get(MarketInfo.class,stockCode);
        return marketInfo;
    }

    @Override
    public Iterator<String> getAllStockCodesByIndustry(String industryName) {
        Iterator<String> iterator = (Iterator<String>) hibernateTemplate
                .find("select m.code from MarketInfo m where m.cName =?",industryName).iterator();
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
                     iterator = (Iterator<String>) hibernateTemplate
                             .find("select m.code FROM MarketInfo m where m.code like ?","60%").iterator();
                    return iterator;
                case "sz":
                    iterator = (Iterator<String>) hibernateTemplate
                            .find("select m.code FROM MarketInfo m where m.code like ?","000%").iterator();
                    return iterator;
                case "hs300":
                    return null;
                case "sz50":
                    return null;
                case "zxb":
                    iterator = (Iterator<String>) hibernateTemplate
                            .find("select s.code FROM Sme s").iterator();
                    return iterator;
                case "cyb":
                    iterator = (Iterator<String>) hibernateTemplate
                            .find("select g.code FROM Gem g").iterator();
                    return iterator;
            }
        return null;

    }

    @Override
    public Iterator<String> getCollectedStocks(String userID) {
        Iterator<String> iterator = (Iterator<String>) hibernateTemplate
                .find("select c.stockId from CollectStock c where c.userId=? ",userID).iterator();
        return iterator;
    }

    @Override
    public boolean addCollectedStock(String userID, String code) {
        CollectStock collectStock = new CollectStock();
        collectStock.setUserId(userID);
        collectStock.setStockId(code);
        hibernateTemplate.save(collectStock);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public boolean removeCollectedStock(String userID, String code) {
        CollectStock collectStock = new CollectStock();
        collectStock.setUserId(userID);
        collectStock.setStockId(code);
        hibernateTemplate.delete(collectStock);
        return true;
    }

    @Override
    public Iterator<String> getAllStockCodes() {
        Iterator<String> iterator = (Iterator<String>) hibernateTemplate
                .find("select m.code FROM MarketInfo m").iterator();
        return iterator;
    }

    @Override
    public Iterator<History> getHistory(String code) {
        Iterator<History> iterator = (Iterator<History>) hibernateTemplate
                .find("from History h where h.stockId = ? order by h.date asc ",code ).iterator();
        return iterator;
    }

    @Override
    public Iterator<Macd> getMACDs(String startDate, String endDate, String code) {
        Iterator<Macd> iterator = (Iterator<Macd>) hibernateTemplate
                .find("from Macd m where m.code = ? and m.date>? and m.date<?",
                new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public boolean addMACD(Macd macd) {
        hibernateTemplate.save(macd);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Iterator<Kdj> getKDJs(String startDate, String endDate, String code) {
        Iterator<Kdj> iterator = (Iterator<Kdj>) hibernateTemplate
                .find("from Kdj k where k.code = ? and k.date>? and k.date<?",
                        new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public boolean addKDJ(Kdj kdj) {
        hibernateTemplate.save(kdj);
        hibernateTemplate.flush();
        return true;
    }

}
