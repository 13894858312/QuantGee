package logic.strategy.backTesting;

/**
 * Created by Mark.W on 2017/4/10.
 * 持有股票的信息
 */
public class LogicHoldingStock {
    private String stockCode;
    private double numOfStock;

    private boolean canContinueHold;      //调仓时可否继续持有
    /**
     * @param stockCode 股票代码
     * @param numOfStock 持有股票数
     */
    public LogicHoldingStock(String stockCode, double numOfStock) {
        this.stockCode = stockCode;
        this.numOfStock = numOfStock;
        canContinueHold = true;
    }

    public String getStockCode() {
        return stockCode;
    }

    public double getNumOfStock() {
        return numOfStock;
    }

    public boolean isCanContinueHold() {
        return canContinueHold;
    }

    public void setCanContinueHold(boolean canContinueHold) {
        this.canContinueHold = canContinueHold;
    }
}
