package vo.stock;

/**
 * Created by Mark.W on 2017/5/11.
 * 获取股票k线图 均线图 成交量直方图的输入
 */
public class StockInputVO {
    private String stockCode;
    private String startDate;       //格式YYYY-MM-DD
    private String endDate;         //结束时间 默认为昨天

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
}
