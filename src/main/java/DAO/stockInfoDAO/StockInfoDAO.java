package DAO.stockInfoDAO;

import bean.Stock;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface StockInfoDAO {

    public Stock getStockInfo(String code);

    public Stock getStockInfo(String code , String startDate , String endDate , String kType);

    public ArrayList<String> getAllStocksByIndustry(String industryName);

    public ArrayList<String> getAllSmeStocks();

    public ArrayList<String> getAllGemStocks();

    public ArrayList<Stock> getCollectedStocks(String userID);

    public boolean addCollect(String code);

}
