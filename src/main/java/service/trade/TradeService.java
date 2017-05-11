package service.trade;

import vo.trade.TradeRecordVO;
import vo.trade.TradeUserVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 * 股票模拟交易的接口
 */
public interface TradeService {

    /**
     * 对于每个用户当前所有模拟交易的信息
     * @param userID 用户id
     * @return ArrayList<TradeUserVO>
     */
    public ArrayList<TradeUserVO> getMyCurrentTradeInfo(String userID);

	/**
	 * 获取所有模拟交易的交易记录
	 * @param userID	用户名
	 * @return ArrayList<Trade> 交易记录
	 */
    public ArrayList<TradeRecordVO> getAllMyTrades(String userID);

    /**
     * 购买股票
     * @param tradeRecordVO	购买信息（股票代码、时间、数量等）
     * @return boolean 是否购买成功
     */
    public boolean buyStock(TradeRecordVO tradeRecordVO);

    /**
     * 卖出股票
     * @param tradeRecordVO	卖出信息（股票代码、时间、数量等）
     * @return boolean 是否卖出成功
     */
    public boolean sellStock(TradeRecordVO tradeRecordVO);

}
