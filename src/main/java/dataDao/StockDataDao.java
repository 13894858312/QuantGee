package dataDao;

import po.StockPO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/5.
 */
public interface StockDataDao {

    /**
     * 根据股票名获取股票码
     * @param stockName 股票名
     * @return ArrayList<StockPO>
     */
    public String getStockCodeByName(String stockName);

    /**
     * 根据指定时间和股票编号获取股票信息
     * @param date 时间
     * @param stockCode 股票编号
     * @return ArrayList<StockPO>
     */
    public StockPO getStockPO(String date, String stockCode);

    /**
     * 根据指定时间获取当日所有股票信息
     * @param date 时间
     * @return ArrayList<StockPO>
     */
    public ArrayList<StockPO> getStockPOsByDate(String date);

    /**
     * 根据指定开始时间和结束时间和股票编号获取信息
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param stockCode 股票编号
     * @return ArrayList<StockPO>
     */
    public ArrayList<StockPO> getStockPOsByTimeInterval(String startDate, String endDate, String stockCode);

    /**
     * 根据板块名获得股票数据
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param blockName 板块名
     * @return ArrayList<ArrayList<StockPO>>   股票数组，每一项即
     *                              每个arraylist里是一种股票在一段时间内的信息
     */
    public ArrayList<ArrayList<StockPO>> getStockPOsByBlockName(String startDate, String endDate, String blockName);

    /**
     * 获得所有股票数据
     * @return ArrayList<ArrayList<StockPO>>   股票数组，每一项即
     *                              每个arraylist里是一种股票在一段时间内的信息
     */
    public ArrayList<ArrayList<StockPO>> getAllStockPO();

}
