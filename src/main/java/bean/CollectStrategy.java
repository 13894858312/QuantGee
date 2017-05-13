package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/13.
 */
@Entity
public class CollectStrategy {
    private String userId;
    private String strategyId;

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "strategyID", nullable = false, length = 20)
    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectStrategy that = (CollectStrategy) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (strategyId != null ? !strategyId.equals(that.strategyId) : that.strategyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (strategyId != null ? strategyId.hashCode() : 0);
        return result;
    }
}
