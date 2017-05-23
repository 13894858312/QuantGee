package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/23.
 */
@Entity
public class Strategy {
    private int strategyId;
    private String strategyName;
    private String strategyType;
    private String strategyContent;
    private String userId;
    private Integer posted;

    @Id
    @Column(name = "strategyID", nullable = false)
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    @Basic
    @Column(name = "strategyName", nullable = false, length = -1)
    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Basic
    @Column(name = "strategyType", nullable = false, length = 20)
    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    @Basic
    @Column(name = "strategyContent", nullable = true, length = -1)
    public String getStrategyContent() {
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent) {
        this.strategyContent = strategyContent;
    }

    @Basic
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "posted", nullable = true)
    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strategy strategy = (Strategy) o;

        if (strategyId != strategy.strategyId) return false;
        if (strategyName != null ? !strategyName.equals(strategy.strategyName) : strategy.strategyName != null)
            return false;
        if (strategyType != null ? !strategyType.equals(strategy.strategyType) : strategy.strategyType != null)
            return false;
        if (strategyContent != null ? !strategyContent.equals(strategy.strategyContent) : strategy.strategyContent != null)
            return false;
        if (userId != null ? !userId.equals(strategy.userId) : strategy.userId != null) return false;
        if (posted != null ? !posted.equals(strategy.posted) : strategy.posted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = strategyId;
        result = 31 * result + (strategyName != null ? strategyName.hashCode() : 0);
        result = 31 * result + (strategyType != null ? strategyType.hashCode() : 0);
        result = 31 * result + (strategyContent != null ? strategyContent.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (posted != null ? posted.hashCode() : 0);
        return result;
    }
}
