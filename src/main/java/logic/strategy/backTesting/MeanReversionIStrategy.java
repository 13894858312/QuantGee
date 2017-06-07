package logic.strategy.backTesting;

import bean.Stock;
import logic.stock.StockHelper;
import logic.tools.MathHelper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import vo.stock.MaVO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 均值回归策略
 * Created by Mark.W on 2017/3/29.
 */
@Service("1")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MeanReversionIStrategy implements IStrategy {

    //保存所有股票的N日移动均线
    private ArrayList<HashMap<String, MaVO>> allMaLine = new ArrayList<>();
    private int returnPeriod;               //形成期

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool,int holdingStockNum, String beforeDate, String today, ArrayList<String> dates) {
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < stockPool.getStocksList().size(); ++i) {
            Stock beforeStock = stockPool.getStocksList().get(i).getStockByDate(beforeDate);
            Stock todayStock = stockPool.getStocksList().get(i).getStockByDate(today);

            HashMap<String, MaVO> maLine;
            int maType = stockPool.getInputVO().getReturnPeriod();
            if(this.returnPeriod != maType) {       //第一次加载 将allAverageLine初始化
                //初始化第i只股票的N日移动均线
                maLine = getMaLineFromStockPool(stockPool, beforeDate,stockPool.getEndDate(), todayStock.getCode(), maType);
                //添加到allAverageLine
                allMaLine.add(maLine);
            } else {     //不是第一次加载，直接从allAverageLine中获取
                maLine = this.allMaLine.get(i);
            }

            boolean live = true;                     //持有期內每天的股票信息必须有 否则不持有该股票
            for (int j = 0; j < dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }

            if (live && todayStock != null && beforeStock != null) {
                //计算偏离度 (均值-当天的开盘价)/ 均值
                double average = 0;
                if (maLine.get(today) != null) {
                    average = maLine.get(today).getAverageValue();
                }

                double yield = (average - todayStock.getClose()) / average;
                yieldStocks.add(new YieldStock(todayStock.getCode(), yield));
            }
        }

        //得到收益前holdingStockNum的股票代码
        result = StockHelper.getTopNStocks(yieldStocks, holdingStockNum);
        this.returnPeriod = stockPool.getInputVO().getReturnPeriod();            //初始化形成期

        return result;
    }


    /**
     * 辅助方法，获取N日移动均线
     * @param stockPool 股票池
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param stockCode 股票代码
     * @return
     */
    public HashMap<String, MaVO> getMaLineFromStockPool(StockPool stockPool, String startDate, String endDate, String stockCode, int dayNums) {
        assert (stockCode != null && !stockCode.equals("") && startDate != null && endDate != null)
                : "logic.calculation.GraphCalculation.getAverageLineInfoByCode参数异常";

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
