package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangxue on 2017/6/9.
 */
public class CurrentIndexPK implements Serializable {
    private String code;
    private String t;

    @Column(name = "code", nullable = false, length = 6)
    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "t", nullable = false, length = 10)
    @Id
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

        CurrentIndexPK that = (CurrentIndexPK) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (t != null ? !t.equals(that.t) : that.t != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (t != null ? t.hashCode() : 0);
        return result;
    }
}
