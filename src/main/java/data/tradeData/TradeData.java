package data.tradeData;

import DAO.tradeDAO.TradeDAO;
import bean.Trade;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public class TradeData implements TradeDAO {

    @Override
    public boolean addTradeInfo(Trade trade) {
        return false;
    }

    @Override
    public ArrayList<Trade> getUserTradeList(String userID) {
        return null;
    }

}
