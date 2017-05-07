package service.trade;

import bean.Trade;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface TradeService {

    public String getSimulationStockTradeInfo(String userID);

    public String buyStock(Trade trade);

    public String sellStock(Trade trade);

}
