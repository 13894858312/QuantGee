package data.stockInfoData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.*;
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
        List<Current> list = (List<Current>) hibernateTemplate
                .find("from Current where code = ? ", code);
        if(list == null || list.size() == 0){
            return null;
        }
        return list.get(list.size()-1);
    }

    @Override
    public Iterator<Current> getStockRealTimeList(String code){
        Iterator<Current> current = (Iterator<Current>) hibernateTemplate
                .find("from Current where code = ?  ",code).iterator();
        return current;
    }

    @Override
    public Iterator<Current> getLatestCurrents() {
        try {
            String latest = (String) hibernateTemplate
                    .find("select max (time) from Current ").iterator().next();

            Iterator<Current> iterator = (Iterator<Current>) hibernateTemplate
                    .find("from Current where time = ? ", latest).iterator();
            return iterator;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public Iterator<Stock> getStockInfo(String code) {
        Iterator<Stock> iterator = (Iterator<Stock>)hibernateTemplate
                .find("from Stock s where s.code = ? ",code).iterator();
        return iterator;
    }

    @Override
    public Iterator<Stock> getStockInfo(String code, String startDate, String endDate) {
        Iterator<Stock> iterator = (Iterator<Stock>) hibernateTemplate
                .find("from Stock s where s.code =? and s.date>= ? and s.date<=? ", new String[]{code,startDate,endDate}).iterator();
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
        StockPK stockPK = new StockPK();
        stockPK.setCode(code);
        stockPK.setDate(date);
        return hibernateTemplate.get(Stock.class,stockPK);
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
    public Iterator<String> getAllStockCodes() {
        Iterator<String> iterator = (Iterator<String>) hibernateTemplate
                .find("select m.code FROM MarketInfo m").iterator();
        return iterator;
    }

    @Override
    public Iterator<History> getHistory(String code) {
        Iterator<History> iterator = (Iterator<History>) hibernateTemplate
                .find("from History h where h.code = ? order by h.date asc ",code ).iterator();
        return iterator;
    }

    @Override
    public Iterator<String> getAllIndustryNames() {
        Iterator<String> iterator = (Iterator<String>) hibernateTemplate
                .find("select distinct m.cName from MarketInfo m").iterator();
        return iterator;
    }

    @Override
    public String getCodeByName(String name) {
        try{
            name = name.trim();
            String code = (String) hibernateTemplate
                    .find("select code from MarketInfo where name = ?" , name).iterator().next();
            return code;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Iterator<CurrentIndex> getCurrentIndexByCode(String indexCode) {
        Iterator<CurrentIndex> currentIndexIterator = (Iterator<CurrentIndex>) hibernateTemplate
                .find("from CurrentIndex where code = ?", indexCode).iterator();
        return currentIndexIterator;
    }

    @Override
    public Iterator<IndexInfo> getAllIndexCodesAndNames() {
        Iterator<IndexInfo> indexIterator = (Iterator<IndexInfo>) hibernateTemplate
                .find("from IndexInfo ").iterator();
        return indexIterator;
    }

    @Override
    public String getIndexCodeByName(String name) {
        try{
            String code = (String) hibernateTemplate
                    .find("select code from IndexInfo where name = ?", name).iterator().next();
            return code;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String getIndexNameByCode(String code) {
        return hibernateTemplate.get(IndexInfo.class, code).getName();
    }

    @Override
    public Iterator<StockWeek> getWeekK(String code) {
        Iterator<StockWeek> iterator = (Iterator<StockWeek>)hibernateTemplate
                .find("from StockWeek s where s.stockId = ? ",code).iterator();
        return iterator;
    }

    @Override
    public Iterator<StockWeek> getWeekK(String code, String startDate, String endDate) {
        Iterator<StockWeek> iterator = (Iterator<StockWeek>) hibernateTemplate
                .find("from StockWeek s where s.stockId =? and s.date>= ? and s.date<=? ", new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

    @Override
    public Iterator<StockMonth> getMonthK(String code) {
        Iterator<StockMonth> iterator = (Iterator<StockMonth>)hibernateTemplate
                .find("from StockMonth s where s.stockId = ? ",code).iterator();
        return iterator;
    }

    @Override
    public Iterator<StockMonth> getMonthK(String code, String startDate, String endDate) {
        Iterator<StockMonth> iterator = (Iterator<StockMonth>) hibernateTemplate
                .find("from StockMonth s where s.stockId =? and s.date>= ? and s.date<= ? ", new String[]{code,startDate,endDate}).iterator();
        return iterator;
    }

}
