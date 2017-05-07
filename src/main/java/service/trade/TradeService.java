package service.trade;

import bean.Trade;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 */
public interface TradeService {

    public ArrayList<Trade> getSimulationStockTrades(String userID);

    public boolean buyStock(Trade trade);

    public boolean sellStock(Trade trade);

}
