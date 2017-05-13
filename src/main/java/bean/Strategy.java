package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangxue on 2017/5/12.
 */
@Entity
public class Strategy {


    private Integer strategyID;
    private String strategyName;
    /**
     * custom 自定义策略
     * momentum 动量策略
     * mean     均值回归策略
     */
    private String strategyType;
    private String strategyContent;
    private int strategyId;

    @Basic
    @Column(name = "strategyName", nullable = false, length = 20)
    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    @Basic
    @Column(name = "strategyContent", nullable = false, length = 10)
    public String getStrategyContent() {
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent) {
        this.strategyContent = strategyContent;
    }

    public Integer getStrategyID() {
        return strategyID;
    }

    public void setStrategyID(Integer strategyID) {
        this.strategyID = strategyID;
    }

    @Basic
    @Column(name = "strategyType", nullable = false, length = 10)
    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    @Id
    @Column(name = "strategyID", nullable = false)
    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = strategyId;
        result = 31 * result + (strategyName != null ? strategyName.hashCode() : 0);
        result = 31 * result + (strategyType != null ? strategyType.hashCode() : 0);
        result = 31 * result + (strategyContent != null ? strategyContent.hashCode() : 0);
        return result;
    }
}
