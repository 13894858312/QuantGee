package logic.stock;

import org.springframework.stereotype.Service;
import service.stock.PredictStockService;
import vo.stock.StockPredictVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 */
@Service
public class PredictStockServiceImp implements PredictStockService {
    @Override
    public ArrayList<StockPredictVO> getStockPredictInfo(String code) {
        return null;
    }

}
