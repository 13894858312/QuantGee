package logic.stock;

import org.springframework.stereotype.Service;
import service.stock.PredictStockService;

/**
 * Created by Mark.W on 2017/5/21.
 */
@Service
public class PredictStockServiceImp implements PredictStockService {

//
//    @Autowired
//    private StockInfoDAO stockInfoDAO;
//
//    /**
//     * 默认参数为 MACD(12,26,9)
//     * MACD的计算方法
//     * DIFF : EMA(CLOSE,SHORT) - EMA(CLOSE,LONG);
//     * DEA  : EMA(DIFF,MID);
//     * MACD : 2*(DIFF-DEA), COLORSTICK;
//     */
//    @Override
//    public ArrayList<MACD> getMACDInfo(StockInputVO inputVO) {
//
//        ArrayList<MACD> MACDS = stockInfoDAO.getMACDs(inputVO.getStartDate(), inputVO.getEndDate(), inputVO.getStockCode());
//        if (MACDS == null || MACDS.size() == 0) {
//            return null;
//        }
//
//        ArrayList<MACD> result = new ArrayList<>();
//
//        for(MACD MACD : MACDS) {
//            result.add(new MACD(MACD.getDate(), MACD.getCode(), MACD.getDiff(), MACD.getDea(), MACD.getMacd()));
//        }
//
//        return result;
//    }
//
//    //默认参数为 KDJ(9,3,3)
//    @Override
//    public ArrayList<KDJ> getKDJInfo(StockInputVO inputVO) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<RSI> getRSIInfo(StockInputVO inputVO) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<BOLL> getBOLLInfo(StockInputVO inputVO) {
//        return null;
//    }
//

}
