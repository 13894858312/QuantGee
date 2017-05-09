package data.tradeData;

import DAO.tradeDAO.TradeDAO;
import po.TradePO;

import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/5.
 */
public class TradeData implements TradeDAO{

    @Override
    public boolean addTradeInfo(TradePO tradePO) {
        return false;
    }

    @Override
    public ArrayList<TradePO> getUserTradeList(String userID) {
        return null;
    }

}
