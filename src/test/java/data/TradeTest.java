package data;

import DAO.tradeDAO.TradeDAO;
import bean.Trade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
