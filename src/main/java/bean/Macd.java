package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/23.
 */
@Entity
public class Macd {
    private int index;
    private String code;
    private String date;
    private Double diff;
    private Double dea;
    private Double macd;

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
    @Column(name = "diff", nullable = true, precision = 0)
    public Double getDiff() {
        return diff;
    }

    public void setDiff(Double diff) {
        this.diff = diff;
    }

    @Basic
    @Column(name = "dea", nullable = true, precision = 0)
    public Double getDea() {
        return dea;
    }

    public void setDea(Double dea) {
        this.dea = dea;
    }

    @Basic
    @Column(name = "macd", nullable = true, precision = 0)
    public Double getMacd() {
        return macd;
    }

    public void setMacd(Double macd) {
        this.macd = macd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Macd macd = (Macd) o;

        if (index != macd.index) return false;
        if (code != null ? !code.equals(macd.code) : macd.code != null) return false;
        if (date != null ? !date.equals(macd.date) : macd.date != null) return false;
        if (diff != null ? !diff.equals(macd.diff) : macd.diff != null) return false;
        if (dea != null ? !dea.equals(macd.dea) : macd.dea != null) return false;
        if (this.macd != null ? !this.macd.equals(macd.macd) : macd.macd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (diff != null ? diff.hashCode() : 0);
        result = 31 * result + (dea != null ? dea.hashCode() : 0);
        result = 31 * result + (macd != null ? macd.hashCode() : 0);
        return result;
    }
}
