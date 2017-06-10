package data.stockInfoData;

import DAO.stockInfoDAO.QuotaDAO;
import bean.*;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/24.
 */
@Transactional
public class QuotaData implements QuotaDAO {

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Iterator<Macd> getMACDs(String startDate, String endDate, String code) {
        Iterator<Macd> iterator = (Iterator<Macd>) hibernateTemplate
                .find("from Macd m where m.code = ? and m.date>=? and m.date<=?",
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
                .find("from Kdj k where k.code = ? and k.date>=? and k.date<=?",
                        new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public boolean addKDJ(Kdj kdj) {
        hibernateTemplate.save(kdj);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Iterator<Rsi> getRSIs(String startDate, String endDate, String code) {
        Iterator<Rsi> iterator = (Iterator<Rsi>) hibernateTemplate
                .find("from Rsi r where r.code = ? and r.date>=? and r.date<=?",
                        new String[] {code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public boolean addRSI(Rsi rsi) {
        hibernateTemplate.save(rsi);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Iterator<Boll> getBOLLs(String startDate, String endDate, String code) {
        Iterator<Boll> iterator = (Iterator<Boll>)hibernateTemplate
                .find("from Boll b where b.code = ? and b.date>=? and b.date<=?",
                        new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public boolean addBOLL(Boll boll) {
        hibernateTemplate.save(boll);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Iterator<StockPredict> getPredictData(String code, String startDate, String endDate) {
        Iterator<StockPredict> stockPredict = (Iterator<StockPredict>) hibernateTemplate
                .find("from StockPredict s where s.code = ? and s.date >= ? and s.date <= ?",
                        new String[]{code,startDate,endDate}).iterator();
        return stockPredict;
    }

    @Override
    public Iterator<StockPredict> getAllStockPredictData(String date) {
        Iterator<StockPredict> iterator = (Iterator<StockPredict>) hibernateTemplate
                .find("from StockPredict where date = ?", date).iterator();
        return iterator;
    }

}
