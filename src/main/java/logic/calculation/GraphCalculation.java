package logic.calculation;

import dataDao.StockDataDao;
import logic.tools.AverageLineType;
import logic.tools.DateHelper;
import logic.tools.SwitchAverageLineType;
import logicService.GraphCalculationService;
import mock.MockStockData;
import po.StockPO;
import vo.AverageLineVO;
import vo.KLineVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class GraphCalculation implements GraphCalculationService {

    private StockDataDao stockDataDao;
    private DateHelper dateHelper;

    public GraphCalculation(StockDataDao stockDataDao) {
        this.dateHelper = DateHelper.getInstance();
        this.stockDataDao = new MockStockData();
    }

    /**
     * 首先找到该日的最高和最低价，垂直地连成一条直线;然后再找出当日的开 市和收市价，把这两个价位连接成一条狭长的长方柱体(实体)。
     * 假如当日的收 市价较开市价为高(即低开高收)，我们便以红色来表示，或是在柱体上留白， 这种柱体就称之为“阳线”。
     * 如果当日的收市价较开市价为低(即高开低收)，我 们则以绿色表示，又或是在柱上涂黑色，这柱体就是“阴线”。
     * 在 K 线图中，从实体向上延伸的细线叫上影线。在阳线中，它是当日最高价与 收盘价之差;在阴线中，它是当日最高价与开盘价之差。
     * 在 K 线图中，从实体向下延伸的细线叫下影线。在阳线中，它是当日开盘价与 最低价之差;在阴线中，它是当日收盘价与最低价之差。
     */
    public ArrayList<KLineVO> getKLineInfoByCode(Date startDate, Date endDate, String stockCode) {

        ArrayList<StockPO> stockPOS = this.stockDataDao.getStockPOsByTimeInterval(dateHelper.dateTransToString(startDate),
                dateHelper.dateTransToString(endDate), stockCode);


        if(stockPOS == null || stockPOS.size() == 0) {
            return null;
        }

        ArrayList<KLineVO> result = new ArrayList<KLineVO>();

        for(int i=0; i<stockPOS.size(); ++i) {
            StockPO po = stockPOS.get(i);
            Date date = dateHelper.stringTransToDate(po.getDate());
            boolean positive = false;
            double upper = 0;
            double lower = 0;

            if(po.getOpenPrice() < po.getClosePrice()) {
                positive = true;
            }

            //在阳线中 上影线是当日最高价与收盘价之差 下影线是当日开盘价与最低价之差
            //在阴线中 上影线是当日最高价与开盘价之差 下影线是当日收盘价与最低价之差
            if(positive) {
                upper = po.getMaxValue() - po.getClosePrice();
                lower = po.getOpenPrice() - po.getMinValue();
            } else {
                upper = po.getMaxValue() - po.getOpenPrice();
                lower = po.getClosePrice() - po.getMinValue();
            }

            result.add(new KLineVO(positive, date, upper, lower, po.getMaxValue(),
                    po.getMinValue(), po.getOpenPrice(), po.getClosePrice()));

        }

        return result;
    }

    /**
     * 均线图是将每天的收盘价加权平均,从而得到一条带有趋势性的轨迹。
     * 在日 K 线图中一般白线、黄线、紫线、绿线、蓝线依次分别表示:5、10、20、30、60 日移动平均线。
     * 移动平均线常用线有 5 天、10 天、30 天、60 天、120 天和 240 天的指标。
     * 其中，5天和10天的短期移动平均线。是短线操作的参照指标，称做日均线指标;
     * 30 天和 60 天的是中期均线指标，称做季均线指标;
     * 120 天、240 天的是长期均 线指标，称做年均线指标。
     * 举例说明:某股连续十个交易日收盘价分别为:(单位:元)
     * 8.15、 8.07、 8.84、 8.10、 8.40、 9.10、 9.20、 9.10、 8.95、 8.70
     *
     * 以五天短期均线为例:
     * 第五天均值=(8.15+8.07+8.84+8.10+8.40)/5=8.31
     * 第六天均值=(8.07+8.84+8.10+8.40+9.10) /5=8.50
     * 第七天均值=(8.84+8.10+8.40+9.10+9.20)/5=8.73
     * 第八天均值=(8.10+8.40+9.10+9.20+9.10)/5=8.78
     * 第九天均值=(8.40+9.10+9.20+9.10+8.95)/5=8.95
     * 第十天均值=(9.10+9.20+9.10+8.95+8.70)/5=9.01
     */
    public ArrayList<AverageLineVO> getAverageLineInfoByCode(Date startDate, Date endDate, String stockCode, AverageLineType averageLineType) {

        int dayNums = SwitchAverageLineType.getDayInterval(averageLineType);

        if(dayNums > dateHelper.calculateDaysBetween(startDate, endDate)) {
            return null;
        }

        ArrayList<StockPO> stockPOS = this.stockDataDao.getStockPOsByTimeInterval(dateHelper.dateTransToString(startDate),
                dateHelper.dateTransToString(endDate), stockCode);

        if(dayNums > stockPOS.size()) {
            return null;
        }

        ArrayList<AverageLineVO> result = new ArrayList<AverageLineVO>();

        for(int i=dayNums-1; i<stockPOS.size(); ++i) {
            Date date = dateHelper.stringTransToDate(stockPOS.get(i).getDate());

            double all = 0;
            for(int j=i-dayNums+1; j<i+1; ++i) {
                all += stockPOS.get(j).getClosePrice();
            }

            double average = all/dayNums;

            result.add(new AverageLineVO(averageLineType, date, average));
        }

        return result;
    }

    public ArrayList<AverageLineVO> getAverageLineInfoByName(Date startDate, Date endDate, String stockName, AverageLineType averageLineType) {

        String code = this.stockDataDao.getStockCodeByName(stockName);

        if(code == null || code.equals("")) {
            return null;
        }

        return this.getAverageLineInfoByCode(startDate, endDate, code, averageLineType);
    }

    public ArrayList<KLineVO> getKLineInfoByName(Date startDate, Date endDate, String stockName) {

        String code = this.stockDataDao.getStockCodeByName(stockName);

        if(code == null || code.equals("")) {
            return null;
        }

        return this.getKLineInfoByCode(startDate, endDate, code);
    }

}
