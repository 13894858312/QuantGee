package logic.strategy.backTesting;


import bean.Stock;
import logic.tools.DateHelper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
@Service("0")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MomentumDriveIStrategy implements IStrategy {

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate,String formerHPeriod, ArrayList<String> dates) {
        if (dates.size() == 0) {
            return null;
        }
        String yesterday = dates.get(0);

        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        ArrayList<String> tempCodes;
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock before = stockPool.getStocksList().get(i).getStockByDate(formerRPeriodDate);
            Stock yesterdayStock = stockPool.getStocksList().get(i).getStockByDate(yesterday);

            if (yesterdayStock == null || before == null) {
                continue;
            }

            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
            for(int j=1; j<dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if(po == null) {
                    live = false;
                    break;
                }
            }

            if(live) {
                //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
                double yield = (yesterdayStock.getClose()-before.getClose())/before.getClose();
                yieldStocks.add(new YieldStock(yesterdayStock.getCode(), yield));
            }
        }

        //得到收益前holdingStockNum的股票代码
        tempCodes  = StrategyHelper.getTopNStocks(yieldStocks, holdingStockNum,true);
        if(holdingStocks.size() == 0) {
            return tempCodes;
        }
        HashMap<String, LogicHoldingStock> hashMap = new HashMap<>();
        for (int i=0; i<holdingStocks.size(); ++i) {
            hashMap.put(holdingStocks.get(i).getStockCode(), holdingStocks.get(i));
        }

        for (int i=0; i<tempCodes.size(); ++i) {
            LogicHoldingStock temp = hashMap.get(tempCodes.get(i));
            if (temp != null) {
                temp.setCanContinueHold(true);              //可以继续持有该股票
            } else {
                result.add(tempCodes.get(i));
            }
        }

        return result;
    }
}
