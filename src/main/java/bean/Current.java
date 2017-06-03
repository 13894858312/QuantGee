package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/6/3.
 */
@Entity
@IdClass(CurrentPK.class)
public class Current {
    private String code;
    private String name;
    private Double changepercent;
    private Double trade;
    private Double open;
    private Double high;
    private Double low;
    private Double settlement;
    private Long volume;
    private Double turnoverratio;
    private Long amount;
    private Double per;
    private Double pb;
    private Double mktcap;
    private Double nmc;
    private String time;

    @Id
    @Column(name = "code", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "changepercent", nullable = true, precision = 0)
    public Double getChangepercent() {
        return changepercent;
    }

    public void setChangepercent(Double changepercent) {
        this.changepercent = changepercent;
    }

    @Basic
    @Column(name = "trade", nullable = true, precision = 0)
    public Double getTrade() {
        return trade;
    }

    public void setTrade(Double trade) {
        this.trade = trade;
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
    @Column(name = "low", nullable = true, precision = 0)
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "settlement", nullable = true, precision = 0)
    public Double getSettlement() {
        return settlement;
    }

    public void setSettlement(Double settlement) {
        this.settlement = settlement;
    }

    @Basic
    @Column(name = "volume", nullable = true)
    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "turnoverratio", nullable = true, precision = 0)
    public Double getTurnoverratio() {
        return turnoverratio;
    }

    public void setTurnoverratio(Double turnoverratio) {
        this.turnoverratio = turnoverratio;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "per", nullable = true, precision = 0)
    public Double getPer() {
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    @Basic
    @Column(name = "pb", nullable = true, precision = 0)
    public Double getPb() {
        return pb;
    }

    public void setPb(Double pb) {
        this.pb = pb;
    }

    @Basic
    @Column(name = "mktcap", nullable = true, precision = 0)
    public Double getMktcap() {
        return mktcap;
    }

    public void setMktcap(Double mktcap) {
        this.mktcap = mktcap;
    }

    @Basic
    @Column(name = "nmc", nullable = true, precision = 0)
    public Double getNmc() {
        return nmc;
    }

    public void setNmc(Double nmc) {
        this.nmc = nmc;
    }

    @Id
    @Column(name = "time", nullable = false, length = 20)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Current current = (Current) o;

        if (code != null ? !code.equals(current.code) : current.code != null) return false;
        if (name != null ? !name.equals(current.name) : current.name != null) return false;
        if (changepercent != null ? !changepercent.equals(current.changepercent) : current.changepercent != null)
            return false;
        if (trade != null ? !trade.equals(current.trade) : current.trade != null) return false;
        if (open != null ? !open.equals(current.open) : current.open != null) return false;
        if (high != null ? !high.equals(current.high) : current.high != null) return false;
        if (low != null ? !low.equals(current.low) : current.low != null) return false;
        if (settlement != null ? !settlement.equals(current.settlement) : current.settlement != null) return false;
        if (volume != null ? !volume.equals(current.volume) : current.volume != null) return false;
        if (turnoverratio != null ? !turnoverratio.equals(current.turnoverratio) : current.turnoverratio != null)
            return false;
        if (amount != null ? !amount.equals(current.amount) : current.amount != null) return false;
        if (per != null ? !per.equals(current.per) : current.per != null) return false;
        if (pb != null ? !pb.equals(current.pb) : current.pb != null) return false;
        if (mktcap != null ? !mktcap.equals(current.mktcap) : current.mktcap != null) return false;
        if (nmc != null ? !nmc.equals(current.nmc) : current.nmc != null) return false;
        if (time != null ? !time.equals(current.time) : current.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (changepercent != null ? changepercent.hashCode() : 0);
        result = 31 * result + (trade != null ? trade.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (settlement != null ? settlement.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (turnoverratio != null ? turnoverratio.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (per != null ? per.hashCode() : 0);
        result = 31 * result + (pb != null ? pb.hashCode() : 0);
        result = 31 * result + (mktcap != null ? mktcap.hashCode() : 0);
        result = 31 * result + (nmc != null ? nmc.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
