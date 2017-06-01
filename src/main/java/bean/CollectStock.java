package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by wangxue on 2017/5/24.
 */
@Entity
@IdClass(CollectStockPK.class)
public class CollectStock {
    private String userId;
    private String code;

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "stockID", nullable = false, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String stockId) {
        this.code = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectStock that = (CollectStock) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
