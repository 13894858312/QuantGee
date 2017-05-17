package data.accountData;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;
import data.stockInfoData.StockInfoData;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by wangxue on 2017/5/17.
 */
public class StockTest {
    StockInfoDAO stockInfoDAO = new StockInfoData();

    @Test
    public void getStockInfoTest(){
        Iterator<Stock> stockIterator = stockInfoDAO.getStockInfo("600348");
//        if(stockIterator == null ){
//            System.out.print("null");
//            return;
//        }
        while (stockIterator.hasNext()){
            System.out.print(stockIterator.next().getDate());
        }
    }

    @Test
    public void getAllStockCodesTest(){
        stockInfoDAO.getAllStockCodes();
    }
}
