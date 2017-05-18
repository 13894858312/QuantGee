package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/18.
 */
@Entity
public class Trade {
    private int trageId;
    private String userId;
    private String ime;
    private String stockId;
    private int action;
    private int numOfStock;

    @Id
    @Column(name = "trageID", nullable = false)
    public int getTrageId() {
        return trageId;
    }

    public void setTrageId(int trageId) {
        this.trageId = trageId;
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
    @Column(name = "ime", nullable = false, length = 20)
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trade trade = (Trade) o;

        if (trageId != trade.trageId) return false;
        if (action != trade.action) return false;
        if (numOfStock != trade.numOfStock) return false;
        if (userId != null ? !userId.equals(trade.userId) : trade.userId != null) return false;
        if (ime != null ? !ime.equals(trade.ime) : trade.ime != null) return false;
        if (stockId != null ? !stockId.equals(trade.stockId) : trade.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trageId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + action;
        result = 31 * result + numOfStock;
        return result;
    }
}
