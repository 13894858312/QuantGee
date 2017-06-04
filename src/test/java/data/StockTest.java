package data;

import DAO.stockInfoDAO.CollectStockDAO;
import DAO.stockInfoDAO.QuotaDAO;
import DAO.stockInfoDAO.StockInfoDAO;
import bean.*;
import data.stockInfoData.StockInfoData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class StockTest {

    @Autowired
    StockInfoDAO stockInfoDAO;
    @Autowired
    QuotaDAO quotaDAO;
    @Autowired
    CollectStockDAO collectStockDAO;

    @Test
    public void getStockInfoTest(){
        Iterator<Stock> stockIterator = stockInfoDAO.getStockInfo("sh");
        while (stockIterator.hasNext()){
            System.out.println(stockIterator.next().getTurnover());
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
    public void getStockInfoByDate(){
        Stock stock = stockInfoDAO.getStockInfo("000001","2015-01-30");
        Assert.assertEquals(stock.getOpen(),(Double) 13.93);
    }

    @Test
    public void getCurrent(){
        Current current = stockInfoDAO.getStockRealTimeInfo("000001");
        Assert.assertEquals(current.getName(),"平安银行");
    }

    @Test
    public void getMarketTest(){
        MarketInfo marketInfo = stockInfoDAO.getMarketInfo("000002");
        Assert.assertEquals(marketInfo.getcName(),"房地产");
    }

    @Test
    public void industryTest(){
        Iterator<String> iterator = stockInfoDAO.getAllStockCodesByIndustry("房地产");
        for(int i = 0 ; i < 10 && iterator.hasNext() ; i ++ ){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void getBlock1(){
        Iterator<String> iterator = stockInfoDAO.getAllStockCodesByBlock("sz");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void getBlock2(){
        Iterator<String> iterator = stockInfoDAO.getAllStockCodesByBlock("zxb");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void getCollectStockTest(){
        Iterator<String>  iterator = collectStockDAO.getCollectedStocks("123");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void addCollect(){
        Assert.assertEquals(collectStockDAO.addCollectedStock("22392e","34334"),true);
    }

    @Test
    public void removeCollect(){
        Assert.assertEquals(collectStockDAO.removeCollectedStock("222","333"),true);
    }

    @Test
    public void getHistoryTest(){
        Iterator<History> historyIterator = stockInfoDAO.getHistory("000002");
        while (historyIterator.hasNext()){
            System.out.println(historyIterator.next().getDate());
        }
    }

    @Test
    public void addMacdTest(){
        Macd macd = new Macd();
        macd.setCode("123123");
        macd.setDate("21d2");
        macd.setDea(123.2);
        macd.setDiff(2.2);
        macd.setMacd(23.1);
        Assert.assertEquals(quotaDAO.addMACD(macd),true);
    }

    @Test
    public void getMacdTest(){
        Iterator<Macd> iterator = quotaDAO.getMACDs("200","232","123123");
        while (iterator.hasNext()){
            System.out.print(iterator.next().getDea());
        }
    }

    @Test
    public void addKdjTest(){
        Kdj kdj = new Kdj();
        kdj.setCode("000001");
        kdj.setD(2.0);
        kdj.setK(1.0);
        kdj.setJ(3.0);
        kdj.setDate("2019-03-01");
        Assert.assertEquals(quotaDAO.addKDJ(kdj),true);
    }

    @Test
    public void getKDJTest(){
        Iterator<Kdj> kdjIterator = quotaDAO.getKDJs("0","3010","000001");
        while (kdjIterator.hasNext()){
            System.out.println(kdjIterator.next().getDate());
        }
    }

    @Test
    public void currentTest(){
        Current current = stockInfoDAO.getStockRealTimeInfo("000001");
        System.out.print(current.getTime());
    }

    @Test
    public void currentListTest(){
        Iterator<Current> iterator = stockInfoDAO.getStockRealTimeList("000001");
        while (iterator.hasNext()){
            System.out.println(iterator.next().getAmount());
        }
    }

    @Test
    public void getPredictTest(){
        Iterator<StockPredict> stockPredict = quotaDAO.getPredictData("000001","0", "2020-20-20");
        System.out.print(stockPredict);
    }
}

