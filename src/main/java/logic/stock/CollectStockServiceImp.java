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
import service.stock.StockBasicInfoService;
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
    private StockBasicInfoServiceImp stockBasicInfoServiceImp;

    @Override
    public ArrayList<StockCurrentVO> getCollectedStocks(String userID) {
        Iterator<String> codes = stockInfoDAO.getCollectedStocks(userID);
        return stockBasicInfoServiceImp.getStockCurrentVOs(codes);
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
