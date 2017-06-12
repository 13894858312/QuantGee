package data.tradeData;

import DAO.tradeDAO.TradeDAO;
import bean.HoldingStock;
import bean.HoldingStockPK;
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
        return (Iterator<Trade>) hibernateTemplate
                .find("from Trade where userId = ? and stockId = ?", new String[]{userID, stockCode});
    }

    @Override
    public HoldingStock getHoldingStock(String userID, String stockCode) {
        HoldingStockPK holdingStockPK = new HoldingStockPK();
        holdingStockPK.setCode(stockCode);
        holdingStockPK.setUserId(userID);
        return hibernateTemplate.get(HoldingStock.class, holdingStockPK);
    }

    @Override
    public boolean addTradeInfo(Trade trade) {
        try{
            hibernateTemplate.save(trade);
            hibernateTemplate.flush();
            return true;
        }catch (Exception e){
            return false;
        }
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
        try{
        int newNum = holdingStock.getHoldNum();
        String stockID = holdingStock.getCode();
        String userID = holdingStock.getUserId();
        double sellOutMoney = holdingStock.getSellOutMoney();
        double initFund = holdingStock.getInitFund();

        Iterator<HoldingStock> iterator = (Iterator<HoldingStock>) hibernateTemplate
                .find("from HoldingStock  h where h.userId = ? and h.code = ?",
                        new String[] {userID, stockID}).iterator();

        if(iterator.hasNext()){
            HoldingStock old = iterator.next();
            old.setInitFund(initFund);
            old.setSellOutMoney(sellOutMoney);
            old.setHoldNum(newNum);
            hibernateTemplate.update(old);
            return true;
        }

        if(newNum<0){
            return false;
        }

        hibernateTemplate.save(holdingStock);
        hibernateTemplate.flush();
        return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateUserMoney(String userID, double money) {
        UserMoney userMoney = hibernateTemplate.get(UserMoney.class, userID);
        try{
            if(userMoney != null){
                userMoney.setMoney(money);
                hibernateTemplate.update(userMoney);
                hibernateTemplate.flush();
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public double getUserMoney(String userID) {
        UserMoney userMoney = hibernateTemplate.get(UserMoney.class, userID);
        if(userMoney!=null){
            return userMoney.getMoney();
        }
        return -1;
    }


}
