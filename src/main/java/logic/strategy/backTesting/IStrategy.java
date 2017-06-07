package logic.strategy.backTesting;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略的接口 采用策略模式
 */
public interface IStrategy {

    /**
     * 获取每次调仓后应该持有的股票信息
     * @param stockPool 股票池
     * @param beforeDate 形成期第一天的时间
     * @param today 调仓当天的时间
     * @param dates 下一个持有期每天的日期
     * @return ArrayList<String>
     */
    ArrayList<String> getRebalancedStockCodes(StockPool stockPool, int holdingStockNum, String beforeDate, String today, ArrayList<String> dates);
}
