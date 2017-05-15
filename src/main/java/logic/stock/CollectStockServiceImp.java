package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.MarketInfo;
import bean.Stock;
import service.stock.CollectStockService;
import vo.stock.StockCollectInputVO;
import vo.stock.StockCurrentVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class CollectStockServiceImp implements CollectStockService{

    private StockInfoDAO stockInfoDAO;

    @Override
    public ArrayList<StockCurrentVO> getCollectedStocks(String userID) {
        ArrayList<Stock> stocks = stockInfoDAO.getCollectedStocks(userID);
        MarketInfo marketInfo = null;

        if(stocks == null || stocks.size() == 0) {
            return null;
        }

        ArrayList<StockCurrentVO> stockCurrentVOS = new ArrayList<>();

        for(Stock stock : stocks) {
            marketInfo = stockInfoDAO.getMarketInfo(stock.getStockId());
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
    public boolean collectStock(StockCollectInputVO inputVO) {
        if(inputVO != null) {
            if(stockInfoDAO.addCollectedStock(inputVO.getUserID(), inputVO.getStockCode())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteCollectedStock(StockCollectInputVO inputVO) {
        if(inputVO != null) {
            if(stockInfoDAO.removeCollectedStock(inputVO.getUserID(), inputVO.getStockCode())) {
                return true;
            }
        }

        return false;
    }

    public StockInfoDAO getStockInfoDAO() {
        return stockInfoDAO;
    }

    public void setStockInfoDAO(StockInfoDAO stockInfoDAO) {
        this.stockInfoDAO = stockInfoDAO;
    }
}
