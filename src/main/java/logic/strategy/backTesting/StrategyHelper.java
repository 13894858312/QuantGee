package logic.strategy.backTesting;

import bean.Stock;
import logic.tools.MathHelper;
import vo.stock.MaVO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/6/7.
 * 策略回测的帮助类
 */
public class StrategyHelper {

    /**
     * 获取前n股票
     * @param stocks  stocks
     * @param n n
     * @param up 获取收益最高的n个或是收益最低的n个
     * @return 前n的股票代码
     */
    public static ArrayList<String> getTopNStocks(ArrayList<YieldStock> stocks, int n, boolean up) {
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i<n; ++i) {
            int index = 0;
            for(int j=1; j<stocks.size(); ++j) {
                if(up) {
                    if(stocks.get(j).getYield() > stocks.get(index).getYield()) {
                        index = j;
                    }
                } else {
                    if(stocks.get(j).getYield() < stocks.get(index).getYield()) {
                        index = j;
                    }
                }
            }
            result.add(stocks.get(index).getStockCode());
            stocks.remove(index);
        }

        assert (result.size() > 0) : "logic.stock.StockHelper.getTopNStocks返回值size为0";
        return result;
    }

    /**
     * 获取股票时内某一个股票的N日移动均线
     * @param stockPool 股票池
     * @param stockCode 股票代码
     * @return HashMap date-ma
     */
    public static HashMap<String,MaVO> getMaFromStockPool(StockPool stockPool, String stockCode, int dayNums) {
        assert (stockCode != null && !stockCode.equals("")) : "logic.calculation.GraphCalculation.getAverageLineInfoByCode参数异常";

        LogicStock stock = stockPool.getStockByCode(stockCode);
        ArrayList<Stock> stocks = stock.getStocks();
        if (dayNums > stocks.size()) {
            return null;
        }

        HashMap<String, MaVO> result = new HashMap<>();
        for (int i = stock.getStartIndex(); i <stocks.size(); ++i) {
            String date = stocks.get(i).getDate();
            double all = 0;
            int start = Math.max(i-dayNums+1, 0);
            dayNums = i-start +1;

            for (int j=start; j<=i; ++j) {
                all += stocks.get(j).getClose();
            }
            double average = MathHelper.formatData(all / dayNums, 2);
            result.put(stocks.get(i).getDate(), new MaVO(stocks.get(i).getCode(), dayNums, date, average));
        }

        return result;
    }

    /**
     * 获取股票时内某一个股票的N日平滑移动均线
     * @param stockPool 股票池
     * @param stockCode 股票代码
     * @return HashMap date-ma
     */
    public static HashMap<String,MaVO> getEmaFromStockPool(StockPool stockPool, String stockCode, int dayNums) {
        assert (stockCode != null && !stockCode.equals("")) : "logic.calculation.GraphCalculation.getAverageLineInfoByCode参数异常";

        LogicStock stock = stockPool.getStockByCode(stockCode);
        ArrayList<Stock> stocks = stock.getStocks();
        if (dayNums > stocks.size()) {
            return null;
        }

        HashMap<String, MaVO> result = new HashMap<>();
        double ema = 0, alpha = getAlpha(dayNums);

        for (int i = stock.getStartIndex(); i <stocks.size(); ++i) {
            String date = stocks.get(i).getDate();

            if (i == stock.getStartIndex()) {
                int start = Math.max(i-dayNums+1, 0);
                dayNums = i-start +1;
                for (int j=start; j<=i; ++j) {
                    ema += stocks.get(j).getClose();
                }
                ema = MathHelper.formatData(ema/dayNums, 2);
            } else {
                ema = alpha * ema + (1-alpha) * stocks.get(i-1).getClose();
            }

            result.put(stocks.get(i).getDate(), new MaVO(stocks.get(i).getCode(), dayNums, date, ema));
        }

        return result;
    }

    private static double getAlpha(int n) {
        double result = (double)(n-1)/(double)(n+1);
        return result;
    }

}
