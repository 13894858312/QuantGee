package logic.strategy.backTesting;

import bean.Stock;
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
    private HashMap<String, HashMap<String, MaVO>> allMaLine = new HashMap<>();

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate, String formerHPeriodDate, ArrayList<String> nextDates, ArrayList<String> formerDates) {
        if (nextDates.size() == 0) {
            return null;
        }
        String yesterday = nextDates.get(0);
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        ArrayList<String> topCodes;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < stockPool.getStocksList().size(); ++i) {
            Stock yesterdayStock = stockPool.getStocksList().get(i).getStockByDate(yesterday);
            if(yesterdayStock == null) { continue;}

            boolean live = true;                     //持有期內每天的股票信息必须有 否则不持有该股票
            for (int j = 1; j < nextDates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(nextDates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }
            if (!live) { continue;}

            HashMap<String, MaVO> maLine = allMaLine.get(yesterdayStock.getCode());
            if(maLine == null) {                                                //第一次加载 将allAverageLine初始化
                int maType = stockPool.getInputVO().getReturnPeriod();           //添加到allAverageLine
                maLine = StrategyHelper.getMaFromStockPool(stockPool, yesterdayStock.getCode(), maType);
                if(maLine != null) {
                    allMaLine.put(yesterdayStock.getCode(),maLine);
                } else {
                    continue;
                }
            }

            //计算偏离度 (均值-当天的开盘价)/ 均值
            double average = 0;
            if (maLine.get(yesterday) != null) {
                average = maLine.get(yesterday).getMa();
            }

            double yield = (average - yesterdayStock.getClose()) / average;
            yieldStocks.add(new YieldStock(yesterdayStock.getCode(), yield));
        }

        //得到收益前holdingStockNum的股票代码
        topCodes = StrategyHelper.getTopNStocks(yieldStocks, holdingStockNum,true);
        if(holdingStocks.size() == 0) {
            return topCodes;
        }

        HashMap<String, LogicHoldingStock> hashMap = new HashMap<>();
        for (int i=0; i<holdingStocks.size(); ++i) {
            holdingStocks.get(i).setCanContinueHold(false);         //假设现在持有的股票都不可以继续持有
            hashMap.put(holdingStocks.get(i).getStockCode(), holdingStocks.get(i));
        }

        for (int i=0; i<topCodes.size(); ++i) {
            if (hashMap.get(topCodes.get(i)) != null) {
                hashMap.get(topCodes.get(i)).setCanContinueHold(true);     //将可以继续持有的股票保留
            } else {
                result.add(topCodes.get(i));
            }
        }

        return result;
    }

    @Override
    public int getStrategyType() {
        return 1;
    }

}
