package logic.strategy;

import logic.tools.DateHelper;
import po.StockPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略计算时保存 一种 股票指定区间信息的类
 */
public class Stock {

    private int startIndex;
    private StockPO beforeStockPO; //第一次确定股票 时间区间前returnPeriod天的股票信息
    private StockPO startDateStock; //开始日期的股票数据 如果为空 抛弃该股票
    private StockPO yesterdayStock; //开始日期前一天的股票数据 如果为空 抛弃该股票
    private ArrayList<StockPO> stockPOS;
    private HashMap<String, StockPO> stocksMap = new HashMap<>();   //key是date

    public Stock(Date startDate,  ArrayList<StockPO> stockPOS) {
        this.stockPOS = stockPOS;
        this.init(startDate);
    }

    /**
     * 初始化index和StartDateStock
     * 初始化stocksMap
     */
    private void init(Date startDate) {

        int days= 0, tempDays = days;
        for(int i=stockPOS.size()-1; i>=0; i --) {

            stocksMap.put(stockPOS.get(i).getDate(), stocksMap.get(i));

            //提高访问效率
            Date d = DateHelper.getInstance().stringTransToDate(this.stockPOS.get(i).getDate());
            tempDays = days;
            days = DateHelper.getInstance().calculateDaysBetween(d, startDate);

            if((days == 0) || (days < 0 && tempDays > 0)) {
                startIndex = i;
                this.startDateStock = this.stockPOS.get(i);           //初始化开始日期的股票数据

                if(i< stockPOS.size()-1) {
                    this.yesterdayStock = this.stockPOS.get(i+1);
                }
                break;
            }
        }

        this.beforeStockPO = stockPOS.get(stockPOS.size()-1);
    }

    /**
     * 根据日期获得股票数据 待优化
     * @param date 日期
     * @return StockPO
     */
    public StockPO getStockByDate(String date) {
        return  this.stocksMap.get(date);
    }

    public StockPO getStartDateStockPO() {
        return startDateStock;
    }

    public StockPO getBeforeStockPO() {
        return beforeStockPO;
    }

    public StockPO getYesterdayStock() {
        return yesterdayStock;
    }

    public int getStockSize() {
        return this.stockPOS.size();
    }

    public ArrayList<StockPO> getStockPOS() {
        return stockPOS;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
