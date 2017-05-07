package DAO.stockInfoDAO;

import bean.Stock;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface StockInfoDAO {

    /**
     * 按股票代码获得股票信息
     * @param code 股票代码
     * @return Stock 股票信息
     */
    public Stock getStockInfo(String code);

    /**
     * 获得票信息
     * @param code 股票代码
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param kType k线图类型
     * @return Stock 股票信息
     */
    public Stock getStockInfo(String code , String startDate , String endDate , String kType);

    /**
     * 按行业获取全部股票代码
     * @param industryName 行业名称
     * @return ArrayList<String> 对应行业全部股票代码
     */
    public ArrayList<String> getAllStocksByIndustry(String industryName);

    /**
     * 获得中小板全部股票代码
     * @return ArrayList<String> 中小板全部股票代码
     */
    public ArrayList<String> getAllSmeStocks();

    /**
     * 获得创业板全部股票代码
     * @return ArrayList<String> 创业板全部股票代码
     */
    public ArrayList<String> getAllGemStocks();

    /**
     * 按用户ID获得全部收藏股票信息
     * @param userID 用户ID
     * @return ArrayList<Stock> 全部收藏股票信息
     */
    public ArrayList<Stock> getCollectedStocks(String userID);

    /**
     * 添加收藏股票
     * @param userID 用户ID
     * @param code 股票代码
     * @return boolean 是否添加成功
     */
    public boolean addCollectedStock(String userID , String code);

    /**
     * 取消收藏股票
     * @param userID 用户ID
     * @param code 股票代码
     * @return boolean 是否取消成功
     */
    public boolean removeCollectedStock(String userID , String code);

}
