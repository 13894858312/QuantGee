package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.MarketInfo;
import bean.Stock;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import service.stock.StockInfoService;
import vo.stock.StockCurrentVO;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;
import vo.stock.StockPredictionVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class StockInfoServiceImp implements StockInfoService{

    @Autowired
    private StockInfoDAO stockInfoDAO;
    @Autowired
    private StockDataCalculation stockDataCalculation;
    @Autowired
    private TransferHelper transferHelper;

    @Override
    public ArrayList<StockCurrentVO> getAllRealTimeStocks() {
        Iterator<String> codes = stockInfoDAO.getAllStockCodes();
        MarketInfo marketInfo = null;
        Stock stock = null;

        if(codes == null) {
            return null;
        }

        ArrayList<StockCurrentVO> stockCurrentVOS = new ArrayList<>();
        while(codes.hasNext()) {
            String code = codes.next();
            StockCurrentVO stockCurrentVO = getRealTimeStockInfo(code);
            stockCurrentVOS.add(stockCurrentVO);
        }

       return stockCurrentVOS;
    }

    @Override
    public StockCurrentVO getRealTimeStockInfo(String code) {

//        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(code);
//        Stock stock = stockInfoDAO.getStockRealTimeInfo(code);
//
//        StockCurrentVO stockCurrentVO = transferHelper.transToStockCurrent(marketInfo, stock);
//
//        return stockCurrentVO;
        return null;
    }

    @Override
    public ArrayList<StockHistoricalVO> getStockHistoricalInfo(StockInputVO inputVO) {

//        if(inputVO == null) {
//            return null;
//        }
//        MarketInfo marketInfo = stockInfoDAO.getMarketInfo(inputVO.getStockCode());
//        ArrayList<StockHistoricalVO> result = new ArrayList<>();
//        Stock stock = null;
//        Stock formerStock = null;
//
//        Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.getStockCode(),
//                inputVO.getStartDate(), inputVO.getEndDate(), "D");
//
//        while(stocks.hasNext()) {
//
//            formerStock = stock;
//            stock = stocks.next();
//
//            StockHistoricalVO historicalVO = transferHelper.transToStockHistorical(marketInfo, stock);
//
//            //k线图的数据
//            KLineData kLineData = stockDataCalculation.calculateKLine(historicalVO);
//            historicalVO.setPositive(kLineData.isPositive());
//            historicalVO.setUpperShadow(kLineData.getUpperShadow());
//            historicalVO.setLowerShadow(kLineData.getLowerShadow());
//
//            //对数收益率
//            if(formerStock != null && stock != null) {
//                double logarithmYield = Math.log(stock.getClose() / formerStock.getClose());
//                historicalVO.setLogarithmYield(logarithmYield);
//            }
//
//            result.add(historicalVO);
//        }
//
//        return result;

        return null;
    }

    @Override
    public ArrayList<StockCurrentVO> getStocksByIndustry(String industryName) {
        Iterator<String> codes = stockInfoDAO.getAllStockCodesByIndustry(industryName);
        if(codes == null) {
            return null;
        }

        ArrayList<StockCurrentVO> result = new ArrayList<>();

        while(codes.hasNext()) {
            String code = codes.next();
            StockCurrentVO currentVO = getRealTimeStockInfo(code);
            result.add(currentVO);
        }

        return result;
    }

    @Override
    public StockPredictionVO predictStockTrend(String stockCode) {
        return null;
    }

    public StockInfoDAO getStockInfoDAO() {
        return stockInfoDAO;
    }

    public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
        this.stockInfoDAO = stockInfoDAO;
    }

    public StockDataCalculation getStockDataCalculation() {
        return stockDataCalculation;
    }

    public void setStockDataCalculation(StockDataCalculation stockDataCalculation) {
        this.stockDataCalculation = stockDataCalculation;
    }

    public TransferHelper getTransferHelper() {
        return transferHelper;
    }

    public void setTransferHelper(TransferHelper transferHelper) {
        this.transferHelper = transferHelper;
    }
}
