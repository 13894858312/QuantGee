package data.tradeData;

import DAO.tradeDAO.TradeDAO;
import bean.HoldingStock;
import bean.Trade;
import bean.UserMoney;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

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
    public Iterator<Trade> getUserTradeList(String userID, String stockCode) {
        return null;
    }

    @Override
    public HoldingStock getHoldingStock(String userID, String stockCode) {
        return null;
    }

    @Override
    public boolean addTradeInfo(Trade trade) {
        hibernateTemplate.save(trade);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public Iterator<Trade> getUserTradeList(String userID) {
        Iterator<Trade> iterator = (Iterator<Trade>) hibernateTemplate
                .find("from Trade t where t.userId =?",userID).iterator();
        return iterator;
    }

    @Override
    public Iterator<HoldingStock> getHoldingStocks(String userID) {
        Iterator<HoldingStock> holdingStockIterator = (Iterator<HoldingStock>) hibernateTemplate
                .find("from HoldingStock h where h.userId =?",userID).iterator();

        return holdingStockIterator;
    }

    @Override
    public boolean updateHoldingStock(HoldingStock holdingStock) {
        int newNum = holdingStock.getHoldNum();
        String stockID = holdingStock.getStockId();
        String userID = holdingStock.getUserId();
        double sellOutMoney = holdingStock.getSellOutMoney();
        double initFund = holdingStock.getInitFund();

        HoldingStock old = (HoldingStock) hibernateTemplate
                .find("from HoldingStock  h where h.userId = ? and h.stockId = ?",
                        new String[] {userID, stockID}).iterator().next();

        if(old != null){
            int oriNum = old.getHoldNum();
            if(newNum + oriNum < 0){
                return false;
            }
            old.setInitFund(initFund);
            old.setSellOutMoney(sellOutMoney);
            old.setHoldNum(newNum+oriNum);
            hibernateTemplate.update(old);
            return true;
        }

        if(newNum<0){
            return false;
        }

        hibernateTemplate.save(holdingStock);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public double getUserRemainMoney(String userID) {
        return hibernateTemplate.get(UserMoney.class, userID).getRemainMoney();
    }

    @Override
    public boolean updateUserMoney(UserMoney userMoney) {
        hibernateTemplate.saveOrUpdate(userMoney);
        return true;
    }

}
