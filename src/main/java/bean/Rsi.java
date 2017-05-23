package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/23.
 */
@Entity
public class Rsi {
    private int index;
    private String code;
    private String date;
    private Double rsi6;
    private Double rsi12;
    private Double rsi24;

    @Id
    @Column(name = "index", nullable = false)
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "date", nullable = true, length = 10)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "rsi6", nullable = true, precision = 0)
    public Double getRsi6() {
        return rsi6;
    }

    public void setRsi6(Double rsi6) {
        this.rsi6 = rsi6;
    }

    @Basic
    @Column(name = "rsi12", nullable = true, precision = 0)
    public Double getRsi12() {
        return rsi12;
    }

    public void setRsi12(Double rsi12) {
        this.rsi12 = rsi12;
    }

    @Basic
    @Column(name = "rsi24", nullable = true, precision = 0)
    public Double getRsi24() {
        return rsi24;
    }

    public void setRsi24(Double rsi24) {
        this.rsi24 = rsi24;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rsi rsi = (Rsi) o;

        if (index != rsi.index) return false;
        if (code != null ? !code.equals(rsi.code) : rsi.code != null) return false;
        if (date != null ? !date.equals(rsi.date) : rsi.date != null) return false;
        if (rsi6 != null ? !rsi6.equals(rsi.rsi6) : rsi.rsi6 != null) return false;
        if (rsi12 != null ? !rsi12.equals(rsi.rsi12) : rsi.rsi12 != null) return false;
        if (rsi24 != null ? !rsi24.equals(rsi.rsi24) : rsi.rsi24 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (rsi6 != null ? rsi6.hashCode() : 0);
        result = 31 * result + (rsi12 != null ? rsi12.hashCode() : 0);
        result = 31 * result + (rsi24 != null ? rsi24.hashCode() : 0);
        return result;
    }
}
