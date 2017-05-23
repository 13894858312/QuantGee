package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by wangxue on 2017/5/23.
 */
@Entity
public class History {
    private Timestamp date;
    private Double open;
    private Double high;
    private Double close;
    private Double low;
    private Double volume;
    private Double amount;
    private String stockId;
    private int index;

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "open", nullable = true, precision = 0)
    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    @Basic
    @Column(name = "high", nullable = true, precision = 0)
    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    @Basic
    @Column(name = "close", nullable = true, precision = 0)
    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Basic
    @Column(name = "low", nullable = true, precision = 0)
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "volume", nullable = true, precision = 0)
    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "stockID", nullable = true, length = -1)
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    @Id
    @Column(name = "index", nullable = false)
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (index != history.index) return false;
        if (date != null ? !date.equals(history.date) : history.date != null) return false;
        if (open != null ? !open.equals(history.open) : history.open != null) return false;
        if (high != null ? !high.equals(history.high) : history.high != null) return false;
        if (close != null ? !close.equals(history.close) : history.close != null) return false;
        if (low != null ? !low.equals(history.low) : history.low != null) return false;
        if (volume != null ? !volume.equals(history.volume) : history.volume != null) return false;
        if (amount != null ? !amount.equals(history.amount) : history.amount != null) return false;
        if (stockId != null ? !stockId.equals(history.stockId) : history.stockId != null) return false;

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
        result = 31 * result + index;
        return result;
    }
}
