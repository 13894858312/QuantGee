package logic.stock;

import bean.Stock;
import logic.tools.MathHelper;
import org.springframework.stereotype.Service;
import vo.stock.MAVO;
import vo.stock.StockHistoricalVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mark.W on 2017/5/16.
 * 股票数据分析的类
 */
@Service
public class StockDataCalculation {

    /**
     * 首先找到该日的最高和最低价，垂直地连成一条直线;然后再找出当日的开 市和收市价，把这两个价位连接成一条狭长的长方柱体(实体)。
     * 假如当日的收 市价较开市价为高(即低开高收)，我们便以红色来表示，或是在柱体上留白， 这种柱体就称之为“阳线”。
     * 如果当日的收市价较开市价为低(即高开低收)，我 们则以绿色表示，又或是在柱上涂黑色，这柱体就是“阴线”。
     * 在 K 线图中，从实体向上延伸的细线叫上影线。在阳线中，它是当日最高价与 收盘价之差; 在阴线中，它是当日最高价与开盘价之差。
     * 在 K 线图中，从实体向下延伸的细线叫下影线。在阳线中，它是当日开盘价与 最低价之差; 在阴线中，它是当日收盘价与最低价之差。
     */
    public KLineData calculateKLine(StockHistoricalVO historicalVO) {
        if(historicalVO == null) {
            return null;
        }
        boolean positive = false;
        double upper,lower;

        //如果开盘价低于收盘价 阳线
        if(historicalVO.getOpen() < historicalVO.getClose()) {
            positive = true;
        }

        //在阳线中 上影线是当日最高价与收盘价之差 下影线是当日开盘价与最低价之差
        //在阴线中 上影线是当日最高价与开盘价之差 下影线是当日收盘价与最低价之差
        if(positive) {
            upper = historicalVO.getHigh() - historicalVO.getClose();
            lower = historicalVO.getOpen() - historicalVO.getLow();
        } else {
            upper = historicalVO.getHigh() - historicalVO.getOpen();
            lower = historicalVO.getClose() - historicalVO.getLow();
        }

        return new KLineData(positive, upper, lower);
    }

    /**
     * 均线图是将每天的收盘价加权平均,从而得到一条带有趋势性的轨迹。
     * 在日 K 线图中一般白线、黄线、紫线、绿线、蓝线依次分别表示:5、10、20、30、60日移动平均线。
     * 移动平均线常用线有 5 天、10 天、30 天、60 天、120 天和 240 天的指标。
     * 5天 10天的短期移动平均线。是短线操作的参照指标，称做日均线指标;
     * 30天 60天的是中期均线指标，称做季均线指标;
     * 120天 240天的是长期均线指标，称做年均线指标。
     * @param sourceStocks 股票信息
     * @param period 均线周期
     * @return ArrayList<MAVO>
     */
//    public ArrayList<MAVO> getAverageLineInfoByCode(String stockCode, String startDate, String endDate, int period) {
//    if(period <= 0 || period > DateHelper.calculateDaysBetween(startDate, endDate)) {
//        return null;
//    }

    public ArrayList<MAVO> calculateMA(Iterator<Stock> sourceStocks, int period) {

        //如果总天数小于均线图的时间间隔出错
        ArrayList<Stock> stocks = new ArrayList<>();
        while(sourceStocks.hasNext()) {
            stocks.add(sourceStocks.next());
        }

        if(period >= stocks.size()) {
            return null;
        }

        ArrayList<MAVO> result = new ArrayList<>();
        Stock stock;

        for (int i = period-1; i<stocks.size(); ++i){
            stock = stocks.get(i);

            double all = 0;
            for(int j=i-period+1; j<i+1; ++j) {
                all += stocks.get(j).getClose();
            }

            double average = MathHelper.formatData(all/(double)period, 4);

            result.add(new MAVO(stock.getStockId(),period, stock.getDate(), average));
        }

        return result;
    }

}
