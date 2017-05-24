package bean;

import javax.persistence.*;

/**
 * Created by wangxue on 2017/5/24.
 */
@Entity
@IdClass(KdjPK.class)
public class Kdj {
    private String code;
    private String date;
    private Double k;
    private Double d;
    private Double j;

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
    @Column(name = "k", nullable = true, precision = 0)
    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
    }

    @Basic
    @Column(name = "d", nullable = true, precision = 0)
    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    @Basic
    @Column(name = "j", nullable = true, precision = 0)
    public Double getJ() {
        return j;
    }

    public void setJ(Double j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kdj kdj = (Kdj) o;

        if (code != null ? !code.equals(kdj.code) : kdj.code != null) return false;
        if (date != null ? !date.equals(kdj.date) : kdj.date != null) return false;
        if (k != null ? !k.equals(kdj.k) : kdj.k != null) return false;
        if (d != null ? !d.equals(kdj.d) : kdj.d != null) return false;
        if (j != null ? !j.equals(kdj.j) : kdj.j != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (k != null ? k.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (j != null ? j.hashCode() : 0);
        return result;
    }
}
