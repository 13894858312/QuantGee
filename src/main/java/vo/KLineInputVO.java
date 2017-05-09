package vo;

/**
 * Created by wangxue on 2017/5/7.
 */
public class KLineInputVO {

    String code;    //股票代码，即6位数字代码
    String startDate; //开始日期，格式为"YYYY-MM-DD"
    String endDate;   //结束日期，格式为"YYYY-MM-DD"
    String kType = "D"; //数据类型，D=日k线 W=周 M=月 5=5分钟 15=15分钟 30=30分钟 60=60分钟，默认为D

    public KLineInputVO(String code , String startDate , String endDate){
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public KLineInputVO(String code , String startDate , String endDate , String kType){
        this(code,startDate,endDate);
        this.kType = kType;
    }

}
