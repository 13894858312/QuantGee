package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/14.
 */
@Entity
public class Trade {
    private int tradeId;
    private String userId;
    private String time;
    private String stockId;
    private int action;
    private int numOfStock;

    @Id
    @Column(name = "tradeID")
    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    @Basic
    @Column(name = "userID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "stockID")
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "action")
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @Basic
    @Column(name = "numOfStock")
    public int getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(int numOfStock) {
        this.numOfStock = numOfStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        if (tradeId != trade.tradeId) return false;
        if (action != trade.action) return false;
        if (numOfStock != trade.numOfStock) return false;
        if (userId != null ? !userId.equals(trade.userId) : trade.userId != null) return false;
        if (time != null ? !time.equals(trade.time) : trade.time != null) return false;
        if (stockId != null ? !stockId.equals(trade.stockId) : trade.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tradeId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + action;
        result = 31 * result + numOfStock;
        return result;
    }
}
