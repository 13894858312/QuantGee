package logic.strategy;

/**
 * 计算收益率保存信息的类
 * Created by Mark.W on 2017/3/30.
 */
public class StockYield {
    private String stockCode;
    private double yield;

    public StockYield(String stockCode, double yield) {
        this.stockCode = stockCode;
        this.yield = yield;
    }

    public String getStockCode() {
        return stockCode;
    }

    public double getYield() {
        return yield;
    }
}
