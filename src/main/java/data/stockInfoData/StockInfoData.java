package data.stockInfoData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public class StockInfoData implements StockInfoDAO{

    @Override
    public Stock getStockInfo(String code) {
        return null;
    }

    @Override
    public Stock getStockInfo(String code, String startDate, String endDate, String kType) {
        return null;
    }

    @Override
    public ArrayList<String> getAllStocksByIndustry(String industryName) {
        return null;
    }

    @Override
    public ArrayList<String> getAllSmeStocks() {
        return null;
    }

    @Override
    public ArrayList<String> getAllGemStocks() {
        return null;
    }

    @Override
    public ArrayList<Stock> getCollectedStocks(String userID) {
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

}
