package bean;

import javax.persistence.Entity;

/**
 * Created by wangxue on 2017/5/24.
 */
@Entity
@javax.persistence.IdClass(bean.BollPK.class)
public class Boll {
    private String code;

    @javax.persistence.Id
    @javax.persistence.Column(name = "code", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String date;

    @javax.persistence.Id
    @javax.persistence.Column(name = "date", nullable = false, length = 10)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private Double mid;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "mid", nullable = true, precision = 0)
    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    private Double up;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "up", nullable = true, precision = 0)
    public Double getUp() {
        return up;
    }

    public void setUp(Double up) {
        this.up = up;
    }

    private Double low;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "low", nullable = true, precision = 0)
    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boll boll = (Boll) o;

        if (code != null ? !code.equals(boll.code) : boll.code != null) return false;
        if (date != null ? !date.equals(boll.date) : boll.date != null) return false;
        if (mid != null ? !mid.equals(boll.mid) : boll.mid != null) return false;
        if (up != null ? !up.equals(boll.up) : boll.up != null) return false;
        if (low != null ? !low.equals(boll.low) : boll.low != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (mid != null ? mid.hashCode() : 0);
        result = 31 * result + (up != null ? up.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        return result;
    }
}
