package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/5/18.
 */
@Entity
@IdClass(TradeUserPK.class)
public class TradeUser {
    private String userId;
    private String stockId;
    private int currentHoldingNum;
    private double currentYield;

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "stockID", nullable = false, length = 10)
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "currentHoldingNum", nullable = false)
    public int getCurrentHoldingNum() {
        return currentHoldingNum;
    }

    public void setCurrentHoldingNum(int currentHoldingNum) {
        this.currentHoldingNum = currentHoldingNum;
    }

    @Basic
    @Column(name = "currentYield", nullable = false, precision = 0)
    public double getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(double currentYield) {
        this.currentYield = currentYield;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeUser tradeUser = (TradeUser) o;

        if (currentHoldingNum != tradeUser.currentHoldingNum) return false;
        if (Double.compare(tradeUser.currentYield, currentYield) != 0) return false;
        if (userId != null ? !userId.equals(tradeUser.userId) : tradeUser.userId != null) return false;
        if (stockId != null ? !stockId.equals(tradeUser.stockId) : tradeUser.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + currentHoldingNum;
        temp = Double.doubleToLongBits(currentYield);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
