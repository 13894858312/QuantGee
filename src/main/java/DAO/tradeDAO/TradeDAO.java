package DAO.tradeDAO;

import bean.HoldingStock;
import bean.Trade;
import bean.UserMoney;
import po.HoldingStocksPO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface TradeDAO {

    /**
     * 添加交易记录
     * @param tradePO 要添加的交易记录
     * @return boolean 是否添加成功
     */
    public boolean addTradeInfo(Trade tradePO);

    /**
     * 得到对应用户的全部交易记录
     * @param userID 用户ID
     * @return 交易记录
     */
    public Iterator<Trade> getUserTradeList(String userID);

    /**
     * 得到用户持有的所有股票代码及持有数，及用户剩余虚拟金钱
     * @param userID 用户ID
     * @return
     */
    public HoldingStocksPO getHoldingStocks(String userID);

    /**
     * 增持股票
     * @param holdingStock 股票ID，购买数(负为卖出数)，用户ID
     * @return 是否成功
     */
    public boolean updateHoldingStock(HoldingStock holdingStock);

    /**
     * 更新用户持有现金金额
     * @param userMoney 用户ID，用户持有现金
     * @return
     */
    public boolean updateUserMoney(UserMoney userMoney);

}
