package vo.stock;

import logic.tools.MathHelper;

/**
 * Created by Mark.W on 2017/5/10.
 * 股票数据的vo(实时数据）
 * code：代码
 */
public class StockCurrentVO {

    private String code;
    private String stockName;
    private String stockMarket;
    private String time;

    private double trade;

    private double open;
    private double low;
    private double high;
    private double amount;
    private double volume;
    private double changePercent;

    private double turnover;
    private double settlement;         //昨日收盘价
    private double per;
    private double pb;
    private double mktcap;

    /**
     * @param code 股票代码
     * @param stockName 股票名称
     * @param stockMarket 股票所属的市场
     * @param time 时间戳
     * @param open 开盘价
     * @param low 最低值
     * @param high 最高值
     * @param volume 成交量
     * @param changePercent 涨跌幅
     * @param turnover 换手率
     * @param trade 现价
     * @param amount 成交额
     * @param settlement 昨日收盘价
     * @param per 市盈率
     * @param pb 市净率
     * @param mktcap 总市值
     */
    public StockCurrentVO(String code, String stockName, String stockMarket, String time,
                          double trade, double open, double low, double high,
                          double amount, double volume, double changePercent, double turnover,
                          double settlement, double per, double pb, double mktcap) {
        this.code = code;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.time = time;
        this.trade = trade;
        this.open = open;
        this.low = low;
        this.high = high;
        this.amount = MathHelper.formatData(amount/10000,2);
        this.volume = MathHelper.formatData(volume/10000,2);
        this.changePercent = MathHelper.formatData(changePercent,2);
        this.turnover = MathHelper.formatData(turnover,2);
        this.settlement = settlement;
        this.per = MathHelper.formatData(per,2);
        this.pb = MathHelper.formatData(pb,2);
        this.mktcap = MathHelper.formatData(mktcap/10000,2);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTrade() {
        return trade;
    }

    public void setTrade(double trade) {
        this.trade = trade;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getSettlement() {
        return settlement;
    }

    public void setSettlement(double settlement) {
        this.settlement = settlement;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getMktcap() {
        return mktcap;
    }

    public void setMktcap(double mktcap) {
        this.mktcap = mktcap;
    }
}
