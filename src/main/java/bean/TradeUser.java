package bean;

import po.TradePO;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by wangxue on 2017/5/12.
 */
@Entity
@IdClass(TradeUserPK.class)
public class TradeUser {

    private String userID;
    private String stockCode;
    private Integer currentHoldingNum;
    private Double currentYield;
    private String userId;
    private String stockId;

    public void setCurrentHoldingNum(int currentHoldingNum) {
        this.currentHoldingNum = currentHoldingNum;
    }

    public void setCurrentYield(double currentYield) {
        this.currentYield = currentYield;
    }

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

    @Basic
    @Column(name = "currentHoldingNum", nullable = false)
    public Integer getCurrentHoldingNum() {
        return currentHoldingNum;
    }

    public void setCurrentHoldingNum(Integer currentHoldingNum) {
        this.currentHoldingNum = currentHoldingNum;
    }

    @Basic
    @Column(name = "currentYield", nullable = false, precision = 0)
    public Double getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(Double currentYield) {
        this.currentYield = currentYield;
    }

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
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

        TradeUser tradeUser = (TradeUser) o;

        if (currentHoldingNum != null ? !currentHoldingNum.equals(tradeUser.currentHoldingNum) : tradeUser.currentHoldingNum != null)
            return false;
        if (currentYield != null ? !currentYield.equals(tradeUser.currentYield) : tradeUser.currentYield != null)
            return false;
        if (userId != null ? !userId.equals(tradeUser.userId) : tradeUser.userId != null) return false;
        if (stockId != null ? !stockId.equals(tradeUser.stockId) : tradeUser.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        result = 31 * result + (currentHoldingNum != null ? currentHoldingNum.hashCode() : 0);
        result = 31 * result + (currentYield != null ? currentYield.hashCode() : 0);
        return result;
    }
}
