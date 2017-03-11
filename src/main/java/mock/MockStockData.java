package mock;

import dataDao.StockDataDao;
import po.StockPO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/7.
 */
public class MockStockData implements StockDataDao {

    public String getStockCodeByName(String stockName) {
        return "1";
    }

    public StockPO getStockPO(String date, String stockCode) {
        return null;
    }


    //0.08  -0.2  -0.17  -0.125 -0.03
    public ArrayList<StockPO> getStockPOsByDate(String date) {

        ArrayList<StockPO> stockPOs = new ArrayList<StockPO>();

        if(date.equals("3/2/17")) {
            stockPOs.add(new StockPO(date, 100, 150, 90, 130, 3000, 130, "1", "aaa", "a"));
            stockPOs.add(new StockPO(date, 50, 90, 40, 40, 300, 40, "2", "bbb", "a"));
            stockPOs.add(new StockPO(date, 10, 15, 9, 10, 200, 10, "3", "ccc", "a"));
            stockPOs.add(new StockPO(date, 90, 100, 70, 80, 100, 80, "4", "ddd", "a"));
            stockPOs.add(new StockPO(date, 300, 320, 290, 300, 20, 300, "5", "eee", "a"));
        } else if(date.equals("3/1/17")){
            stockPOs.add(new StockPO(date, 120, 140, 100, 120, 3000, 120, "1", "aaa", "a"));
            stockPOs.add(new StockPO(date, 60, 90, 50, 50, 300, 50, "2", "bbb", "a"));
            stockPOs.add(new StockPO(date, 10, 13, 7, 12, 200, 12, "3", "ccc", "a"));
            stockPOs.add(new StockPO(date, 100, 120, 80, 90, 10, 90, "4", "ddd", "a"));
            stockPOs.add(new StockPO(date, 200, 220, 130, 310, 20, 310, "5", "eee", "a"));
        }

        return stockPOs;

    }

    public ArrayList<StockPO> getStockPOsByTimeInterval(String startdate, String endDate, String stockCode) {

        ArrayList<StockPO> stockPOs = new ArrayList<StockPO>();

        stockPOs.add(new StockPO("3/1/17", 90, 150, 90, 130, 3000, 130, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/2/17", 50, 90, 40, 40, 300, 40,"1", "aaa", "a"));
        stockPOs.add(new StockPO("3/3/17", 10, 15, 9, 10, 200, 10, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/6/17", 90, 100, 70, 80, 10, 80, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/7/17", 300, 320, 290, 310, 20, 310, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/8/17", 10, 12, 5, 6, 50, 6, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/9/17", 5, 5, 4, 4, 30, 4, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/10/17", 20, 24, 19, 20, 20, 20, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/13/17", 40, 42, 35, 37, 100, 37, "1", "aaa", "a"));
        stockPOs.add(new StockPO("3/14/17", 60, 61, 50, 52, 2000, 52, "1", "aaa", "a"));

        return stockPOs;
    }
}
