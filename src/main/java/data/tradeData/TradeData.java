package data.tradeData;

import DAO.tradeDAO.TradeDAO;
import bean.Trade;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import po.HoldingStocksPO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/5.
 */
@Transactional
public class TradeData implements TradeDAO{

    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public boolean addTradeInfo(Trade trade) {
        return false;
    }

    @Override
    public Iterator<Trade> getUserTradeList(String userID) {
        return null;
    }

    @Override
    public HoldingStocksPO getHoldingStocks(String userID) {
        return null;
    }

    @Override
    public boolean addHoldingStock(String userID, String stockID, int num, int cost) {
        return false;
    }

    @Override
    public boolean sellHoldingStock(String userID, String stockID, int num, int cost) {
        return false;
    }

}
