package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/15.
 */
@Entity
public class Strategy {
    private String strategyId;
    private String strategyName;
    private String strategyType;
    private String strategyContent;

    @Id
    @Column(name = "strategyID")
    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    @Basic
    @Column(name = "strategyName")
    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Basic
    @Column(name = "strategyType")
    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    @Basic
    @Column(name = "strategyContent")
    public String getStrategyContent() {
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent) {
        this.strategyContent = strategyContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strategy strategy = (Strategy) o;

        if (strategyId != null ? !strategyId.equals(strategy.strategyId) : strategy.strategyId != null) return false;
        if (strategyName != null ? !strategyName.equals(strategy.strategyName) : strategy.strategyName != null)
            return false;
        if (strategyType != null ? !strategyType.equals(strategy.strategyType) : strategy.strategyType != null)
            return false;
        if (strategyContent != null ? !strategyContent.equals(strategy.strategyContent) : strategy.strategyContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = strategyId != null ? strategyId.hashCode() : 0;
        result = 31 * result + (strategyName != null ? strategyName.hashCode() : 0);
        result = 31 * result + (strategyType != null ? strategyType.hashCode() : 0);
        result = 31 * result + (strategyContent != null ? strategyContent.hashCode() : 0);
        return result;
    }
}
