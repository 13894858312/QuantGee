package logic.strategy.backTesting;

import bean.Stock;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/6/7.
 * 羊驼策略
 */
@Service("3")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AlpacaStrategy implements IStrategy{

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate, String formerHPeriodDate, ArrayList<String> dates) {
        if (dates.size() == 0) {return null;}

        String yesterday = dates.get(0);
        String today = dates.get(1);
        int changeNum = stockPool.getInputVO().getChangeNumber();

        ArrayList<YieldStock> allstockYields = new ArrayList<>();
        ArrayList<YieldStock> holdingstockYields = new ArrayList<>();
        ArrayList<String> addCodes;
        ArrayList<String> sellCodes;

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock before = stockPool.getStocksList().get(i).getStockByDate(formerRPeriodDate);
            Stock yesterdayStock = stockPool.getStocksList().get(i).getStockByDate(yesterday);

            if (yesterdayStock != null && before != null) {
                boolean live = true;                                   //持有期内每天的股票信息必须有 否则不持有该股票
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
                    allstockYields.add(new YieldStock(yesterdayStock.getCode(), yield));
                }
            }
        }

        if (holdingStocks.size() == 0) {
            addCodes  = StrategyHelper.getTopNStocks(allstockYields, holdingStockNum, false);
            return addCodes;
        }
        //得到收益后holdingStockNum的股票代码
        addCodes  = StrategyHelper.getTopNStocks(allstockYields, changeNum, false);

        //计算持有股票的收益率
        for (int i=0; i<holdingStocks.size(); ++i) {
            String code = holdingStocks.get(i).getStockCode();

            Stock beforeStock = stockPool.getStockByCodeAndDate(code, formerHPeriodDate);
            Stock todayStock = stockPool.getStockByCodeAndDate(code, today);

            if (todayStock != null && beforeStock != null) {
                double yield = (todayStock.getClose()-beforeStock.getClose())/beforeStock.getClose();
                holdingstockYields.add(new YieldStock(code, yield));
            }
        }

        sellCodes = StrategyHelper.getTopNStocks(holdingstockYields, changeNum, false);
        HashMap<String, LogicHoldingStock> hashMap = new HashMap<>();
        for (int i=0; i<holdingStocks.size(); ++i) {
            hashMap.put(holdingStocks.get(i).getStockCode(), holdingStocks.get(i));
        }
        //将收益后changeNum个卖出
        for (int i=0; i<sellCodes.size(); ++i) {
            hashMap.get(sellCodes.get(i)).setCanContinueHold(false);
        }

        return addCodes;
    }
}
