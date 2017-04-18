package mock;

import dataDao.StockDataDao;
import po.BaseCumulativeYieldPO;
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
            stockPOs.add(new StockPO(date, 100, 150, 90, 130, 3000, 130, "1", "aaa", "a",null));
            stockPOs.add(new StockPO(date, 50, 90, 40, 40, 300, 40, "2", "bbb", "a",null));
            stockPOs.add(new StockPO(date, 10, 15, 9, 10, 200, 10, "3", "ccc", "a",null));
            stockPOs.add(new StockPO(date, 90, 100, 70, 80, 100, 80, "4", "ddd", "a",null));
            stockPOs.add(new StockPO(date, 300, 320, 290, 300, 20, 300, "5", "eee", "a",null));
        } else if(date.equals("3/1/17")){
            stockPOs.add(new StockPO(date, 120, 140, 100, 120, 3000, 120, "1", "aaa", "a",null));
            stockPOs.add(new StockPO(date, 60, 90, 50, 50, 300, 50, "2", "bbb", "a",null));
            stockPOs.add(new StockPO(date, 10, 13, 7, 12, 200, 12, "3", "ccc", "a",null));
            stockPOs.add(new StockPO(date, 100, 120, 80, 90, 10, 90, "4", "ddd", "a",null));
            stockPOs.add(new StockPO(date, 200, 220, 130, 310, 20, 310, "5", "eee", "a",null));
        }

        return stockPOs;

    }

    public ArrayList<StockPO> getStockPOsByTimeInterval(String startdate, String endDate, String stockCode, boolean notST) {

        ArrayList<StockPO> stockPOs = new ArrayList<StockPO>();

        //8.15、 8.07、 8.84、 8.10、 8.40、 9.10、 9.20、 9.10、 8.95、 8.70

        if(stockCode == "3") {
            stockPOs.add(new StockPO("3/1/17", 90, 150, 90, 8.15, 3000, 130, "1", "aaa", "a", null));
            stockPOs.add(new StockPO("3/2/17", 50, 90, 40, 8.07, 300, 40,"1", "aaa", "a", null));
            stockPOs.add(new StockPO("3/3/17", 10, 15, 9, 8.84, 200, 10, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/6/17", 90, 100, 70, 8.10, 10, 80, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/7/17", 300, 320, 290, 8.40, 20, 310, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/8/17", 10, 12, 5, 9.10, 50, 6, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/9/17", 5, 5, 4, 9.20, 30, 4, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/10/17", 20, 24, 19, 9.10, 20, 20, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/13/17", 40, 42, 35, 8.95, 100, 37, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/14/17", 60, 61, 50, 8.70, 2000, 52, "1", "aaa", "a",null));
        } else {
            stockPOs.add(new StockPO("3/1/17", 90, 150, 90, 130, 3000, 130, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/2/17", 50, 90, 40, 40, 300, 40,"1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/3/17", 10, 15, 9, 10, 200, 10, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/6/17", 90, 100, 70, 80, 10, 80, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/7/17", 300, 320, 290, 310, 20, 310, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/8/17", 10, 12, 5, 6, 50, 6, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/9/17", 5, 5, 4, 4, 30, 4, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/10/17", 20, 24, 19, 20, 20, 20, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/13/17", 40, 42, 35, 37, 100, 37, "1", "aaa", "a",null));
            stockPOs.add(new StockPO("3/14/17", 60, 61, 50, 52, 2000, 52, "1", "aaa", "a",null));
        }

        return stockPOs;
    }

    @Override
    public ArrayList<ArrayList<StockPO>> getStockPOsByBlockName(String startDate, String endDate, String blockName, boolean notST) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<StockPO>> getAllStockPO(String startDate, String endDate, boolean notST) {
        return null;
    }

    @Override
    public ArrayList<BaseCumulativeYieldPO> getBaseYieldByBlockName(String blockName, String startDate, String endDate) {
        return null;
    }
}
