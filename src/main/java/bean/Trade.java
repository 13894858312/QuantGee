package bean;

/**
 * Created by wangxue on 2017/5/12.
 */
public class Trade {

    private String userID;		//操作用户
    private String time;	//操作时间
    private String stockCode;	//操作的股票代码
    private Integer action;		//0表示买。1表示卖
    private Integer numOfStock;		//买卖数量

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(Integer numOfStock) {
        this.numOfStock = numOfStock;
    }

}
