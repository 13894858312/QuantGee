package logic.strategy;

import po.StockPO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略计算时保存一种股票指定区间信息的类
 */
public class StockInfo {
    private int index;
    private String stockCode;
    private ArrayList<StockPO> stockPOS;

    public StockInfo(String stockCode, ArrayList<StockPO> stockPOS) {
        this.stockCode = stockCode;
        this.stockPOS = stockPOS;
    }
}
