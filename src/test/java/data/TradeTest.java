package data;

import DAO.tradeDAO.TradeDAO;
import bean.HoldingStock;
import bean.Trade;
import bean.UserMoney;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import po.HoldingStocksPO;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TradeTest {

    @Autowired
    TradeDAO tradeDAO;

    @Test
    public void addTest(){
        Trade trade = new Trade();
        trade.setUserId("123123");
        trade.setAction(1);
        trade.setIme("ime");
        trade.setNumOfStock(123);
        trade.setStockId("asede");
        Assert.assertEquals(tradeDAO.addTradeInfo(trade),true);
    }

    @Test
    public void getTradeListTest(){
        Iterator<Trade> iterator = tradeDAO.getUserTradeList("123123");
        while (iterator.hasNext()){
            System.out.println(iterator.next().getStockId());
        }
    }
    @Test
    public void updateHoldingTest(){
        HoldingStock holdingStock = new HoldingStock();
        holdingStock.setHoldNum(22);
        holdingStock.setStockId("231323");
        holdingStock.setUserId("123123");
        Assert.assertEquals(tradeDAO.updateHoldingStock(holdingStock),true);
    }

    @Test
    public void updateMoneyTest(){
        UserMoney userMoney = new UserMoney();
        userMoney.setUserId("123123");
        userMoney.setRemainMoney(600);
        Assert.assertEquals(tradeDAO.updateUserMoney(userMoney),true);
    }

    @Test
    public void getHoldingTest(){
        HoldingStocksPO holdingStockPO = tradeDAO.getHoldingStocks("123123");
        System.out.print(holdingStockPO.getStockAndNum());
    }

}
