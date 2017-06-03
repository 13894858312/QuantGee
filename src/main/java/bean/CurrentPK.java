package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangxue on 2017/6/3.
 */
public class CurrentPK implements Serializable {
    private String code;
    private String time;

    @Column(name = "code", nullable = false, length = 6)
    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "time", nullable = false, length = 20)
    @Id
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

        CurrentPK currentPK = (CurrentPK) o;

        if (code != null ? !code.equals(currentPK.code) : currentPK.code != null) return false;
        if (time != null ? !time.equals(currentPK.time) : currentPK.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
