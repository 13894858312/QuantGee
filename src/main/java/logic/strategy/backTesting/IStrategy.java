package logic.strategy.backTesting;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略的接口
 * 采用策略模式
 */
public interface IStrategy {

    /**
     * 获取每次调仓后应该持有的股票信息
     * @param stockPool 股票池
     * @param holdingStocks 当前持有的股票
     * @param holdingStockNum 持有的股票数量
     * @param formerRPeriodDate 上一个形成期的日期
     * @param formerHPeriodDate 上一个持有期的日期
     * @param nextDates 下一个持有期每天的日期 get0是昨天日期
     * @param formerDates 前一个训练周期的时间 用于knn算法
     * @return ArrayList<String>
     */
    ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                              String formerRPeriodDate, String formerHPeriodDate,
                                              ArrayList<String> nextDates, ArrayList<String> formerDates);

    /**
     * 获取策略的类型
     * @return 0动量策略 1均值回归 2双均线策略 3羊驼策略 4KNN机器学习策略
     */
    int getStrategyType();
}
