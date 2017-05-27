package logic.trade;

import service.trade.TradeService;
import vo.trade.TradeRecordVO;
import vo.trade.TradeUserVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/26.
 */
public class TradeServiceImp implements TradeService {
    @Override
    public ArrayList<TradeUserVO> getMyCurrentTradeInfo(String userID) {
        return null;
    }

    @Override
    public ArrayList<TradeRecordVO> getAllMyTrades(String userID) {
        return null;
    }

    @Override
    public boolean buyStock(TradeRecordVO tradeRecordVO) {
        return false;
    }

    @Override
    public boolean sellStock(TradeRecordVO tradeRecordVO) {
        return false;
    }
}
