package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Created by wangxue on 2017/5/17.
 */
@Entity
public class HistStock {
    private Timestamp date;
    private Double open;
    private Double high;
    private Double close;
    private Double low;
    private Double volume;
    private Double amount;
    private String stockId;

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "open")
    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    @Basic
    @Column(name = "high")
    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    @Basic
    @Column(name = "close")
    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Basic
    @Column(name = "low")
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "volume")
    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "stockID")
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

        HistStock histStock = (HistStock) o;

        if (date != null ? !date.equals(histStock.date) : histStock.date != null) return false;
        if (open != null ? !open.equals(histStock.open) : histStock.open != null) return false;
        if (high != null ? !high.equals(histStock.high) : histStock.high != null) return false;
        if (close != null ? !close.equals(histStock.close) : histStock.close != null) return false;
        if (low != null ? !low.equals(histStock.low) : histStock.low != null) return false;
        if (volume != null ? !volume.equals(histStock.volume) : histStock.volume != null) return false;
        if (amount != null ? !amount.equals(histStock.amount) : histStock.amount != null) return false;
        if (stockId != null ? !stockId.equals(histStock.stockId) : histStock.stockId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        result = 31 * result + (close != null ? close.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        return result;
    }
}
