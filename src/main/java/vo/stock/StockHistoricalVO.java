package vo.stock;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/10.
 * 股票图表数据的vo
 * 包括日k线图 均线图 成交量直方图 对数收益直方图
 */
public class StockHistoricalVO {

    private String stockCode;
    private String stockName;
    private String stockMarket;
    private String startDate;
    private String endDate;

    //日k
    private ArrayList<KLineVO> kLine;

    //成交量
    private ArrayList<LineVO> volume;

    //均线图
    private ArrayList<LineVO> ma5;
    private ArrayList<LineVO> ma10;
    private ArrayList<LineVO> ma20;

    //对数收益
    private ArrayList<LineVO> logarithmYield;

    //macd
    private ArrayList<LineVO> diff;
    private ArrayList<LineVO> dea;
    private ArrayList<LineVO> macd;

    //kdj
    private ArrayList<LineVO> k;
    private ArrayList<LineVO> d;
    private ArrayList<LineVO> j;

    //rsi
    private ArrayList<LineVO> rsi6;
    private ArrayList<LineVO> rsi12;
    private ArrayList<LineVO> rsi24;

    //boll
    private ArrayList<LineVO> mid;
    private ArrayList<LineVO> up;
    private ArrayList<LineVO> low;

    public StockHistoricalVO(String stockCode, String stockName, String stockMarket, String startDate,
                             String endDate, ArrayList<KLineVO> kLine, ArrayList<LineVO> volume,
                             ArrayList<LineVO> ma5, ArrayList<LineVO> ma10, ArrayList<LineVO> ma20,
                             ArrayList<LineVO> logarithmYield, ArrayList<LineVO> diff, ArrayList<LineVO> dea,
                             ArrayList<LineVO> macd, ArrayList<LineVO> k, ArrayList<LineVO> d, ArrayList<LineVO> j,
                             ArrayList<LineVO> rsi6, ArrayList<LineVO> rsi12, ArrayList<LineVO> rsi24,
                             ArrayList<LineVO> mid, ArrayList<LineVO> up, ArrayList<LineVO> low) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kLine = kLine;
        this.volume = volume;
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
        this.low = low;
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

    public ArrayList<KLineVO> getkLine() {
        return kLine;
    }

    public void setkLine(ArrayList<KLineVO> kLine) {
        this.kLine = kLine;
    }

    public ArrayList<LineVO> getVolume() {
        return volume;
    }

    public void setVolume(ArrayList<LineVO> volume) {
        this.volume = volume;
    }

    public ArrayList<LineVO> getMa5() {
        return ma5;
    }

    public void setMa5(ArrayList<LineVO> ma5) {
        this.ma5 = ma5;
    }

    public ArrayList<LineVO> getMa10() {
        return ma10;
    }

    public void setMa10(ArrayList<LineVO> ma10) {
        this.ma10 = ma10;
    }

    public ArrayList<LineVO> getMa20() {
        return ma20;
    }

    public void setMa20(ArrayList<LineVO> ma20) {
        this.ma20 = ma20;
    }

    public ArrayList<LineVO> getLogarithmYield() {
        return logarithmYield;
    }

    public void setLogarithmYield(ArrayList<LineVO> logarithmYield) {
        this.logarithmYield = logarithmYield;
    }

    public ArrayList<LineVO> getDiff() {
        return diff;
    }

    public void setDiff(ArrayList<LineVO> diff) {
        this.diff = diff;
    }

    public ArrayList<LineVO> getDea() {
        return dea;
    }

    public void setDea(ArrayList<LineVO> dea) {
        this.dea = dea;
    }

    public ArrayList<LineVO> getMacd() {
        return macd;
    }

    public void setMacd(ArrayList<LineVO> macd) {
        this.macd = macd;
    }

    public ArrayList<LineVO> getK() {
        return k;
    }

    public void setK(ArrayList<LineVO> k) {
        this.k = k;
    }

    public ArrayList<LineVO> getD() {
        return d;
    }

    public void setD(ArrayList<LineVO> d) {
        this.d = d;
    }

    public ArrayList<LineVO> getJ() {
        return j;
    }

    public void setJ(ArrayList<LineVO> j) {
        this.j = j;
    }

    public ArrayList<LineVO> getRsi6() {
        return rsi6;
    }

    public void setRsi6(ArrayList<LineVO> rsi6) {
        this.rsi6 = rsi6;
    }

    public ArrayList<LineVO> getRsi12() {
        return rsi12;
    }

    public void setRsi12(ArrayList<LineVO> rsi12) {
        this.rsi12 = rsi12;
    }

    public ArrayList<LineVO> getRsi24() {
        return rsi24;
    }

    public void setRsi24(ArrayList<LineVO> rsi24) {
        this.rsi24 = rsi24;
    }

    public ArrayList<LineVO> getMid() {
        return mid;
    }

    public void setMid(ArrayList<LineVO> mid) {
        this.mid = mid;
    }

    public ArrayList<LineVO> getUp() {
        return up;
    }

    public void setUp(ArrayList<LineVO> up) {
        this.up = up;
    }

    public ArrayList<LineVO> getLow() {
        return low;
    }

    public void setLow(ArrayList<LineVO> low) {
        this.low = low;
    }
}
