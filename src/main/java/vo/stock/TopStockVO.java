package vo.stock;

/**
 * Created by Mark.W on 2017/6/3.
 * 涨跌幅前十的
 */
public class TopStockVO {
    private int upOrDown;

    private String name;            //行业名
    private String code;            //股票代码或者股票名字
    private double increaseRate;
    private double nowPrice;
    private String topName;         // 行业涨跌榜用
    private String topCode;         // 行业涨跌榜用

    /**
     * 个股涨跌榜的构造方法
     * @param upOrDown  0 涨幅前十 1 跌幅前十
     * @param code 个股代码
     * @param name 个股名字
     * @param increaseRate 涨幅／跌幅
     * @param nowPrice 现价
     */
    public TopStockVO(int upOrDown,String code, String name, double increaseRate, double nowPrice) {
        this.upOrDown = upOrDown;
        this.code = code;
        this.name = name;
        this.increaseRate = increaseRate;
        this.nowPrice = nowPrice;
    }

    /**
     * 行业涨跌榜的构造方法
     * @param upOrDown 0 涨幅前十 1 跌幅前十
     * @param name 行业名字
     * @param increaseRate 涨幅／跌幅
     * @param topName  领涨股或者领跌股名字
     * @param topCode  领涨股或者领跌股代码
     */
    public TopStockVO(int upOrDown, String name, double increaseRate, String topName, String topCode) {
        this.upOrDown = upOrDown;
        this.name = name;
        this.increaseRate = increaseRate;
        this.topName = topName;
        this.topCode = topCode;
    }

    public int getUpOrDown() {
        return upOrDown;
    }

    public String getName() {
        return name;
    }

    public double getIncreaseRate() {
        return increaseRate;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public String getTopName() {
        return topName;
    }

    public String getCode() {
        return code;
    }

    public String getTopCode() {
        return topCode;
    }
}
