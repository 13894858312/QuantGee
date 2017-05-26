package logic.strategy;

import service.stock.CollectStockService;
import vo.stock.StockCollectInputVO;
import vo.stock.StockCurrentVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 */
public class CollectStrategyServiceImp implements CollectStockService {

    @Override
    public ArrayList<StockCurrentVO> getCollectedStocks(String userID) {
        return null;
    }

    @Override
    public boolean collectStock(StockCollectInputVO stockCollectInputVO) {
        return false;
    }

    @Override
    public boolean deleteCollectedStock(StockCollectInputVO stockCollectInputVO) {
        return false;
    }
}
