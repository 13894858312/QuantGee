package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/5/31.
 */
@Entity
@IdClass(HistoryPK.class)
public class History {
    private String date;
    private Double open;
    private Double high;
    private Double close;
    private Double low;
    private Double volume;
    private Double amount;
    private String code;

    @Id
    @Column(name = "date", nullable = false, length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    @Id
    @Column(name = "stockID", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (date != null ? !date.equals(history.date) : history.date != null) return false;
        if (open != null ? !open.equals(history.open) : history.open != null) return false;
        if (high != null ? !high.equals(history.high) : history.high != null) return false;
        if (close != null ? !close.equals(history.close) : history.close != null) return false;
        if (low != null ? !low.equals(history.low) : history.low != null) return false;
        if (volume != null ? !volume.equals(history.volume) : history.volume != null) return false;
        if (amount != null ? !amount.equals(history.amount) : history.amount != null) return false;
        if (code != null ? !code.equals(history.code) : history.code != null) return false;

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
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
