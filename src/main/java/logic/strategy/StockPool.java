package logic.strategy;

import po.StockPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 股票池
 * Created by Mark.W on 2017/3/29.
 */
public class StockPool {
    private ArrayList<StockInfo> stockInfos;
    private Date startDate;
    private Date endDate;


    public StockPool(ArrayList<StockInfo> stockInfos) {
        this.stockInfos = stockInfos;
    }

    public StockPool(ArrayList<StockPO>[] stockPOS) {
        this.stockInfos = new ArrayList<>();


    }


}
