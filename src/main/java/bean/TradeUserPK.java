package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangxue on 2017/5/18.
 */
public class TradeUserPK implements Serializable {
    private String userId;
    private String stockId;

    @Column(name = "userID", nullable = false, length = 20)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "stockID", nullable = false, length = 10)
    @Id
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

        TradeUserPK that = (TradeUserPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (stockId != null ? !stockId.equals(that.stockId) : that.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        return result;
    }
}
