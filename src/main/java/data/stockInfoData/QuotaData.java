package data.stockInfoData;

import DAO.stockInfoDAO.QuotaDAO;
import bean.Boll;
import bean.Kdj;
import bean.Macd;
import bean.Rsi;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/24.
 */
public class QuotaData implements QuotaDAO {

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
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

    @Override
    public Iterator<Rsi> getRSIs(String startDate, String endDate, String code) {
        return null;
    }

    @Override
    public boolean addRSI(Rsi rsi) {
        return false;
    }

    @Override
    public Iterator<Boll> getBOLLs(String startDate, String endDate, String code) {
        return null;
    }

    @Override
    public boolean addBOLL(Boll boll) {
        return false;
    }

}
