package vo;


/**
 * Created by Mark.W on 2017/3/5.
 * 均线图的信息
 */
public class AverageLineVO {
    private String stockCode;
    private String stockName;
    private AverageLineType averageLineType;
    private String date;
    private double averageValue;

    public AverageLineVO() {}

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param averageLineType 类型
     * @param date 时间
     * @param averageValue 对应平均值
     */
    public AverageLineVO(String stockCode, String stockName, AverageLineType averageLineType,
                         String date, double averageValue) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.averageLineType = averageLineType;
        this.date = date;
        this.averageValue = averageValue;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public AverageLineType getAverageLineType() {
        return averageLineType;
    }

    public void setAverageLineType(AverageLineType averageLineType) {
        this.averageLineType = averageLineType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }
}
