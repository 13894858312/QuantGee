package vo.stock;

/**
 * Created by wangxue on 2017/5/7.
 * 获取k线图的参数的vo
 */
public class KLineInputVO {

    private String code;    //股票代码，即6位数字代码
    private String startDate; //开始日期，格式为"YYYY-MM-DD"
    private String endDate;   //结束日期，格式为"YYYY-MM-DD"
    private String kType = "D"; //数据类型，D=日k线 W=周 M=月 5=5分钟 15=15分钟 30=30分钟 60=60分钟，默认为D

    public KLineInputVO() {}

    /**
     * @param code 股票代码，即6位数字代码
     * @param startDate 开始日期，格式为"YYYY-MM-DD"
     * @param endDate 结束日期，格式为"YYYY-MM-DD"
     */
    public KLineInputVO(String code , String startDate , String endDate){
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kType = "D";
    }

    public KLineInputVO(String code , String startDate , String endDate , String kType){
        this(code,startDate,endDate);
        this.kType = kType;
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

    public String getkType() {
        return kType;
    }

    public void setkType(String kType) {
        this.kType = kType;
    }
}
