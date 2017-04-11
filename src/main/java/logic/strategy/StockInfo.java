package logic.strategy;

import logic.tools.DateHelper;
import po.StockPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略计算时保存 一种 股票指定区间信息的类
 */
public class StockInfo {
    private String stockCode;

    private StockPO beforeStockPO; //第一次确定股票 时间区间前returnPeriod天的股票信息
    private StockPO startDateStock = null; //开始日期的股票数据 如果为空 抛弃该股票
    private StockPO yesterdayStock = null; //开始日期前一天的股票数据 如果为空 抛弃该股票
    private ArrayList<StockPO> stockPOS;

    public StockInfo(Date startDate, String stockCode, ArrayList<StockPO> stockPOS) {
        this.initStartDateStock(startDate);

        this.beforeStockPO = stockPOS.get(stockPOS.size()-1);
        this.stockCode = stockCode;
        this.stockPOS = stockPOS;
    }

    //初始化index
    private void initStartDateStock(Date startDate) {
        for(int i=stockPOS.size()-1; i>=0; i --) {
            //提高访问效率
            Date stockDate = DateHelper.getInstance().stringTransToDate(this.stockPOS.get(i).getDate());
            int days = DateHelper.getInstance().calculateDaysBetween(stockDate, startDate);

            if(days < 0) {
                break;
            }

            if(days == 0) {
                this.startDateStock = this.stockPOS.get(i);           //初始化开始日期的股票数据

                if(i<stockPOS.size()-1) {
                    this.yesterdayStock = this.stockPOS.get(i+1);
                }
                break;
            }
        }
    }

    /**
     * 根据日期获得股票数据 待优化
     * @param date 日期
     * @return StockPO
     */
    public StockPO getStockByDate(Date date) {

        //股票数据默认按时间倒序排序 用时间比较 提高一下数据
        for(int i=this.stockPOS.size(); i>=0; i --) {
            Date stockDate = DateHelper.getInstance().stringTransToDate(this.stockPOS.get(i).getDate());
            int days = DateHelper.getInstance().calculateDaysBetween(stockDate, date);

            if(days < 0) {
                return null;
            }

            if(days == 0) {
                return stockPOS.get(i);
            }

        }

        return null;
    }

    public String getStockCode() {
        return stockCode;
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
}
