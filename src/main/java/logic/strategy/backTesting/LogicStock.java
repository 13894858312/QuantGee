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
    private Stock beforeStock; //第一次确定股票 时间区间前returnPeriod天的股票信息
    private Stock startDateStock; //开始日期的股票数据 如果为空 抛弃该股票
    private Stock yesterdayStock; //开始日期前一天的股票数据 如果为空 抛弃该股票
    private ArrayList<Stock> stocks;
    private HashMap<String, Stock> stocksMap = new HashMap<>();   //key是date

    public LogicStock(String startDate, ArrayList<Stock> stocks) {
        this.stocks = stocks;
        this.init(startDate);
    }

    /**
     * 初始化index和StartDateStock
     * 初始化stocksMap
     */
    private void init(String startDate) {

        int days= 0, tempDays = 0;
        for(int i = stocks.size()-1; i>=0; i --) {
            stocksMap.put(stocks.get(i).getDate(), stocks.get(i));

            tempDays = days;
            days = DateHelper.calculateDaysBetween(this.stocks.get(i).getDate(), startDate);

            if((days == 0) || (days < 0 && tempDays > 0)) {
                startIndex = i;
                this.startDateStock = this.stocks.get(i);           //初始化开始日期的股票数据

                if(i< stocks.size()-1) {
                    this.yesterdayStock = this.stocks.get(i+1);
                }
            }
        }

        this.beforeStock = stocks.get(stocks.size()-1);
    }

    /**
     * 根据日期获得股票数据 待优化
     * @param date 日期
     * @return Stock
     */
    public Stock getStockByDate(String date) {

        return this.stocksMap.get(date);
    }

    public Stock getStartDateStockPO() {
        return startDateStock;
    }

    public Stock getBeforeStock() {
        return beforeStock;
    }

    public Stock getYesterdayStock() {
        return yesterdayStock;
    }

    public int getStockSize() {
        return this.stocks.size();
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
