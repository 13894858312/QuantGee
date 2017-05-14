package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/5/14.
 */
@Entity
@IdClass(HoldingStocksPK.class)
public class HoldingStocks {
    private String stockCode;
    private String userId;
    private int holdNum;

    @Id
    @Column(name = "stockCode")
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Id
    @Column(name = "userID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "holdNum")
    public int getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(int holdNum) {
        this.holdNum = holdNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoldingStocks that = (HoldingStocks) o;

        if (holdNum != that.holdNum) return false;
        if (stockCode != null ? !stockCode.equals(that.stockCode) : that.stockCode != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockCode != null ? stockCode.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + holdNum;
        return result;
    }
}
