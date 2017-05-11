package vo.stock;

/**
 * Created by Mark.W on 2017/5/10.
 * 股票数据的vo(实时数据）
 */
public class StockCurrentVO {

    private String stockCode;
    private String stockName;
    private String stockMarket;
    private String date;

    private double open;
    private double close;
    private double low;
    private double high;
    private int volume;
    private double price_change;
    private double p_change;

    private double turnover;

    public StockCurrentVO() {}

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param stockMarket 股票所属的市场
     * @param date 日期
     * @param open 开盘价
     * @param close 收盘价
     * @param low 最低值
     * @param high 最高值
     * @param volume 成交量
     * @param price_change 价格变动
     * @param p_change 涨跌幅
     * @param turnover 换手率
     */
    public StockCurrentVO(String stockCode, String stockName, String stockMarket, String date,
                          double open, double close, double low, double high, int volume,
                          double price_change, double p_change, double turnover) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.date = date;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.volume = volume;
        this.price_change = price_change;
        this.p_change = p_change;
        this.turnover = turnover;
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

    public String getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(String stockMarket) {
        this.stockMarket = stockMarket;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice_change() {
        return price_change;
    }

    public void setPrice_change(double price_change) {
        this.price_change = price_change;
    }

    public double getP_change() {
        return p_change;
    }

    public void setP_change(double p_change) {
        this.p_change = p_change;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }
}
