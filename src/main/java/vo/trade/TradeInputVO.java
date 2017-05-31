package vo.trade;

/**
 * Created by Mark.W on 2017/5/31.
 * 获取持有股票信息的输入信息
 */
public class TradeInputVO {
    private String userID;
    private String stockCode;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
}
