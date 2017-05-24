package DAO.stockInfoDAO;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/24.
 */
public interface CollectStockDAO {
    /**
     * 按用户ID获得全部收藏股票信息
     * @param userID 用户ID
     * @return ArrayList<Stock> 全部收藏股票信息
     */
    public Iterator<String> getCollectedStocks(String userID);

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
    public boolean removeCollectedStock(String userID, String code);
}
