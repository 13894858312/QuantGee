package vo.stock;

/**
 * Created by Mark.W on 2017/5/10.
 * 股票图表数据的vo
 * 包括日k线图 均线图 成交量直方图 对数收益直方图
 */
public class StockHistoricalVO {

    private String stockCode;
    private String stockName;
    private String stockMarket;
    private String date;

    //基础数据
    private double open;
    private double close;
    private double low;
    private double high;
    private double price_change;
    private double p_change;
    private double volume;  //成交量
    private double turnover;

    //日k
    private boolean isPositive;
    private double upperShadow;
    private double lowerShadow;

    //均线图
    private double ma5;
    private double ma10;
    private double ma20;

    //对数收益
    private double logarithmYield = 0;

    //macd
    private double diff;
    private double dea;
    private double macd;

    //kdj
    private double k;
    private double d;
    private double j;

    //rsi
    private double rsi6;
    private double rsi12;
    private double rsi24;

    //boll
    private double mid;
    private double up;
    private double lown;

    public StockHistoricalVO() {}

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
     * @param logarithmYield 对数收益率
     * @param turnover 换手率
     * @param isPositive 是否为阳线
     * @param upperShadow 上影线值
     * @param lowerShadow 下影线值
     * @param ma5 5日均线值
     * @param ma10 10日均线值
     * @param ma20 20日均线值
     */
    public StockHistoricalVO(String stockCode, String stockName, String stockMarket, String date,
                             double open, double close, double low, double high, double price_change,
                             double p_change, double volume, double turnover, boolean isPositive,
                             double upperShadow, double lowerShadow, double ma5, double ma10, double ma20,
                             double logarithmYield, double diff, double dea, double macd, double k,
                             double d, double j, double rsi6, double rsi12, double rsi24, double mid,
                             double up, double lown) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.date = date;
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.price_change = price_change;
        this.p_change = p_change;
        this.volume = volume;
        this.turnover = turnover;
        this.isPositive = isPositive;
        this.upperShadow = upperShadow;
        this.lowerShadow = lowerShadow;
        this.ma5 = ma5;
        this.ma10 = ma10;
        this.ma20 = ma20;
        this.logarithmYield = logarithmYield;
        this.diff = diff;
        this.dea = dea;
        this.macd = macd;
        this.k = k;
        this.d = d;
        this.j = j;
        this.rsi6 = rsi6;
        this.rsi12 = rsi12;
        this.rsi24 = rsi24;
        this.mid = mid;
        this.up = up;
        this.lown = lown;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getDea() {
        return dea;
    }

    public void setDea(double dea) {
        this.dea = dea;
    }

    public double getMacd() {
        return macd;
    }

    public void setMacd(double macd) {
        this.macd = macd;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

    public double getRsi6() {
        return rsi6;
    }

    public void setRsi6(double rsi6) {
        this.rsi6 = rsi6;
    }

    public double getRsi12() {
        return rsi12;
    }

    public void setRsi12(double rsi12) {
        this.rsi12 = rsi12;
    }

    public double getRsi24() {
        return rsi24;
    }

    public void setRsi24(double rsi24) {
        this.rsi24 = rsi24;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public double getLown() {
        return lown;
    }

    public void setLown(double lown) {
        this.lown = lown;
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
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

    public double getLogarithmYield() {
        return logarithmYield;
    }

    public void setLogarithmYield(double logarithmYield) {
        this.logarithmYield = logarithmYield;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public double getUpperShadow() {
        return upperShadow;
    }

    public void setUpperShadow(double upperShadow) {
        this.upperShadow = upperShadow;
    }

    public double getLowerShadow() {
        return lowerShadow;
    }

    public void setLowerShadow(double lowerShadow) {
        this.lowerShadow = lowerShadow;
    }

    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }
}
