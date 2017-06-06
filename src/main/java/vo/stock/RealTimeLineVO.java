package vo.stock;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/25.
 */
public class RealTimeLineVO {
    private String code;        //如果是个股就是股票代码 如果是大盘，就是大盘代码

    private ArrayList<String> times;
    private ArrayList<Double> nowPrice;
    private ArrayList<Double> volumn;

    public RealTimeLineVO(String code, ArrayList<String> times,
                          ArrayList<Double> nowPrice, ArrayList<Double> volumn) {
        this.code = code;
        this.times = times;
        this.nowPrice = nowPrice;
        this.volumn = volumn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    public ArrayList<Double> getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(ArrayList<Double> nowPrice) {
        this.nowPrice = nowPrice;
    }

    public ArrayList<Double> getVolumn() {
        return volumn;
    }

    public void setVolumn(ArrayList<Double> volumn) {
        this.volumn = volumn;
    }
}
