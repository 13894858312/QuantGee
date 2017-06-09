package logic.stock;

import DAO.stockInfoDAO.CollectStockDAO;
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
    private CollectStockDAO collectStockDAO;

    @Autowired
    private StockBasicInfoServiceImp stockBasicInfoServiceImp;

    @Override
    public ArrayList<StockCurrentVO> getCollectedStocks(String userID) {
        Iterator<String> codes = collectStockDAO.getCollectedStocks(userID);
        return stockBasicInfoServiceImp.getStockCurrentVOs(codes);
    }

    @Override
    public boolean collectStock(StockCollectInputVO inputVO) {
        if(collectStockDAO.addCollectedStock(inputVO.getUserID(), inputVO.getCode())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteCollectedStock(StockCollectInputVO inputVO) {
        if(collectStockDAO.removeCollectedStock(inputVO.getUserID(), inputVO.getCode())) {
            return true;
        }

        return false;
    }
}
