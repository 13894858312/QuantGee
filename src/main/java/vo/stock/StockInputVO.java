package vo.stock;

/**
 * Created by Mark.W on 2017/5/11.
 * 获取股票k线图 均线图 成交量直方图的输入
 */
public class StockInputVO {
    private String code;
    private String startDate;       //格式yyyy-MM-dd
    private String endDate;         //结束时间 默认为昨天
    private String type = "d";      //日k:d 周k:w 月k:m

    public StockInputVO() {}

    public StockInputVO(String code, String startDate, String endDate, String type) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
