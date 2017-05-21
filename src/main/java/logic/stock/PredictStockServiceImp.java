package logic.stock;

import service.stock.PredictStockService;
import vo.stock.BOLLVO;
import vo.stock.KDJVO;
import vo.stock.MACDVO;
import vo.stock.RSIVO;

/**
 * Created by Mark.W on 2017/5/21.
 */
public class PredictStockServiceImp implements PredictStockService {
    @Override
    public MACDVO getMACDInfo(String stockCode) {
        return null;
    }

    @Override
    public KDJVO getKDJInfo(String stockCode) {
        return null;
    }

    @Override
    public RSIVO getRSIInfo(String stockCode) {
        return null;
    }

    @Override
    public BOLLVO getBOLLInfo(String stockCode) {
        return null;
    }
}
