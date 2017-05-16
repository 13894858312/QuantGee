package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/16.
 */
@Entity
public class MarketInfo {
    private String stockID;
    private String stockName;
    private String market;

    @Id
    @Column(name = "code")
    public String getStockID() {
        return stockID;
    }

    public void setStockID(String code) {
        this.stockID = code;
    }

    @Basic
    @Column(name = "name")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String name) {
        this.stockName = name;
    }

    @Basic
    @Column(name = "c_name")
    public String getMarket() {
        return market;
    }

    public void setMarket(String cName) {
        this.market = cName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketInfo that = (MarketInfo) o;

        if (stockID != null ? !stockID.equals(that.stockID) : that.stockID != null) return false;
        if (stockName != null ? !stockName.equals(that.stockName) : that.stockName != null) return false;
        if (market != null ? !market.equals(that.market) : that.market != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockID != null ? stockID.hashCode() : 0;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (market != null ? market.hashCode() : 0);
        return result;
    }
}
