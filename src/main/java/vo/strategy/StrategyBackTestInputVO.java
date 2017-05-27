package vo.strategy;

/**
 * Created by Mark.W on 2017/5/26.
 * 策略回测输入信息s
 */
public class StrategyBackTestInputVO {
    private String stockCode;
    private String startDate;
    private String endDate;
    private String strategyType;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }
}
