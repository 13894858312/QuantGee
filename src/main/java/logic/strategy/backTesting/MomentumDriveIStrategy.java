package logic.strategy.backTesting;


import bean.Stock;
import logic.stock.StockHelper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
@Service("0")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MomentumDriveIStrategy implements IStrategy {

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, int holdingStockNum, String beforeDate, String today, ArrayList<String> dates) {
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock before = stockPool.getStocksList().get(i).getStockByDate(beforeDate);
            Stock yesterday = stockPool.getStocksList().get(i).getStockByDate(today);

            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
            for(int j=0; j<dates.size(); ++j) {
                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
                if(po == null) {
                    live = false;
                    break;
                }
            }

            if(live && yesterday != null && before != null) {
                //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
                double yield = (yesterday.getClose()-before.getClose())/before.getClose();
                yieldStocks.add(new YieldStock(yesterday.getCode(), yield));
            }
        }

        //得到收益前holdingStockNum的股票代码
        result = StockHelper.getTopNStocks(yieldStocks, holdingStockNum);
        return result;
    }

    @Override
    public ArrayList<YieldStock> initHoldingStocks(StockPool stockPool, ArrayList<String> dates) {
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();

//        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
//            Stock before = stockPool.getStocksList().get(i).getBeforeStock();
//            Stock yesterday = stockPool.getStocksList().get(i).getYesterdayStock();
//
//            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
//            for(int j=0; j<dates.size(); ++j) {
//                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
//                if(po == null) {
//                    live = false;
//                    break;
//                }
//            }
//
//            if(live && yesterday != null && before != null) {
//                //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
//                double yield = (yesterday.getClose()-before.getClose())/before.getClose();
//
//                yieldStocks.add(new YieldStock(yesterday.getCode(), yield));
//            }
//        }

        return yieldStocks;
    }

    @Override
    public ArrayList<YieldStock> rebalanceHoldingStocks(StockPool stockPool, String beforeDate, String today, ArrayList<String> dates) {

        ArrayList<YieldStock> yieldStocks = new ArrayList<>();

//        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
//            Stock before = stockPool.getStocksList().get(i).getStockByDate(beforeDate);
//            Stock yesterday = stockPool.getStocksList().get(i).getStockByDate(today);
//
//            boolean live = true;                                   //持有期內每天的股票信息必须有 否则不持有该股票
//            for(int j=0; j<dates.size(); ++j) {
//                Stock po = stockPool.getStocksList().get(i).getStockByDate(dates.get(j));
//                if(po == null) {
//                    live = false;
//                    break;
//                }
//            }
//
//            if(live && yesterday != null && before != null) {
//                //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
//                double yield = (yesterday.getClose()-before.getClose())/before.getClose();
//
//                yieldStocks.add(new YieldStock(yesterday.getCode(), yield));
//            }
//
//        }

        return yieldStocks;
    }
}
