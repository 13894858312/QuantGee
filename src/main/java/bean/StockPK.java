package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangxue on 2017/5/14.
 */
public class StockPK implements Serializable {
    private String stockCode;
    private String date;

    @Column(name = "stockCode")
    @Id
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "date")
    @Id
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPK stockPK = (StockPK) o;

        if (stockCode != null ? !stockCode.equals(stockPK.stockCode) : stockPK.stockCode != null) return false;
        if (date != null ? !date.equals(stockPK.date) : stockPK.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockCode != null ? stockCode.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
