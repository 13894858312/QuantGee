package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.MarketInfo;
import bean.Stock;
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
        ArrayList<String> codes = stockInfoDAO.getAllStockCodes();
        MarketInfo marketInfo = null;
        Stock stock = null;

        if(codes == null || codes.size() == 0) {
            return null;
        }

        ArrayList<StockCurrentVO> stockCurrentVOS = new ArrayList<>();
        for(String code : codes) {
            marketInfo = stockInfoDAO.getMarketInfo(code);
            stock = stockInfoDAO.getStockRealTimeInfo(code);

            StockCurrentVO stockCurrentVO = new StockCurrentVO();
            stockCurrentVO.setStockCode(marketInfo.getStockID());
            stockCurrentVO.setStockName(marketInfo.getStockName());
            stockCurrentVO.setStockMarket(marketInfo.getcMarket());
            stockCurrentVO.setOpen(stock.getOpen());
            stockCurrentVO.setClose(stock.getClose());
            stockCurrentVO.setLow(stock.getLow());
            stockCurrentVO.setHigh(stock.getHigh());
            stockCurrentVO.setVolume(stock.getVolume());
            stockCurrentVO.setP_change(stock.getpChange());
            stockCurrentVO.setPrice_change(stock.getPriceChange());
//            stockCurrentVO.setTurnover(stock.getTurnOver());
            //缺少换手率数据

            stockCurrentVOS.add(stockCurrentVO);
        }

       return stockCurrentVOS;
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
