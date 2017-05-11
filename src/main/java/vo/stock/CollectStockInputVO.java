package vo.stock;

/**
 * Created by Mark.W on 2017/5/7.
 * 收藏股票的表单
 */
public class CollectStockInputVO {
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
