package data;

import DAO.tradeDAO.TradeDAO;
import bean.HoldingStock;
import bean.Trade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        trade.setPrice(2.0);
        trade.setNumOfStock(123);
//        trade.getStockId("ased22");
        trade.setTime("000");
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
        holdingStock.setCode("231323");
        holdingStock.setUserId("12123");
        holdingStock.setInitFund(2.1);
        holdingStock.setSellOutMoney(1.0);
        Assert.assertEquals(tradeDAO.updateHoldingStock(holdingStock),true);
    }

    @Test
    public void getHoldingTest(){

    }

}
