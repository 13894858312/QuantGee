package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/6/9.
 */
@Entity
@IdClass(StockMonthPK.class)
public class StockMonth {
    private String date;
    private Double open;
    private Double high;
    private Double close;
    private Double low;
    private Double volume;
    private Double priceChange;
    private Double pChange;
    private Double ma5;
    private Double ma10;
    private Double ma20;
    private Double vMa5;
    private Double vMa10;
    private Double vMa20;
    private Double turnover;
    private String stockId;

    @Id
    @Column(name = "date", nullable = false, length = 10)
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
    @Column(name = "price_change", nullable = true, precision = 0)
    public Double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Double priceChange) {
        this.priceChange = priceChange;
    }

    @Basic
    @Column(name = "p_change", nullable = true, precision = 0)
    public Double getpChange() {
        return pChange;
    }

    public void setpChange(Double pChange) {
        this.pChange = pChange;
    }

    @Basic
    @Column(name = "ma5", nullable = true, precision = 0)
    public Double getMa5() {
        return ma5;
    }

    public void setMa5(Double ma5) {
        this.ma5 = ma5;
    }

    @Basic
    @Column(name = "ma10", nullable = true, precision = 0)
    public Double getMa10() {
        return ma10;
    }

    public void setMa10(Double ma10) {
        this.ma10 = ma10;
    }

    @Basic
    @Column(name = "ma20", nullable = true, precision = 0)
    public Double getMa20() {
        return ma20;
    }

    public void setMa20(Double ma20) {
        this.ma20 = ma20;
    }

    @Basic
    @Column(name = "v_ma5", nullable = true, precision = 0)
    public Double getvMa5() {
        return vMa5;
    }

    public void setvMa5(Double vMa5) {
        this.vMa5 = vMa5;
    }

    @Basic
    @Column(name = "v_ma10", nullable = true, precision = 0)
    public Double getvMa10() {
        return vMa10;
    }

    public void setvMa10(Double vMa10) {
        this.vMa10 = vMa10;
    }

    @Basic
    @Column(name = "v_ma20", nullable = true, precision = 0)
    public Double getvMa20() {
        return vMa20;
    }

    public void setvMa20(Double vMa20) {
        this.vMa20 = vMa20;
    }

    @Basic
    @Column(name = "turnover", nullable = true, precision = 0)
    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    @Id
    @Column(name = "stockID", nullable = false, length = 6)
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

        StockMonth that = (StockMonth) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (open != null ? !open.equals(that.open) : that.open != null) return false;
        if (high != null ? !high.equals(that.high) : that.high != null) return false;
        if (close != null ? !close.equals(that.close) : that.close != null) return false;
        if (low != null ? !low.equals(that.low) : that.low != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (priceChange != null ? !priceChange.equals(that.priceChange) : that.priceChange != null) return false;
        if (pChange != null ? !pChange.equals(that.pChange) : that.pChange != null) return false;
        if (ma5 != null ? !ma5.equals(that.ma5) : that.ma5 != null) return false;
        if (ma10 != null ? !ma10.equals(that.ma10) : that.ma10 != null) return false;
        if (ma20 != null ? !ma20.equals(that.ma20) : that.ma20 != null) return false;
        if (vMa5 != null ? !vMa5.equals(that.vMa5) : that.vMa5 != null) return false;
        if (vMa10 != null ? !vMa10.equals(that.vMa10) : that.vMa10 != null) return false;
        if (vMa20 != null ? !vMa20.equals(that.vMa20) : that.vMa20 != null) return false;
        if (turnover != null ? !turnover.equals(that.turnover) : that.turnover != null) return false;
        if (stockId != null ? !stockId.equals(that.stockId) : that.stockId != null) return false;

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
        result = 31 * result + (priceChange != null ? priceChange.hashCode() : 0);
        result = 31 * result + (pChange != null ? pChange.hashCode() : 0);
        result = 31 * result + (ma5 != null ? ma5.hashCode() : 0);
        result = 31 * result + (ma10 != null ? ma10.hashCode() : 0);
        result = 31 * result + (ma20 != null ? ma20.hashCode() : 0);
        result = 31 * result + (vMa5 != null ? vMa5.hashCode() : 0);
        result = 31 * result + (vMa10 != null ? vMa10.hashCode() : 0);
        result = 31 * result + (vMa20 != null ? vMa20.hashCode() : 0);
        result = 31 * result + (turnover != null ? turnover.hashCode() : 0);
        result = 31 * result + (stockId != null ? stockId.hashCode() : 0);
        return result;
    }
}
