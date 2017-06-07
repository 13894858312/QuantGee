package logic.strategy.backTesting;

/**
 * 计算收益率保存信息的类
 * Created by Mark.W on 2017/3/30.
 */
public class YieldStock {
    private String stockCode;
    private double yield;

    public YieldStock(String stockCode, double yield) {
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
