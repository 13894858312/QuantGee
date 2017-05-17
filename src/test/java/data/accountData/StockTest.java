package data.accountData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Current;
import bean.MarketInfo;
import bean.Stock;
import data.stockInfoData.StockInfoData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/17.
 */
public class StockTest {
    StockInfoDAO stockInfoDAO = new StockInfoData();

    @Test
    public void getStockInfoTest(){
        Iterator<Stock> stockIterator = stockInfoDAO.getStockInfo("000001");
        while (stockIterator.hasNext()){
            System.out.println(stockIterator.next().getDate());
        }
    }

    @Test
    public void getStockInfoRange(){
        Iterator<Stock> stockIterator = stockInfoDAO.getStockInfo("000001","2015-01-05","2015-02-03");
        while (stockIterator.hasNext()){
            System.out.println(stockIterator.next().getDate());
        }
    }

    @Test
    public void getAllStockCodesTest(){
        Iterator<String> iterator = stockInfoDAO.getAllStockCodes();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
    }

    @Test
    public void getCurrent(){
        Current current = stockInfoDAO.getStockRealTimeInfo("000001");
        Assert.assertEquals(current.getName(),"平安银行");
    }

    @Test
    public void getMarketTest(){
        MarketInfo marketInfo = stockInfoDAO.getMarketInfo("000002");
        Assert.assertEquals(marketInfo.getMarket(),"房地产");
    }
}

