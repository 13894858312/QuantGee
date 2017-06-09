package logic.strategy.backTesting;

import bean.Stock;
import logic.tools.DateHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略计算时保存 一种 股票指定区间信息的类
 */
public class LogicStock {

    private int startIndex;
    private String code;
    private Stock beforeStock; //第一次确定股票 时间区间前returnPeriod天的股票信息
    private Stock startDateStock; //开始日期的股票数据 如果为空 抛弃该股票
    private ArrayList<Stock> stocks;
    private HashMap<String, Stock> stocksMap = new HashMap<>();   //key是date

    public LogicStock(String startDate, ArrayList<Stock> stocks) {
        this.stocks = stocks;
        this.code = stocks.get(0).getCode();
        this.init(startDate);
    }

    /**
     * 初始化index和StartDateStock
     * 初始化stocksMap
     */
    private void init(String startDate) {
        int days= 0, tempDays;
        for(int i = 0; i<stocks.size(); ++ i) {
            stocksMap.put(stocks.get(i).getDate(), stocks.get(i));

            tempDays = days;
            days = DateHelper.calculateDaysBetween(this.stocks.get(i).getDate(), startDate);

            if((days == 0) || (days > 0 && tempDays < 0)) {
                startIndex = i;
                this.startDateStock = this.stocks.get(i);           //初始化开始日期的股票数据
            }
        }

        this.beforeStock = stocks.get(0);
    }

    /**
     * 根据日期获得股票数据 待优化
     * @param date 日期
     * @return 如果获取开始日期之前的股票，返回前returnperiod的stock
     */
    public Stock getStockByDate(String date) {
        if(DateHelper.calculateDaysBetween(date, startDateStock.getDate()) > 0) {
            return beforeStock;
        }
        return this.stocksMap.get(date);
    }

    public Stock getStartDateStock() {
        return startDateStock;
    }

    public Stock getBeforeStock() {
        return beforeStock;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public String getCode() {
        return code;
    }
}
