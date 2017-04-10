package logic.strategy;

/**
 * Created by Mark.W on 2017/4/10.
 */
public class HoldingStock {
    private String stockCode;
    private double numOfStock;      //持有股票数

    public HoldingStock(String stockCode, double numOfStock) {
        this.stockCode = stockCode;
        this.numOfStock = numOfStock;
    }

    public String getStockCode() {
        return stockCode;
    }

    public double getNumOfStock() {
        return numOfStock;
    }
}
