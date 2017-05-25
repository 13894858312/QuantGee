package DAO.stockInfoDAO;

import bean.*;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface StockInfoDAO {

    /**
     * 根据股票代码和时间获取股票数据（历史数据）
     * @param code 股票代码
     * @param date 时间
     * @return 股票信息
     */
    public Stock getStockInfo(String code, String date);

    /**
     * 按板块获取全部股票代码
     * @param blockName 板块名称
     *                 sh=上证指数 sz=深圳成指 hs300=沪深300指数 sz50=上证50 zxb=中小板 cyb=创业板
     * @return  对应板块全部股票代码
     */
    public Iterator<String> getAllStockCodesByBlock(String blockName);

    /**
     * 获取某一只股票实时信息
     * @param code 股票代码
     * @return 股票实时数据
     */
    public Current getStockRealTimeInfo(String code);

    /**
     * 获取一直股票今日分时信息（间隔两分钟）
     * @param code 股票代码
     * @return 股票分十数据
     */
    public Iterator<Current> getStockRealTimeList(String code);

    /**
     * 得到所有股票ID
     * @return 所有股票ID
     */
    public Iterator<String> getAllStockCodes();

    /**
     * 按股票代码获得股票信息
     * @param code 股票代码
     * @return  股票信息
     */
    public Iterator<Stock> getStockInfo(String code);

    /**
     * 获得股票信息
     * @param code 股票代码
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 股票信息
     */
    public Iterator<Stock> getStockInfo(String code, String startDate , String endDate);

    /**
     * 按股票代码获得股票名称和所属行业
     * @param stockCode 股票代码
     * @return 对应股票所属的市场信息
     */
    public MarketInfo getMarketInfo(String stockCode);

    /**
     * 按行业获取全部股票代码
     * @param industryName 行业名称
     * @return 对应行业全部股票代码
     */
    public Iterator<String> getAllStockCodesByIndustry(String industryName);

    /**
     * 得到股票2014-5-26前全部历史数据
     * @param code 股票代码
     * @return 2014-5-26前数据
     */
    public Iterator<History> getHistory(String code);
}
