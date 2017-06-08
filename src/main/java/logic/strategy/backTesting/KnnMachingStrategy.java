package logic.strategy.backTesting;

import bean.Stock;
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
                                                     String formerRPeriodDate, String formerHPeriodDate, ArrayList<String> dates) {

        if (dates.size() == 0) {
            return null;
        }

        String today = dates.get(1);

        for(int i = 0; i<stockPool.getStocksList().size(); ++i) {
            Stock formerStock = stockPool.getStocksList().get(i).getStockByDate(formerRPeriodDate);
            if (formerStock == null){
                continue;
            }
            double predictPrice = knnPredict(stockPool, formerStock.getCode(), today);
        }


        return null;
    }

    private double knnPredict(StockPool stockPool, String code, String today) {
        return 0;
    }
}
