package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/17.
 */
@Entity
public class Sme {
    private String stockCode;
    private String stockName;

    @Id
    @Column(name = "code")
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Basic
    @Column(name = "name")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sme sme = (Sme) o;

        if (stockCode != null ? !stockCode.equals(sme.stockCode) : sme.stockCode != null) return false;
        if (stockName != null ? !stockName.equals(sme.stockName) : sme.stockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockCode != null ? stockCode.hashCode() : 0;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        return result;
    }
}
