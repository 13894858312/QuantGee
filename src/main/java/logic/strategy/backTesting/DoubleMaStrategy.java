package logic.strategy.backTesting;

import bean.Stock;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import vo.stock.MaVO;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/6/7.
 * 双均线策略
 */
@Service("2")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DoubleMaStrategy implements IStrategy {

    //保存所有股票的N日平滑移动均线 code-data-mavo
    private HashMap<String, HashMap<String, MaVO>> allShortEmaLine = new HashMap<>();
    private HashMap<String, HashMap<String, MaVO>> allLongEmaLine = new HashMap<>();

    @Override
    public ArrayList<String> getRebalancedStockCodes(StockPool stockPool, ArrayList<LogicHoldingStock> holdingStocks, int holdingStockNum,
                                                     String formerRPeriodDate, String formerHPeriodDate, ArrayList<String> nextDates, ArrayList<String> formerDates) {
        if (nextDates.size() == 0) {return null;}

        String yesterday = nextDates.get(0);
        String today = nextDates.get(1);
        ArrayList<String> buyCodes = new ArrayList<>();
        ArrayList<String> sellCodes = new ArrayList<>();

        for (int i=0; i<stockPool.getStocksList().size(); ++i) {
            LogicStock stock = stockPool.getStocksList().get(i);
            boolean live = true;                     //持有期內每天的股票信息必须有 否则不持有该股票
            for (int j = 1; j < nextDates.size(); ++j) {
                Stock po = stock.getStockByDate(nextDates.get(j));
                if (po == null) {
                    live = false;
                    break;
                }
            }
            if (!live) {
                continue;
            }

            HashMap<String, MaVO> emaShortLine = allShortEmaLine.get(stock.getCode());
            HashMap<String, MaVO> emaLongLine = allLongEmaLine.get(stock.getCode());
            if (emaShortLine == null) {
                int shortReturnPeriod = stockPool.getInputVO().getShortReturnPeriod();
                emaShortLine = StrategyHelper.getEmaFromStockPool(stockPool, stock.getCode(),shortReturnPeriod);
                if (emaShortLine != null) {
                    allShortEmaLine.put(stock.getCode(),emaShortLine);
                } else {
                    continue;
                }

            }
            if (emaLongLine == null) {
                int longReturnPeriod = stockPool.getInputVO().getReturnPeriod();
                emaLongLine = StrategyHelper.getEmaFromStockPool(stockPool, stock.getCode(),longReturnPeriod);
                if (emaLongLine != null) {
                    allLongEmaLine.put(stock.getCode(), emaLongLine);
                } else {
                    continue;
                }
            }

            MaVO yesterdayShortEma = emaShortLine.get(yesterday);
            MaVO todayShortEma = emaShortLine.get(today);
            MaVO yesterdayLongEma = emaLongLine.get(yesterday);
            MaVO todayLongEma = emaLongLine.get(yesterday);

            if (yesterdayShortEma == null || todayShortEma == null || yesterdayLongEma == null || todayLongEma == null) {
                continue;
            }

            //时间短的均线在下方向上穿越时间长一点的均线，为“金叉”，反之为“死叉”。
            if (yesterdayShortEma.getMa() < yesterdayLongEma.getMa() && todayShortEma.getMa() > todayLongEma.getMa()) {
                buyCodes.add(stock.getCode());
            } else if (yesterdayShortEma.getMa() > yesterdayLongEma.getMa() && todayShortEma.getMa() < todayLongEma.getMa()) {
                sellCodes.add(stock.getCode());
            }
        }

        //得到收益前holdingStockNum的股票代码
        if (holdingStocks.size() > 0) {
            HashMap<String, LogicHoldingStock> hashMap = new HashMap<>();
            for (int i=0; i<holdingStocks.size(); ++i) {
                hashMap.put(holdingStocks.get(i).getStockCode(), holdingStocks.get(i));
            }

            for (int i=0; i<sellCodes.size(); ++i) {
                if (hashMap.get(sellCodes.get(i)) != null) {
                    hashMap.get(sellCodes.get(i)).setCanContinueHold(false);              //可以继续持有该股票
                }
            }
        }
        return buyCodes;
    }

    @Override
    public int getStrategyType() {
        return 2;
    }
}
