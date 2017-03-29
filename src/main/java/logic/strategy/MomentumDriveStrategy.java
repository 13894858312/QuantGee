package logic.strategy;

import dataDao.StockDataDao;
import logic.tools.DateHelper;
import mock.MockStockData;
import po.StockPO;
import vo.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark.W on 2017/3/29.
 * 动量策略
 */
public class MomentumDriveStrategy implements Strategy {

    private StockDataDao stockDataDao;

    public MomentumDriveStrategy() {
        this.stockDataDao = new MockStockData();
    }

    @Override
    public CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StrategyInputVO strategyInputVO) {

        HashMap<String, StockInfo> stocks = new HashMap<>();






        return null;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        return null;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyInputVO strategyInputVO) {
        return null;
    }

    private ArrayList<StockPO> getStockPOs(StrategyInputVO strategyInputVO) {
        ArrayList<StockPO> stockPOS = null;

        if(strategyInputVO.strategyInputType == StrategyInputType.ALL) {

                                                    //这里添加获取所有股票信息的代码
        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {

            String s = DateHelper.getInstance().dateTransToString(strategyInputVO.startDate);
            String e = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);
            stockPOS = this.stockDataDao.getStockPOsByBlockName(s, e, strategyInputVO.blockName);

        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_STOCKS) {


        }

        return stockPOS;
    }
}
