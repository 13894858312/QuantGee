package service.stock;


import logic.strategy.Stock;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface StockInfoService {

    public ArrayList<Stock> getAllStocks();

    public String getStockByCode(String stockCode);

    /**
        * 实时获取数据
     * @param stockCode
     * @return
             */
    public String getCurrentStock(String stockCode);

    public ArrayList<Stock> getCollectedStockCode(String userID);

    public boolean collectStock();
}
