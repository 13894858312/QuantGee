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
     * @return ArrayList<String>
     */
    ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                              String formerRPeriodDate, String formerHPeriodDate,ArrayList<String> nextDates);
}
