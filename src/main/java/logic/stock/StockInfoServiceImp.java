package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import service.stock.StockInfoService;
import vo.stock.StockCurrentVO;
import vo.stock.StockHistoricalVO;
import vo.stock.StockInputVO;
import vo.stock.StockPredictionVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class StockInfoServiceImp implements StockInfoService{

    private StockInfoDAO stockInfoDAO;

    @Override
    public ArrayList<StockCurrentVO> getAllRealTimeStocks() {
       return null;
    }

    @Override
    public StockCurrentVO getRealTimeStockInfo(String stockCode) {
        return null;
    }

    @Override
    public ArrayList<StockHistoricalVO> getStockHistoricalInfo(StockInputVO stockInputVO) {
        return null;
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
}
