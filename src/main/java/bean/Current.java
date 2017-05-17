package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/17.
 */
@Entity
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
    private long index;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "changepercent")
    public Double getChangepercent() {
        return changepercent;
    }

    public void setChangepercent(Double changepercent) {
        this.changepercent = changepercent;
    }

    @Basic
    @Column(name = "trade")
    public Double getTrade() {
        return trade;
    }

    public void setTrade(Double trade) {
        this.trade = trade;
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
    @Column(name = "low")
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    @Basic
    @Column(name = "settlement")
    public Double getSettlement() {
        return settlement;
    }

    public void setSettlement(Double settlement) {
        this.settlement = settlement;
    }

    @Basic
    @Column(name = "volume")
    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "turnoverratio")
    public Double getTurnoverratio() {
        return turnoverratio;
    }

    public void setTurnoverratio(Double turnoverratio) {
        this.turnoverratio = turnoverratio;
    }

    @Basic
    @Column(name = "amount")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "per")
    public Double getPer() {
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    @Basic
    @Column(name = "pb")
    public Double getPb() {
        return pb;
    }

    public void setPb(Double pb) {
        this.pb = pb;
    }

    @Basic
    @Column(name = "mktcap")
    public Double getMktcap() {
        return mktcap;
    }

    public void setMktcap(Double mktcap) {
        this.mktcap = mktcap;
    }

    @Basic
    @Column(name = "nmc")
    public Double getNmc() {
        return nmc;
    }

    public void setNmc(Double nmc) {
        this.nmc = nmc;
    }

    @Id
    @Column(name = "index")
    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Current that = (Current) o;

        if (index != that.index) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (changepercent != null ? !changepercent.equals(that.changepercent) : that.changepercent != null)
            return false;
        if (trade != null ? !trade.equals(that.trade) : that.trade != null) return false;
        if (open != null ? !open.equals(that.open) : that.open != null) return false;
        if (high != null ? !high.equals(that.high) : that.high != null) return false;
        if (low != null ? !low.equals(that.low) : that.low != null) return false;
        if (settlement != null ? !settlement.equals(that.settlement) : that.settlement != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (turnoverratio != null ? !turnoverratio.equals(that.turnoverratio) : that.turnoverratio != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (per != null ? !per.equals(that.per) : that.per != null) return false;
        if (pb != null ? !pb.equals(that.pb) : that.pb != null) return false;
        if (mktcap != null ? !mktcap.equals(that.mktcap) : that.mktcap != null) return false;
        if (nmc != null ? !nmc.equals(that.nmc) : that.nmc != null) return false;

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
        result = 31 * result + (int) (index ^ (index >>> 32));
        return result;
    }
}
