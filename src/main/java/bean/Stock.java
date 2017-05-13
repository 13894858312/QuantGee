package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/5/12.
 */
@Entity
@IdClass(StockPK.class)
public class Stock {

//    private String date;
//    private Double openPrice;
//    private Double maxValue;
//    private Double minValue;
//    private Double closePrice;
//    private Integer volume;
//    private Double ADJ;
//    private String stockCode;
//    private String stockName;
//    private String stockMarket;
//    private String blockName;

    private String stockCode;
    private String date;
    private double open;
    private double high;
    private double close;
    private double low;
    private int volume;
    private double price_change;
    private double p_change;
    private double ma5;
    private double ma10;
    private double ma20;
    private double v_ma5;
    private double v_ma10;
    private double v_ma20;
    private double turnover;
    private Double priceChange;
    private Double pChange;
    private Double vMa5;
    private Double vMa10;
    private Double vMa20;

    public void setOpen(Double open) {
        this.open = open;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setMa5(Double ma5) {
        this.ma5 = ma5;
    }

    public void setMa10(Double ma10) {
        this.ma10 = ma10;
    }

    public void setMa20(Double ma20) {
        this.ma20 = ma20;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    @Id
    @Column(name = "stockCode", nullable = false, length = 6)
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

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
    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    @Basic
    @Column(name = "high", nullable = true, precision = 0)
    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Basic
    @Column(name = "close", nullable = true, precision = 0)
    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    @Basic
    @Column(name = "low", nullable = true, precision = 0)
    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "volume", nullable = true)
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice_change() {
        return price_change;
    }

    public void setPrice_change(double price_change) {
        this.price_change = price_change;
    }

    public double getP_change() {
        return p_change;
    }

    public void setP_change(double p_change) {
        this.p_change = p_change;
    }

    @Basic
    @Column(name = "ma5", nullable = true, precision = 0)
    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    @Basic
    @Column(name = "ma10", nullable = true, precision = 0)
    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    @Basic
    @Column(name = "ma20", nullable = true, precision = 0)
    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }

    public double getV_ma5() {
        return v_ma5;
    }

    public void setV_ma5(double v_ma5) {
        this.v_ma5 = v_ma5;
    }

    public double getV_ma10() {
        return v_ma10;
    }

    public void setV_ma10(double v_ma10) {
        this.v_ma10 = v_ma10;
    }

    public double getV_ma20() {
        return v_ma20;
    }

    public void setV_ma20(double v_ma20) {
        this.v_ma20 = v_ma20;
    }

    @Basic
    @Column(name = "turnover", nullable = true, precision = 0)
    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (Double.compare(stock.open, open) != 0) return false;
        if (Double.compare(stock.high, high) != 0) return false;
        if (Double.compare(stock.close, close) != 0) return false;
        if (Double.compare(stock.low, low) != 0) return false;
        if (volume != stock.volume) return false;
        if (Double.compare(stock.ma5, ma5) != 0) return false;
        if (Double.compare(stock.ma10, ma10) != 0) return false;
        if (Double.compare(stock.ma20, ma20) != 0) return false;
        if (Double.compare(stock.turnover, turnover) != 0) return false;
        if (stockCode != null ? !stockCode.equals(stock.stockCode) : stock.stockCode != null) return false;
        if (date != null ? !date.equals(stock.date) : stock.date != null) return false;
        if (priceChange != null ? !priceChange.equals(stock.priceChange) : stock.priceChange != null) return false;
        if (pChange != null ? !pChange.equals(stock.pChange) : stock.pChange != null) return false;
        if (vMa5 != null ? !vMa5.equals(stock.vMa5) : stock.vMa5 != null) return false;
        if (vMa10 != null ? !vMa10.equals(stock.vMa10) : stock.vMa10 != null) return false;
        if (vMa20 != null ? !vMa20.equals(stock.vMa20) : stock.vMa20 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = stockCode != null ? stockCode.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(open);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(close);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(low);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + volume;
        result = 31 * result + (priceChange != null ? priceChange.hashCode() : 0);
        result = 31 * result + (pChange != null ? pChange.hashCode() : 0);
        temp = Double.doubleToLongBits(ma5);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ma10);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ma20);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (vMa5 != null ? vMa5.hashCode() : 0);
        result = 31 * result + (vMa10 != null ? vMa10.hashCode() : 0);
        result = 31 * result + (vMa20 != null ? vMa20.hashCode() : 0);
        temp = Double.doubleToLongBits(turnover);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
