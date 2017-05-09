package service.stock;

import bean.Stock;
import vo.stock.CollectStockForm;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface StockInfoService {

    /**
     * 获取所有股票
     * @return ArrayList<Stock>
     */
    public ArrayList<Stock> getAllStocks();

    /**
     * 根据股票代码获取单只股票信息
     * @param stockCode 股票代码
     * @return Stock
     */
    public Stock getStockByCode(String stockCode);

    /**
     * 实时获取股票数据
     * @param stockCode 股票代码
     * @return Stock
     */
    public Stock getCurrentStock(String stockCode);


    /**
     * 获取个人收藏的股票信息
     * @param userID 用户id
     * @return 股票信息列表
     */
    public ArrayList<Stock> getCollectedStockCode(String userID);


    /**
     * 个人收藏股票
     * @param collectStockForm userid和股票代码
     * @return boolean
     */
    public boolean collectStock(CollectStockForm collectStockForm);

    /**
     * 删除收藏的股票
     * @param collectStockForm userid和股票代码
     * @return boolean
     */
    public boolean deleteCollectedStock(CollectStockForm collectStockForm);
}
