package logic.strategy.backTesting;

import bean.Stock;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/6/7.
 * 羊驼策略
 */
@Service("3")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AlpacaStrategy implements IStrategy{
    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum, String beforeDate, ArrayList<String> dates) {
        if (dates.size() == 0) {
            return null;
        }
        String yesterday = dates.get(0);
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        ArrayList<String> result;

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock before = stockPool.getStocksList().get(i).getStockByDate(beforeDate);
            Stock yesterdayStock = stockPool.getStocksList().get(i).getStockByDate(yesterday);

            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
            for(int j=0; j<dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if(po == null) {
                    live = false;
                    break;
                }
            }

            if(live && yesterdayStock != null && before != null) {
                //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
                double yield = (yesterdayStock.getClose()-before.getClose())/before.getClose();
                yieldStocks.add(new YieldStock(yesterdayStock.getCode(), yield));
            }
        }

        //得到收益前holdingStockNum的股票代码
        result = StrategyHelper.getTopNStocks(yieldStocks, holdingStockNum);
        return result;
    }
}
