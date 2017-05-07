package service.trade;

import bean.Trade;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface TradeService {

	/**
	 * 获取所有模拟交易的交易记录
	 * @param userID	用户名
	 * @return ArrayList<Trade> 交易记录
	 */
    public ArrayList<Trade> getTrades(String userID);

    /**
     * 购买股票
     * @param trade		购买信息（股票代码、时间、数量等）
     * @return boolean 是否购买成功
     */
    public boolean buyStock(Trade trade);

    /**
     * 卖出股票
     * @param trade		卖出信息（股票代码、时间、数量等）
     * @returnboolean 是否卖出成功
     */
    public boolean sellStock(Trade trade);

}
