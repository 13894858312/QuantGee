package vo.trade;

/**
 * Created by Mark.W on 2017/5/11.
 * 模拟交易 交易记录的vo
 */
public class TradeRecordVO {
    private String time; //时间格式 YYYY-MM-DD HH:mm:ss
    private String userID;
    private String stockCode;
    private int action;         // 0买入 1卖出
    private int numOfStock;

    private double price;

    public TradeRecordVO() {}

    /**
     * @param time 时间 具体到时分秒
     * @param stockCode 股票代码
     * @param action 买入或卖出
     * @param numOfStock 买入或者卖出的股票数量
     * @param price 进行该交易时股票的价格
     */
    public TradeRecordVO(String time,String userID, String stockCode, int action,
                         int numOfStock, double price) {
        this.time = time;
        this.userID = userID;
        this.stockCode = stockCode;
        this.action = action;
        this.numOfStock = numOfStock;
        this.price = price;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getAction() {
        return action;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int isAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(int numOfStock) {
        this.numOfStock = numOfStock;
    }
}
