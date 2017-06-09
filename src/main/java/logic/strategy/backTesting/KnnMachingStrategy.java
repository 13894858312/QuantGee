package logic.strategy.backTesting;

import bean.Stock;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/6/8.
 * KNN机器学习策略
 */
@Service("4")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KnnMachingStrategy implements IStrategy {
    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate, String formerHPeriodDate, ArrayList<String> nextDates) {

        if (nextDates.size() == 0) {
            return null;
        }

        String today = nextDates.get(1);
        ArrayList<YieldStock> yieldStocks = new ArrayList<>();

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock formerStock = stockPool.getStocksList().get(i).getStockByDate(formerRPeriodDate);
            if (formerStock == null){
                continue;
            }
            double predictPrice = knnPredict(stockPool, formerStock.getCode(), today);

            double yield = (predictPrice-formerStock.getClose())/formerStock.getClose();
            if (yield >0) {
                yieldStocks.add(new YieldStock(formerStock.getCode(), yield));
            }
        }

        for(int i=0; i<holdingStocks.size(); ++i) {
            holdingStocks.get(i).setCanContinueHold(false);
        }

        ArrayList<String> result = StrategyHelper.getTopNStocks(yieldStocks, holdingStockNum, true);

        return result;
    }

    private double knnPredict(StockPool stockPool, String code, String today) {
        LogicStock stock = stockPool.getStockByCode(code);


        return 0;
    }

    private class KnnStock {
        private String code;
        private double close;
        private int timeRank;
        private int cosRank;

    }

}
