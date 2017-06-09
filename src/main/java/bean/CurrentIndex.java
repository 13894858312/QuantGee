package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/6/9.
 */
@Entity
@IdClass(CurrentIndexPK.class)
public class CurrentIndex {

    private String code;//    code:指数代码
    private Double preclose;//    preclose:昨日收盘点位
    private Double high;//    high:最高点位
    private Double low;//    low:最低点位
    private Long volume;//    volume:成交量(手)
    private Double amount;//    amount:成交金额（亿元）
    private Double openNum;//    openNum:开盘点位
    private Double closeNum;//    closeNum:收盘点位
    private Double changes;//    changes:涨跌幅
    private String t;

    @Id
    @Column(name = "code", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "preclose", nullable = true, precision = 0)
    public Double getPreclose() {
        return preclose;
    }

    public void setPreclose(Double preclose) {
        this.preclose = preclose;
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
    @Column(name = "volume", nullable = true)
    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
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
    @Column(name = "openNum", nullable = true, precision = 0)
    public Double getOpenNum() {
        return openNum;
    }

    public void setOpenNum(Double openNum) {
        this.openNum = openNum;
    }

    @Basic
    @Column(name = "closeNum", nullable = true, precision = 0)
    public Double getCloseNum() {
        return closeNum;
    }

    public void setCloseNum(Double closeNum) {
        this.closeNum = closeNum;
    }

    @Basic
    @Column(name = "changes", nullable = true, precision = 0)
    public Double getChanges() {
        return changes;
    }

    public void setChanges(Double changes) {
        this.changes = changes;
    }

    @Id
    @Column(name = "t", nullable = false, length = 10)
    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentIndex that = (CurrentIndex) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (preclose != null ? !preclose.equals(that.preclose) : that.preclose != null) return false;
        if (high != null ? !high.equals(that.high) : that.high != null) return false;
        if (low != null ? !low.equals(that.low) : that.low != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (openNum != null ? !openNum.equals(that.openNum) : that.openNum != null) return false;
        if (closeNum != null ? !closeNum.equals(that.closeNum) : that.closeNum != null) return false;
        if (changes != null ? !changes.equals(that.changes) : that.changes != null) return false;
        if (t != null ? !t.equals(that.t) : that.t != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (preclose != null ? preclose.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (openNum != null ? openNum.hashCode() : 0);
        result = 31 * result + (closeNum != null ? closeNum.hashCode() : 0);
        result = 31 * result + (changes != null ? changes.hashCode() : 0);
        result = 31 * result + (t != null ? t.hashCode() : 0);
        return result;
    }
}
