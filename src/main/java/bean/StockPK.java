package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangxue on 2017/5/30.
 */
public class StockPK implements Serializable {
    private String date;
    private String stockId;

    @Column(name = "date", nullable = false, length = 10)
    @Id
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "stockID", nullable = false, length = 6)
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

        StockPK stockPK = (StockPK) o;

        if (date != null ? !date.equals(stockPK.date) : stockPK.date != null) return false;
        if (stockId != null ? !stockId.equals(stockPK.stockId) : stockPK.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        return result;
    }
}
