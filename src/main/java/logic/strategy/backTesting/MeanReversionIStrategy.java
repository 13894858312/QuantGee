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
    private ArrayList<HashMap<String, MaVO>> allMaLine = new ArrayList<>();
    private int returnPeriod;               //形成期

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate,String formerHPeriod, ArrayList<String> dates) {
        if (dates.size() == 0) {
            return null;
        }
        String yesterday = dates.get(0);
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        ArrayList<String> topCodes;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < stockPool.getStocksList().size(); ++i) {
            Stock yesterdayStock = stockPool.getStocksList().get(i).getStockByDate(yesterday);

            if(yesterdayStock == null) {
                continue;
            }

            HashMap<String, MaVO> maLine;
            int maType = stockPool.getInputVO().getReturnPeriod();
            if(this.returnPeriod != maType) {       //第一次加载 将allAverageLine初始化
                //初始化第i只股票的N日移动均线
                maLine = StrategyHelper.getMaFromStockPool(stockPool, yesterdayStock.getCode(), maType);
                //添加到allAverageLine
                allMaLine.add(maLine);
            } else {     //不是第一次加载，直接从allAverageLine中获取
                maLine = this.allMaLine.get(i);
            }

            boolean live = true;                     //持有期內每天的股票信息必须有 否则不持有该股票
            for (int j = 1; j < dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }

            if (live) {
                //计算偏离度 (均值-当天的开盘价)/ 均值
                double average = 0;
                if (maLine.get(yesterday) != null) {
                    average = maLine.get(yesterday).getAverageValue();
                }

                double yield = (average - yesterdayStock.getClose()) / average;
                yieldStocks.add(new YieldStock(yesterdayStock.getCode(), yield));
            }
        }

        //得到收益前holdingStockNum的股票代码
        topCodes = StrategyHelper.getTopNStocks(yieldStocks, holdingStockNum,true);
        if(holdingStocks.size() == 0) {
            return topCodes;
        }

        HashMap<String, LogicHoldingStock> hashMap = new HashMap<>();
        for (int i=0; i<holdingStocks.size(); ++i) {
            hashMap.put(holdingStocks.get(i).getStockCode(), holdingStocks.get(i));
        }

        for (int i=0; i<topCodes.size(); ++i) {
            LogicHoldingStock temp = hashMap.get(topCodes.get(i));
            if (temp != null) {
                temp.setCanContinueHold(true);              //可以继续持有该股票
            } else {
                result.add(topCodes.get(i));
            }
        }

        //初始化形成期
        this.returnPeriod = stockPool.getInputVO().getReturnPeriod();

        return result;
    }

}
