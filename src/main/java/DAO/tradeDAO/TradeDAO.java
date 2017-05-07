package DAO.tradeDAO;

import bean.Trade;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public interface TradeDAO {

    public boolean addTradeInfo(Trade trade);

    public ArrayList<Trade> getUserTradeList(String userID);

}
