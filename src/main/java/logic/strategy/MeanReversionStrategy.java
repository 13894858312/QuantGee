package logic.strategy;

import java.util.ArrayList;
import java.util.Date;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
public class MeanReversionStrategy implements Strategy {

    @Override
    public ArrayList<StockYield> initHoldingStocks(StockPool stockPool) {
        return null;
    }

    @Override
    public ArrayList<StockYield> rebalanceHoldingStocks(StockPool stockPool, Date beforeDate, Date today) {
        return null;
    }
}
