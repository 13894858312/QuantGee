package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangxue on 2017/5/24.
 */
public class KdjPK implements Serializable {
    private String code;
    private String date;

    @Column(name = "code", nullable = false, length = 6)
    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "date", nullable = false, length = 10)
    @Id
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KdjPK kdjPK = (KdjPK) o;

        if (code != null ? !code.equals(kdjPK.code) : kdjPK.code != null) return false;
        if (date != null ? !date.equals(kdjPK.date) : kdjPK.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
