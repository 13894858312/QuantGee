package vo.stock;


/**
 * Created by Mark.W on 2017/5/10.
 * 大盘、板块和指定行业信息的vo
 */
public class MarketInfoVO {

    private String date;
    //时间  在表示实时数据时有用，如果表示的信息是历史数据则time属性为""
    private String time;
    private String marketType;
    private double price;
    private double volume;
    private int[] rateNums;

    public MarketInfoVO() {
    }

    /**
     * 实时数据的构造方法
     * @param date       日期
     * @param time       时间  在表示实时数据时有用，如果表示的信息是历史数据则time属性为""
     * @param marketType 大盘类型
     * @param price      价格即当前指数值
     * @param volume     当日总成交量
     * @param rateNums   数据依次为 跌停，-10%- -5%，-5%-0，0-5%，5%-10%， 涨停，
     */
    public MarketInfoVO(String date, String time, String marketType, double price,
                        double volume, int[] rateNums) {
        this.date = date;
        this.time = time;
        this.marketType = marketType;
        this.price = price;
        this.volume = volume;
        this.rateNums = rateNums;
    }

    /**
     * 历史数据的构造方法
     * @param date       日期
     * @param marketType 大盘类型
     * @param price      价格即当前指数值
     * @param volume     当日总成交量
     * @param rateNums   数据依次为 跌停，-10%- -5%，-5%-0，0-5%，5%-10%， 涨停，
     */
    public MarketInfoVO(String date, String marketType, double price,
                        double volume, int[] rateNums) {
        this.date = date;
        this.time = "";
        this.marketType = marketType;
        this.price = price;
        this.volume = volume;
        this.rateNums = rateNums;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int[] getRateNums() {
        return rateNums;
    }

    public void setRateNums(int[] rateNums) {
        this.rateNums = rateNums;
    }

}
//    private String code;
//    private String name;
//    private double change;
//    private double open;
//    private double preClose;
//    private double close;
//    private double high;
//    private double low;
//    private int volume;
//    private double amount;
//
//    public MarketInfoVO() {}
//
//    /**
//     * @param code 指数代码
//     * @param name 指数名称
//     * @param change 指数名称
//     * @param open 开盘点位
//     * @param preClose 昨日收盘点位
//     * @param close 收盘点位
//     * @param high 最高点位
//     * @param low 最低点位
//     * @param volume 成交量(手)
//     * @param amount 成交金额（亿元
//     */
//    public MarketInfoVO(String code, String name, double change, double open, double preClose,
//                        double close, double high, double low, int volume, double amount) {
//        this.code = code;
//        this.name = name;
//        this.change = change;
//        this.open = open;
//        this.preClose = preClose;
//        this.close = close;
//        this.high = high;
//        this.low = low;
//        this.volume = volume;
//        this.amount = amount;
//    }

