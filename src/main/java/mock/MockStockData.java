package mock;

import dataDao.StockDataDao;
import po.StockPO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/7.
 */
public class MockStockData implements StockDataDao {

    public StockPO getStockPO(String date, String stockCode) {
        return null;
    }

    public ArrayList<StockPO> getStockPOsByDate(String date) {
        return null;
    }

    public ArrayList<StockPO> getStockPOsByTimeInterval(String startdate, String endDate, String stockCode) {
        return null;
    }
}
