package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/12.
 */
@Entity
public class MarketInfo {

    private String stockCode;
    private String stockName;
    private String stockMarket;
    private String stockId;
    private String srockName;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Basic
    @Column(name = "stockMarket", nullable = true, length = 10)
    public String getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(String stockMarket) {
        this.stockMarket = stockMarket;
    }

    @Id
    @Column(name = "stockID", nullable = false, length = 6)
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "srockName", nullable = false, length = 10)
    public String getSrockName() {
        return srockName;
    }

    public void setSrockName(String srockName) {
        this.srockName = srockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketInfo that = (MarketInfo) o;

        if (stockMarket != null ? !stockMarket.equals(that.stockMarket) : that.stockMarket != null) return false;
        if (stockId != null ? !stockId.equals(that.stockId) : that.stockId != null) return false;
        if (srockName != null ? !srockName.equals(that.srockName) : that.srockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId != null ? stockId.hashCode() : 0;
        result = 31 * result + (srockName != null ? srockName.hashCode() : 0);
        result = 31 * result + (stockMarket != null ? stockMarket.hashCode() : 0);
        return result;
    }
}
