package bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/7.
 */
public class KLine {
    /**
     * stockName    股票名称
     * startDate    股票开始日期
     * endDate      股票结束日期
     * openPrice    股票当日开盘价
     * closePrice   股票当日收盘价
     * lowPrice     股票当日最低价
     * highPrice    股票当日最高价
     */
    private String stockName;
    private String startDate;
    private String endDate;
    private Double openPrice;
    private Double closePrice;
    private Double lowPrice;
    private Double highPrice;

    public String getStockName(){
        return stockName;
    }

    public void setStockName(String stockName){
        this.stockName = stockName;
    }

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getOpenPrice(){
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosePrice(){
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

}
