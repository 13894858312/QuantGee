package vo.trade;

/**
 * Created by Mark.W on 2017/5/11.
 * 模拟交易 交易记录的vo
 */
public class TradeRecordVO {
    private String Time; //时间格式 YYYY-MM-DD HH:mm:ss
    private String stockCode;
    private boolean buyOrNot;
    private double tradeMoney;
    private int numOfStock;
    private double moneyInStock;
    private double moneyInHand;
    private double currentYield;

    public TradeRecordVO() {}

    /**
     * @param time 时间 具体到时分秒
     * @param stockCode 股票代码
     * @param buyOrNot 买入或卖出
     * @param tradeMoney 买入或者卖出的钱
     * @param numOfStock 买入或者卖出的股票数量
     * @param moneyInStock 完成当前操作后 本金+收益中 持有的还在股票中的钱数量
     * @param moneyInHand 完成当前操作后 本金+收益中 到手的钱的数量
     * @param currentYield 完成当前操作后 收益率
     */
    public TradeRecordVO(String time, String stockCode, boolean buyOrNot, double tradeMoney, int numOfStock,
                         double moneyInStock, double moneyInHand, double currentYield) {
        Time = time;
        this.stockCode = stockCode;
        this.buyOrNot = buyOrNot;
        this.tradeMoney = tradeMoney;
        this.numOfStock = numOfStock;
        this.moneyInStock = moneyInStock;
        this.moneyInHand = moneyInHand;
        this.currentYield = currentYield;
    }

    public double getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(double currentYield) {
        this.currentYield = currentYield;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public boolean isBuyOrNot() {
        return buyOrNot;
    }

    public void setBuyOrNot(boolean buyOrNot) {
        this.buyOrNot = buyOrNot;
    }

    public double getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(double tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public int getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(int numOfStock) {
        this.numOfStock = numOfStock;
    }

    public double getMoneyInStock() {
        return moneyInStock;
    }

    public void setMoneyInStock(double moneyInStock) {
        this.moneyInStock = moneyInStock;
    }

    public double getMoneyInHand() {
        return moneyInHand;
    }

    public void setMoneyInHand(double moneyInHand) {
        this.moneyInHand = moneyInHand;
    }
}
