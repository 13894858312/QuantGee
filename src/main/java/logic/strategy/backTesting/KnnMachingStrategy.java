package logic.strategy.backTesting;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/6/8.
 * KNN机器学习策略
 */
@Service("3")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KnnMachingStrategy implements IStrategy {
    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate, String formerHPeriod, ArrayList<String> dates) {

        return null;
    }
}
