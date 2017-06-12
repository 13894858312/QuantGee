package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/6/12.
 */
@Entity
@IdClass(TradePK.class)
public class Trade {
    private String userId;
    private String stockId;
    private int action;
    private int numOfStock;
    private String time;
    private Double price;

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "stockID", nullable = false, length = 10)
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "action", nullable = false)
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @Basic
    @Column(name = "numOfStock", nullable = false)
    public int getNumOfStock() {
        return numOfStock;
    }

    public void setNumOfStock(int numOfStock) {
        this.numOfStock = numOfStock;
    }

    @Id
    @Column(name = "time", nullable = false, length = 20)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        if (action != trade.action) return false;
        if (numOfStock != trade.numOfStock) return false;
        if (userId != null ? !userId.equals(trade.userId) : trade.userId != null) return false;
        if (stockId != null ? !stockId.equals(trade.stockId) : trade.stockId != null) return false;
        if (time != null ? !time.equals(trade.time) : trade.time != null) return false;
        if (price != null ? !price.equals(trade.price) : trade.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + action;
        result = 31 * result + numOfStock;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
