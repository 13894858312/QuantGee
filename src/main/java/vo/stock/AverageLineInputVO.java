package vo.stock;

/**
 * Created by wangxue on 2017/5/7.
 */
public class AverageLineInputVO {
    private String startDate;
    private String endDate;
    private AverageLineType averageLineType;
    private String stockCode;

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

    public AverageLineType getAverageLineType() {
        return averageLineType;
    }

    public void setAverageLineType(AverageLineType averageLineType) {
        this.averageLineType = averageLineType;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
}
