package vo.stock;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/10.
 * 股票图表数据的vo
 * 包括日k线图 均线图 成交量直方图 对数收益直方图
 */
public class StockHistoricalVO {

    private String code;
    private String name;
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

    public StockHistoricalVO(String code, String name, String stockMarket, String startDate, String endDate,
                             ArrayList<KLineVO> kLine, ArrayList<LineVO> volume, ArrayList<LineVO> ma5,
                             ArrayList<LineVO> ma10, ArrayList<LineVO> ma20, ArrayList<LineVO> logarithmYield) {
        this.code = code;
        this.name = name;
        this.stockMarket = stockMarket;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kLine = kLine;
        this.volume = volume;
        this.ma5 = ma5;
        this.ma10 = ma10;
        this.ma20 = ma20;
        this.logarithmYield = logarithmYield;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
