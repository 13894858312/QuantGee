package logic.calculation;

import data.StockData;
import dataDao.StockDataDao;
import logic.tools.DateHelper;
import logic.tools.MathHelper;
import logicService.DataCalculationService;
import mock.MockStockData;
import po.StockPO;
import vo.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/4.
 */
public class DataCalculation implements DataCalculationService {

    private StockDataDao stockDataDao;

    public DataCalculation() {
        this.stockDataDao = new MockStockData();
    }

    public StockVO getStockInfo(String stockCode, Date startDate, Date endDate) {

        ArrayList<StockPO> stockPOs = this.stockDataDao.getStockPOsByTimeInterval(startDate.toString(),
                endDate.toString(), stockCode);

        if (stockPOs == null || stockPOs.size() == 1) {
            return null;
        }

        //寻找这段时间的最低值和最高值
        double min = stockPOs.get(0).getMinValue(), max = stockPOs.get(0).getMaxValue();

        for (int i = 1; i < stockPOs.size(); ++i) {
            if (min > stockPOs.get(i).getMinValue()) {
                min = stockPOs.get(i).getMinValue();
            }

            if (max < stockPOs.get(i).getMaxValue()) {
                max = stockPOs.get(i).getMaxValue();
            }
        }

        //计算涨幅/跌幅、每天的收盘价和对数收益率
        ArrayList<StockDailyInfoVO> stockDailyInfoVOs = new ArrayList<StockDailyInfoVO>();
        stockDailyInfoVOs.add(new StockDailyInfoVO(DateHelper.stringTransToDate(stockPOs.get(0).getDate()),
                0, stockPOs.get(0).getClosePrice(), 0));

        for (int i = 1; i < stockPOs.size(); ++i) {
            Date date = DateHelper.stringTransToDate(stockPOs.get(i).getDate());
            double inOrDecreaseRate = (stockPOs.get(i).getClosePrice() - stockPOs.get(i - 1).getClosePrice()) / stockPOs.get(i - 1).getClosePrice();
            double logarithmYield = stockPOs.get(i).getClosePrice() / stockPOs.get(i - 1).getClosePrice();

            stockDailyInfoVOs.add(new StockDailyInfoVO(date, inOrDecreaseRate, stockPOs.get(i).getClosePrice(), logarithmYield));
        }

        //计算对数收益率方差
        double logarithmYieldVariance = 0;

        double[] temp = new double[stockDailyInfoVOs.size()];
        for (int i = 0; i < stockDailyInfoVOs.size(); ++i) {
            temp[i] = stockDailyInfoVOs.get(i).logarithmYield;
        }

        logarithmYieldVariance = MathHelper.calculateVariance(temp);


        StockVO stockVO = new StockVO(stockPOs.get(0).getStockCode(), stockPOs.get(0).getStockName(),
                stockPOs.get(0).getStockMarket(), min, max, logarithmYieldVariance, stockDailyInfoVOs);


        return stockVO;
    }

    /**
     * 系统可以显示用户查询日期或者某一日期的股票交易市场行情相关数据。
     * 相关数据应当包括但不局限于:当日总交易量、涨停股票数、跌停股票数、涨幅超过5%的股票数，跌幅超过5%的股票数，
     * 开盘‐收盘大于5%*上一个交易日收盘价的股票个数、开盘‐收盘小于‐5%*上一个交易日收盘价的股票个数。
     * @param date 日期
     * @return
     */
    public MarketInfoVO getMarketInfo(Date date) {

        Date formerTradeDay = DateHelper.formerTradeDay(date);

        ArrayList<StockPO> yesterdayStockMarket = this.stockDataDao.getStockPOsByDate(DateHelper.dateTransToString(formerTradeDay));

        ArrayList<StockPO> todayStockMarket = this.stockDataDao.getStockPOsByDate(DateHelper.dateTransToString(date));

        //计算当日总交易量
        int j = 0;          //yesterdayStockMarket遍历的下标
        int allVolume = 0;
        int[] rateNums = new int[6]; //数据依次为跌停，-10%- -5%，-5%-0，0-5%，5%-10%，涨停
        int greaterThanFiveNum = 0, lessThanFiveNum = 0;

        for (int i = 0; i < todayStockMarket.size(); ++i, ++j) {
            allVolume += todayStockMarket.get(i).getVolume();

            while (!yesterdayStockMarket.get(j).getStockCode().equals(todayStockMarket.get(i).getStockCode())) {
                j++;
                if (j >= yesterdayStockMarket.size()) {
                    break;
                }
            }
            if (j >= yesterdayStockMarket.size()) {
                break;
            }

            double rate = (todayStockMarket.get(i).getClosePrice() - yesterdayStockMarket.get(j).getClosePrice()) / yesterdayStockMarket.get(j).getClosePrice();

            if (rate <= -0.1) {
                rateNums[0]++;
            } else if (rate > -0.1 && rate < -0.05) {
                rateNums[1]++;
            } else if (rate >= -0.05 && rate < 0) {
                rateNums[2]++;
            } else if (rate > 0 && rate <= 0.05) {
                rateNums[3]++;
            } else if (rate > 0.05 && rate < 0.1) {
                rateNums[4]++;
            } else if (rate >= 0.1) {
                rateNums[5]++;
            }

            if ((todayStockMarket.get(i).getOpenPrice() - todayStockMarket.get(i).getClosePrice()) > 0.05 * yesterdayStockMarket.get(j).getClosePrice()) {
                greaterThanFiveNum++;
            } else {
                lessThanFiveNum++;
            }
        }

        MarketInfoVO marketInfoVO = new MarketInfoVO(date, allVolume, rateNums, greaterThanFiveNum, lessThanFiveNum);

        return marketInfoVO;
    }

}
