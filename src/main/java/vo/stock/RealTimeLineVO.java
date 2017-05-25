package vo.stock;

/**
 * Created by Mark.W on 2017/5/25.
 */
public class RealTimeLineVO {
    private String code;        //如果是个股就是股票代码 如果是大盘，就是大盘代码
    private String time;
    private double nowPrice;
    private double volumn;

    public RealTimeLineVO(String code, String time, double nowPrice, double volumn) {
        this.code = code;
        this.time = time;
        this.nowPrice = nowPrice;
        this.volumn = volumn;
    }

    public String getCode() {
        return code;
    }

    public String getTime() {
        return time;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public double getVolumn() {
        return volumn;
    }
}
