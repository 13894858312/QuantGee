package DAO.tradeDAO;

import bean.HoldingStock;
import bean.Trade;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface TradeDAO {

    /**
     * 根据用户名和指定股票代码获取交易记录
     * @param userID 用户名
     * @param stockCode 股票代码
     * @return Iterator<Trade>
     */
    public Iterator<Trade> getUserTradeList(String userID, String stockCode);

    /**
     * 根据用户名和指定股票代码获取持有股票信息
     * @param userID 用户名
     * @param stockCode 股票代码
     * @return LogicHoldingStock
     */
    public HoldingStock getHoldingStock(String userID, String stockCode);


    /**
     * 增持或卖出股票 有就更新 没有就添加
     * @param holdingStock 股票ID，购买数(负为卖出数)，用户ID，目前收益率
     * @return 是否成功
     */
    public boolean updateHoldingStock(HoldingStock holdingStock);

    /**
     * 添加交易记录
     * @param trade 要添加的交易记录
     * @return boolean 是否添加成功
     */
    public boolean addTradeInfo(Trade trade);

    /**
     * 得到对应用户的全部交易记录
     * @param userID 用户ID
     * @return 交易记录
     */
    public Iterator<Trade> getUserTradeList(String userID);

    /**
     * 得到用户持有的所有股票代码,持有数,及目前收益率
     * @param userID 用户ID
     * @return 用户持有的所有股票代码,持有数,及目前收益率
     */
    public Iterator<HoldingStock> getHoldingStocks(String userID);

    /**
     * 更新模拟交易用户的余额
     * @param userID 用户id
     * @param money 余额
     * @return boolean
     */
    public boolean updateUserMoney(String userID, double money);

    /**
     * 获取模拟交易用户的余额
     * @param userID 用户id
     * @return 余额
     */
    public double getUserMoney(String userID);

}
