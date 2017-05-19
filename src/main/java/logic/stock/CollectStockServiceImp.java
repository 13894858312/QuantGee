package logic.stock;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Current;
import bean.MarketInfo;
import bean.Stock;
import logic.tools.TransferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.stock.CollectStockService;
import vo.stock.StockCollectInputVO;
import vo.stock.StockCurrentVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/15.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollectStockServiceImp implements CollectStockService{

    @Autowired
    private StockInfoDAO stockInfoDAO;
    @Autowired
    private TransferHelper transferHelper;

    @Override
    public ArrayList<StockCurrentVO> getCollectedStocks(String userID) {
        Iterator<String> stocks = stockInfoDAO.getCollectedStocks(userID);
        MarketInfo marketInfo = null;

        if(stocks == null) {
            return null;
        }

        ArrayList<StockCurrentVO> stockCurrentVOS = new ArrayList<>();

        while(stocks.hasNext()) {
            String string = stocks.next();
            marketInfo = stockInfoDAO.getMarketInfo(string);
            Current current = stockInfoDAO.getStockRealTimeInfo(string);

            StockCurrentVO stockVO = transferHelper.transToStockCurrent(marketInfo, current);

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
}
