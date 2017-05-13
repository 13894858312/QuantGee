package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/12.
 */
@Entity
public class Trade {

    private Integer tradeID;
    private String userID;		//操作用户
    private String time;	//操作时间
    private String stockCode;	//操作的股票代码
    private Integer action;		//0表示买。1表示卖
    private Integer numOfStock;		//买卖数量
    private int tradeId;
    private String userId;
    private String stockId;

    public void setAction(int action) {
        this.action = action;
    }

    public void setNumOfStock(int numOfStock) {
        this.numOfStock = numOfStock;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name = "time", nullable = false, length = 20)
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

    @Basic
    @Column(name = "action", nullable = false)
    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    @Basic
    @Column(name = "numOfStock", nullable = false)
    public Integer getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(Integer numOfStock) {
        this.numOfStock = numOfStock;
    }

    public Integer getTradeID() {
        return tradeID;
    }

    public void setTradeID(Integer tradeID) {
        this.tradeID = tradeID;
    }

    @Id
    @Column(name = "tradeID", nullable = false)
    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    @Basic
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "stockID", nullable = false, length = 6)
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        if (tradeId != trade.tradeId) return false;
        if (time != null ? !time.equals(trade.time) : trade.time != null) return false;
        if (action != null ? !action.equals(trade.action) : trade.action != null) return false;
        if (numOfStock != null ? !numOfStock.equals(trade.numOfStock) : trade.numOfStock != null) return false;
        if (userId != null ? !userId.equals(trade.userId) : trade.userId != null) return false;
        if (stockId != null ? !stockId.equals(trade.stockId) : trade.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tradeId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (numOfStock != null ? numOfStock.hashCode() : 0);
        return result;
    }
}
