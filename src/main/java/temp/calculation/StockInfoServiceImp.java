//package temp.calculation;
//
//import data.StockData;
//import dataDao.StockDataDao;
//import logicService.StockInfoService;
//
//import java.util.ArrayList;
//
///**
// * 获取所有股票名字和代码的接口
// * Created by Mark.W on 2017/4/19.
// */
//public class StockInfoServiceImp implements StockInfoService {
//    private StockDataDao stockDataDao;
//
//    public StockInfoServiceImp() {
//        this.stockDataDao = new StockData();
//    }
//
//    @Override
//    public ArrayList<String> getAllStockInfo() {
//        return stockDataDao.getAllStockName();
//    }
//}
