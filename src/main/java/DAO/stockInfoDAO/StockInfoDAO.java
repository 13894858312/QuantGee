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
     * 获取一支股票今日分时信息（间隔两分钟）
     * @param code 股票代码
     * @return 股票分时数据
     */
    public Iterator<Current> getStockRealTimeList(String code);

    /**
     * 获取所有股票最新信息
     * @return 所有股票最新信息
     */
    public Iterator<Current> getLatestCurrents();

    /**
     * 获取指定板块所有股票最新信息
     * @param code sh sz cyb zxb
     * @return 所有股票最新信息 sh
     */
    public Iterator<Current> getLatestCurrents(String code);

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

    /**
     * 获取所有行业的名称
     * @return Iterator
     */
    public Iterator<String> getAllIndustryNames();

    /**
     * 根据股票名称获得股票代码（错误返回null）
     * @param name 股票名称
     * @return 股票代码
     */
    public String getCodeByName(String name);

    /**
     * 按指数代码得到实时大盘指数信息
     * @param indexCode 大盘指数代码
     * @return 实时大盘指数
     */
    public Iterator<CurrentIndex> getCurrentIndexByCode(String indexCode);

    /**
     * 得到所有大盘指数代码及名称（如000001 上证指数）
     * @return 所有大盘指数代码及名称
     */
    public Iterator<IndexInfo> getAllIndexCodesAndNames();

    /**
     * 根据大盘名称获取指数代码
     * @param name 大盘指数名称
     * @return 大盘指数代码
     */
    public String getIndexCodeByName(String name);

    /**
     * 根据大盘指数代码获取大盘名称
     * @param code 大盘指数代码
     * @return 大盘指数名称
     */
    public String getIndexNameByCode(String code);



    /**
     * 得到周k
     * @param code 股票代码
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 周k数据
     */
    public Iterator<StockWeek> getWeekK(String code, String startDate, String endDate);

    /**
     * 得到月k
     * @param code 股票代码
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 月k数据
     */
    public Iterator<StockMonth> getMonthK(String code, String startDate, String endDate);

    /**
     * 得到周k
     * @param code 股票代码
     * @return 周k数据
     */
    public Iterator<StockWeek> getWeekK(String code);

    /**
     * 得到月k
     * @param code 股票代码
     * @return 月k数据
     */
    public Iterator<StockMonth> getMonthK(String code);

    /**
     * 获取所有股票的代码和名字
     * @return Iterator<MarketInfo>
     */
    public Iterator<MarketInfo> getAllStockAndNames();
}
