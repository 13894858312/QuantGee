package data.accountData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Current;
import bean.MarketInfo;
import bean.Stock;
import data.stockInfoData.StockInfoData;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
//
//    @Test
//    public void getTxt() throws Exception{
//        File file = new File("/MyGit/QuantGee/src/main/resources/a.txt");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        ArrayList<String> arrayList = new ArrayList<>();
//        String str;
//        while ((str = bufferedReader.readLine())!=null){
//            System.out.print("\""+str.substring(0,6)+"\",");
//        }
//    }
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
        Iterator<String>  iterator = stockInfoDAO.getCollectedStocks("123");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void addCollect(){
        Assert.assertEquals(stockInfoDAO.addCollectedStock("222","333"),true);
    }

    @Test
    public void removeCollect(){
        Assert.assertEquals(stockInfoDAO.removeCollectedStock("222","333"),true);
    }
}

