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
            result.put(stocks.get(i).getDate(), new MaVO(stocks.get(i).getCode(), dayNums, date, average));
        }

        return result;
    }
}
