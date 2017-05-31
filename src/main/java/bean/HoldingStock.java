package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/5/31.
 */
@Entity
@IdClass(HoldingStockPK.class)
public class HoldingStock {
    private String stockId;
    private String userId;
    private int holdNum;
    private Double sellOutMoney;//持有股票卖出的那部分钱，即在手的钱，用于计算收益率

    private Double initFund; //投入的本金

    @Id
    @Column(name = "stockID", nullable = false, length = 10)
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "holdNum", nullable = false)
    public int getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(int holdNum) {
        this.holdNum = holdNum;
    }

    @Basic
    @Column(name = "sellOutMoney", nullable = true, precision = 0)
    public Double getSellOutMoney() {
        return sellOutMoney;
    }

    public void setSellOutMoney(Double sellOutMoney) {
        this.sellOutMoney = sellOutMoney;
    }

    @Basic
    @Column(name = "initFund", nullable = true, precision = 0)
    public Double getInitFund() {
        return initFund;
    }

    public void setInitFund(Double initFund) {
        this.initFund = initFund;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoldingStock that = (HoldingStock) o;

        if (holdNum != that.holdNum) return false;
        if (stockId != null ? !stockId.equals(that.stockId) : that.stockId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (sellOutMoney != null ? !sellOutMoney.equals(that.sellOutMoney) : that.sellOutMoney != null) return false;
        if (initFund != null ? !initFund.equals(that.initFund) : that.initFund != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId != null ? stockId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + holdNum;
        result = 31 * result + (sellOutMoney != null ? sellOutMoney.hashCode() : 0);
        result = 31 * result + (initFund != null ? initFund.hashCode() : 0);
        return result;
    }
}
