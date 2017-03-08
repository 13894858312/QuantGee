package dataDao;

import po.StockPO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/5.
 */
public interface StockDataDao {

    /**
     * 根据指定时间和股票编号获取股票信息
     * @param date 时间
     * @param stockCode 股票编号
     * @return
     */
    public StockPO getStockPO(String date, String stockCode);

    /**
     * 根据指定时间获取当日所有股票信息
     * @param date 时间
     * @return
     */
    public ArrayList<StockPO> getStockPOsByDate(String date);

    /**
     * 根据指定开始时间和结束时间和股票编号获取信息
     * @param startdate 开始时间
     * @param endDate 结束时间
     * @param stockCode 股票编号
     * @return ArrayList<StockPO>
     * @return
     */
    public ArrayList<StockPO> getStockPOsByTimeInterval(String startdate, String endDate, String stockCode);
}
