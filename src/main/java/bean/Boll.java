package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/6/1.
 */
@Entity
@IdClass(BollPK.class)
public class Boll {
    private String code;
    private String date;
    private Double mid;
    private Double up;
    private Double low;

    @Id
    @Column(name = "code", nullable = false, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "mid", nullable = true, precision = 0)
    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    @Basic
    @Column(name = "up", nullable = true, precision = 0)
    public Double getUp() {
        return up;
    }

    public void setUp(Double up) {
        this.up = up;
    }

    @Basic
    @Column(name = "low", nullable = true, precision = 0)
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
