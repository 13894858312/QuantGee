package service.trade;

import bean.HoldingStock;
import vo.trade.TradeInputVO;
import vo.trade.HoldingStockVO;
import vo.trade.TradeRecordVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 * 股票模拟交易的接口
 */
public interface TradeService {

    /**
     * 对于指定用户和股票代码获取交易记录
     * @param inputVO 用户名和股票代码
     * @return ArrayList<HoldingStockVO>
     */
    public ArrayList<TradeRecordVO> getTradeRecords(TradeInputVO inputVO);


	/**
	 * 获取所有模拟交易的交易记录
	 * @param userID	用户名
	 * @return ArrayList<Trade> 交易记录
	 */
    public ArrayList<TradeRecordVO> getTradeRecords(String userID);


    /**
     * 购买或者卖出股票
     * @param tradeRecordVO	tradeRecordVO
     * @return boolean 是否成功
     */
    public boolean addTradeRecord(TradeRecordVO tradeRecordVO);

    /**
     * 获取实时的模拟买入股票收益率数据
     * 刷新界面获取
     * @param inputVO 用户id 股票代码
     * @return HoldingStockVO
     */
    public HoldingStockVO getRealTimeHoldingStockInfo(TradeInputVO inputVO);

    /**
     * 对于每个用户当前所有模拟交易的信息
     * @param userID 用户id
     * @return ArrayList<HoldingStockVO>
     */
    public ArrayList<HoldingStockVO> getHoldingStocks(String userID);

}
