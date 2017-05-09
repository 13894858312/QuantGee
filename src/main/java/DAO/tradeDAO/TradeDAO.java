package DAO.tradeDAO;

import PO.TradePO;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface TradeDAO {

    /**
     * 添加交易记录
     * @param tradePO 要添加的交易记录
     * @return boolean 是否添加成功
     */
    public boolean addTradeInfo(TradePO tradePO);

    /**
     * 得到对应用户的全部交易记录
     * @param userID 用户ID
     * @return ArrayList<Trade> 交易记录
     */
    public ArrayList<TradePO> getUserTradeList(String userID);

}
