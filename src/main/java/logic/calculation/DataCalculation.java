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
    private DateHelper dateHelper;

    public DataCalculation() {
        this.dateHelper = DateHelper.getInstance();
        this.stockDataDao = new StockData();
    }

    public StockVO getStockInfoByCode(String stockCode, Date startDate, Date endDate) {

        assert (stockCode != null && !stockCode.equals("") && startDate != null && endDate != null)
                : "logic.calculation.DataCalculation.getStockInfoByCode参数异常";

        ArrayList<StockPO> stockPOs = this.stockDataDao.getStockPOsByTimeInterval(DateHelper.getInstance().dateTransToString(startDate),
                DateHelper.getInstance().dateTransToString(endDate), stockCode);

        if (stockPOs == null || stockPOs.size() == 0) {
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
        stockDailyInfoVOs.add(new StockDailyInfoVO(stockPOs.get(0).getStockCode(), stockPOs.get(0).getStockName(),
                dateHelper.stringTransToDate(stockPOs.get(0).getDate()), 0, stockPOs.get(0).getClosePrice(), 0));

        for (int i = 1; i < stockPOs.size(); ++i) {
            Date date = dateHelper.stringTransToDate(stockPOs.get(i).getDate());
            double inOrDecreaseRate = (stockPOs.get(i).getADJ() - stockPOs.get(i - 1).getADJ()) / stockPOs.get(i - 1).getADJ();
            double logarithmYield = Math.log(stockPOs.get(i).getADJ() / stockPOs.get(i - 1).getADJ());

            stockDailyInfoVOs.add(new StockDailyInfoVO(stockPOs.get(i).getStockCode(), stockPOs.get(i).getStockName(), date, inOrDecreaseRate, stockPOs.get(i).getClosePrice(), logarithmYield));
        }


        //计算对数收益率方差
        double logarithmYieldVariance = 0;
        double[] temp = new double[stockDailyInfoVOs.size()];
        for (int i = 0; i < stockDailyInfoVOs.size(); ++i) {
            temp[i] = stockDailyInfoVOs.get(i).logarithmYield;
        }

        logarithmYieldVariance = MathHelper.sampleVariance(temp);

        double rate = 0;
        rate = (stockPOs.get(stockPOs.size() - 1).getADJ() - stockPOs.get(0).getADJ()) / stockPOs.get(0).getADJ();
        rate = MathHelper.formatData(rate);


        StockVO stockVO = new StockVO(stockPOs.get(0).getStockCode(), stockPOs.get(0).getStockName(),
                stockPOs.get(0).getStockMarket(), min, max, logarithmYieldVariance, rate, stockDailyInfoVOs);


        return stockVO;
    }


    /**
     * 系统可以显示用户查询日期或者某一日期的股票交易市场行情相关数据。
     * 相关数据应当包括但不局限于:当日总交易量、涨停股票数、跌停股票数、涨幅超过5%的股票数，跌幅超过5%的股票数，
     * 开盘‐收盘大于5%*上一个交易日收盘价的股票个数、开盘‐收盘小于‐5%*上一个交易日收盘价的股票个数。
     *
     * @param date 日期
     * @return
     */
    public MarketInfoVO getMarketInfo(Date date) {

        assert (date != null) : "logic.calculation.DataCalculation.getMarketInfo参数异常";

        ArrayList<StockPO> todayStockMarket = this.stockDataDao.getStockPOsByDate(dateHelper.dateTransToString(date));

        if (todayStockMarket == null) {
            return null;
        }

        Date formerTradeDay = dateHelper.formerTradeDay(date);
        ArrayList<StockPO> yesterdayStockMarket = this.stockDataDao.getStockPOsByDate(dateHelper.dateTransToString(formerTradeDay));

        //寻找上一个交易日
        while (yesterdayStockMarket == null) {
            Date temp = dateHelper.formerTradeDay(date);

            //超过时间范围
            if (dateHelper.dateOutOfRange(temp)) {
                return null;
            }

            yesterdayStockMarket = this.stockDataDao.getStockPOsByDate(dateHelper.dateTransToString(temp));
        }

//        System.out.println("yesterdayStockMarket: " + yesterdayStockMarket.size());
//        for (int i = 0; i < yesterdayStockMarket.size(); ++i) {
//            System.out.println("1:  " + yesterdayStockMarket.get(i).getStockCode());
//        }
//        System.out.println("todayStockMarket: " + todayStockMarket.size());
//        for (int i = 0; i < todayStockMarket.size(); ++i) {
//            System.out.println("1:  " + todayStockMarket.get(i).getStockCode());
//        }

        todayStockMarket = sortList(todayStockMarket);
        yesterdayStockMarket = sortList(yesterdayStockMarket);


//        System.out.println("yesterdayStockMarket: " + yesterdayStockMarket.size());
//        for (int i = 0; i < yesterdayStockMarket.size(); ++i) {
//            System.out.println("2:  " + yesterdayStockMarket.get(i).getStockCode());
//        }
//        System.out.println("todayStockMarket: " + todayStockMarket.size());
//        for (int i = 0; i < todayStockMarket.size(); ++i) {
//            System.out.println("2:  " + todayStockMarket.get(i).getStockCode());
//        }

        //计算当日总交易量
        int j = 0;          //yesterdayStockMarket遍历的下标
        double allVolume = 0;
        int[] rateNums = new int[6]; //数据依次为跌停，-10%- -5%，-5%-0，0-5%，5%-10%，涨停
        for (int i = 0; i < rateNums.length; ++i) {  //初始化
            rateNums[i] = 0;
        }
        int greaterThanFiveNum = 0, lessThanFiveNum = 0;

        for (int i = 0; i < todayStockMarket.size(); ++i, ++j) {
            allVolume += todayStockMarket.get(i).getVolume();

            while (!yesterdayStockMarket.get(j).getStockCode().equals(todayStockMarket.get(i).getStockCode())) {

//                System.out.println("here i " + i + " code: " + todayStockMarket.get(i).getCodeNumber());
//                System.out.println("here j " + j + " code: " + yesterdayStockMarket.get(j).getCodeNumber());

                if (yesterdayStockMarket.get(j).getCodeNumber() < todayStockMarket.get(i).getCodeNumber()) {
                    j++;
                } else if (yesterdayStockMarket.get(j).getCodeNumber() > todayStockMarket.get(i).getCodeNumber()) {
                    i++;
                }

//                System.out.println("here i " + i + " code: " + todayStockMarket.get(i).getCodeNumber());
//                System.out.println("here j " + j + " code: " + yesterdayStockMarket.get(j).getCodeNumber());
//                System.out.println();

                if (j >= yesterdayStockMarket.size() || i >= todayStockMarket.size()) {
                    break;
                }
            }
            if (j >= yesterdayStockMarket.size() || i >= todayStockMarket.size()) {
                break;
            }

            double rate = (todayStockMarket.get(i).getADJ() - yesterdayStockMarket.get(j).getADJ()) / yesterdayStockMarket.get(j).getADJ();

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

            if ((todayStockMarket.get(i).getOpenPrice() - todayStockMarket.get(i).getClosePrice()) >
                    0.05 * yesterdayStockMarket.get(j).getClosePrice()) {
                greaterThanFiveNum++;
            } else if ((todayStockMarket.get(i).getOpenPrice() - todayStockMarket.get(i).getClosePrice()) <
                    -0.05 * yesterdayStockMarket.get(j).getClosePrice()) {
                lessThanFiveNum++;
            }
        }


        for (int i = 0; i < rateNums.length; ++i) {  //初始化
            System.out.println(rateNums[i]);
        }


        MarketInfoVO marketInfoVO = new MarketInfoVO(date, allVolume, rateNums, greaterThanFiveNum, lessThanFiveNum);

        return marketInfoVO;
    }

    public StockVO getStockInfoByName(String stockName, Date startDate, Date endDate) {

        assert (stockName != null && !stockName.equals("") && startDate != null && endDate != null)
                : "logic.calculation.DataCalculation.getStockInfoByName参数异常";


        String code = this.stockDataDao.getStockCodeByName(stockName);


//        System.out.println(stockName);
//        System.out.println(code);

        if (code == null || code.equals("")) {
            return null;
        }

        return this.getStockInfoByCode(code, startDate, endDate);
    }

    public ArrayList<StockPO> sortList(ArrayList<StockPO> stockPOS) {
        ArrayList<StockPO> result = new ArrayList<StockPO>();

        SortItem[] ids = new SortItem[stockPOS.size()];

        for (int i = 0; i < stockPOS.size(); ++i) {
            ids[i] = new SortItem(stockPOS.get(i).getCodeNumber(), i);
        }

        for (int i = 0; i < ids.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < ids.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (ids[j].getCodeNumber() > ids[j + 1].getCodeNumber()) {
                    SortItem temp = ids[j];
                    ids[j] = new SortItem(ids[j + 1].getCodeNumber(), ids[j + 1].getIndex());
                    ids[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < ids.length; ++i) {
            result.add(stockPOS.get(ids[i].getIndex()));
        }

        return result;
    }

    private class SortItem {
        private int codeNumber;
        private int index;

        public SortItem(int codeNumber, int index) {
            this.codeNumber = codeNumber;
            this.index = index;
        }

        public int getCodeNumber() {
            return codeNumber;
        }

        public int getIndex() {
            return index;
        }

        public void setCodeNumber(int codeNumber) {
            this.codeNumber = codeNumber;
        }
    }
}
