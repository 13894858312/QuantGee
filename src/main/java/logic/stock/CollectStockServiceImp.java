package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.MarketInfo;
import bean.Stock;
import logic.tools.TransferHelper;
import service.stock.CollectStockService;
import vo.stock.StockCollectInputVO;
import vo.stock.StockCurrentVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
public class CollectStockServiceImp implements CollectStockService{

    private StockInfoDAO stockInfoDAO;

    @Override
    public ArrayList<StockCurrentVO> getCollectedStocks(String userID) {
        Iterator<Stock> stocks = stockInfoDAO.getCollectedStocks(userID);
        MarketInfo marketInfo = null;

        if(stocks == null) {
            return null;
        }

        ArrayList<StockCurrentVO> stockCurrentVOS = new ArrayList<>();

        while(stocks.hasNext()) {
            Stock stock = stocks.next();
            marketInfo = stockInfoDAO.getMarketInfo(stock.getStockId());

            StockCurrentVO stockVO = TransferHelper.transToStockCurrent(marketInfo, stock);

            stockCurrentVOS.add(stockVO);
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
