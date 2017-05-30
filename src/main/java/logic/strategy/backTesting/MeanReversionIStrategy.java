package logic.strategy.backTesting;

import bean.Stock;
import logic.tools.MathHelper;
import org.springframework.stereotype.Service;
import vo.stock.MaVO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
@Service("1")
public class MeanReversionIStrategy implements IStrategy {

    //保存所有股票的N日移动均线
    private ArrayList<HashMap<String, MaVO>> allAverageLine = new ArrayList<>();
    private int returnPeriod;               //形成期

    @Override
    public ArrayList<StockYield> initHoldingStocks(StockPool stockPool, ArrayList<String> dates) {

        ArrayList<StockYield> stockYields = new ArrayList<>();

        //确定移动均线类型
        int type = stockPool.getStrategyBackTestInputVO().getReturnPeriod();

        //遍历股票池中股票
        for (int i = 0; i < stockPool.getStocksList().size(); ++i) {
            Stock before = stockPool.getStocksList().get(i).getBeforeStock();
            String beforeDate = before.getDate();
            Stock yesterday = stockPool.getStocksList().get(i).getYesterdayStock();

            HashMap<String, MaVO> averageLine;
            if(this.returnPeriod != stockPool.getStrategyBackTestInputVO().getReturnPeriod()) {              //第一次加载 将allAverageLine初始化
                //初始化第i只股票的N日移动均线
                averageLine = getAverageLineInfoByCode(stockPool, beforeDate,stockPool.getEndDate(), yesterday.getStockId(), type);
                //添加到allAverageLine
                allAverageLine.add(averageLine);
            } else {                                                     //不是第一次加载，直接从allAverageLine中获取
                averageLine = this.allAverageLine.get(i);
            }

            boolean live = true;                                        //持有期內每天的股票信息必须有 否则不持有该股票
            for (int j = 0; j < dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }

            if (!live || yesterday == null || before == null) {
                continue;
            }

            //计算偏离度，(均值-当天的开盘价)/ 均值
            //如果当天无数据,跳出循环
            double average = 0;
            if (averageLine.get(stockPool.getStartDate()) != null) {
                average = averageLine.get(stockPool.getStartDate()).getAverageValue();
            }
            double yield = (average - yesterday.getClose()) / average;

            stockYields.add(new StockYield(yesterday.getStockId(), yield));
        }

        this.returnPeriod = stockPool.getStrategyBackTestInputVO().getReturnPeriod();            //初始化形成期

        return stockYields;
    }

    @Override
    public ArrayList<StockYield> rebalanceHoldingStocks(StockPool stockPool, String beforeDate, String today, ArrayList<String> dates) {

        ArrayList<StockYield> stockYields = new ArrayList<>();

        for (int i = 0; i < stockPool.getStocksList().size(); ++i) {
            Stock before = stockPool.getStocksList().get(i).getStockByDate(beforeDate);
            Stock yesterday = stockPool.getStocksList().get(i).getStockByDate(today);

            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
            for (int j = 0; j < dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }

            if (live && yesterday != null && before != null) {
                //计算偏离度，(均值-当天的开盘价)/ 均值
                double average = 0;
                if (allAverageLine.get(i).get(today) != null) {
                    average = allAverageLine.get(i).get(today).getAverageValue();
                }
                double yield = (average - yesterday.getClose()) / average;

                stockYields.add(new StockYield(yesterday.getStockId(), yield));
            }

        }

        return stockYields;
    }


    /**
     * 辅助方法，获取N日移动均线
     * @param stockPool 股票池
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param stockCode 股票代码
     * @return
     */
    public HashMap<String, MaVO> getAverageLineInfoByCode(StockPool stockPool, String startDate, String endDate, String stockCode, int dayNums) {

        assert (stockCode != null && !stockCode.equals("") && startDate != null && endDate != null)
                : "logic.calculation.GraphCalculation.getAverageLineInfoByCode参数异常";

        //如果总天数小于均线图的时间间隔出错
//        ArrayList<Stock> stocks = stockDataDao.getStockPOsByTimeInterval(DateHelper.getInstance().dateTransToString(startDate),
//                DateHelper.getInstance().dateTransToString(endDate), stockCode, true);

        ArrayList<Stock> stocks = stockPool.getStockByCode(stockCode).getStocks();

        if (dayNums > stocks.size()) {
            return null;
        }

        HashMap<String, MaVO> result = new HashMap<>();

        for (int i = stocks.size() - dayNums; i >= 0; i--) {
            String date = stocks.get(i).getDate();

            double all = 0;
            for (int j = i + dayNums - 1; j > i - 1; j--) {
                all += stocks.get(j).getClose();
            }

            double average = MathHelper.formatData(all / dayNums, 2);

            result.put(stocks.get(i).getDate(), new MaVO(stocks.get(i).getStockId(), dayNums, date, average));
        }

        return result;
    }
}
