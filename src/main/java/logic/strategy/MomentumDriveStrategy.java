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

        StockPool stockPool = this.initStockPool(strategyInputVO);



        return null;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod) {
        StockPool stockPool = this.initStockPool(strategyInputVO);
        return null;
    }

    @Override
    public YieldHistogramGraphVO getYieldHistogramGraphInfo(StrategyInputVO strategyInputVO) {
        StockPool stockPool = this.initStockPool(strategyInputVO);
        return null;
    }


    /**
     * 初始化股票池
     * @param strategyInputVO 策略输入
     * @return StockPool
     */
    private StockPool initStockPool(StrategyInputVO strategyInputVO) {
        StockPool stockPool = null;

        if(strategyInputVO.strategyInputType == StrategyInputType.ALL) {
            //选择所有股票构造股票池
            ArrayList<StockPO>[] stocks = this.stockDataDao.getAllStockPO();
            stockPool = new StockPool(stocks);

        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
            //根据特定股票板块构造股票池
            String s = DateHelper.getInstance().dateTransToString(strategyInputVO.startDate);
            String e = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);

            ArrayList<StockPO>[] stocks = this.stockDataDao.getStockPOsByBlockName(s, e, strategyInputVO.blockName);
            stockPool = new StockPool(stocks);

        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_STOCKS) {
            //选定特定股票构造股票池
            String s = DateHelper.getInstance().dateTransToString(strategyInputVO.startDate);
            String e = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);

            ArrayList<StockInfo> stockInfos = new ArrayList<>();
            for(int i=0; i<strategyInputVO.stockNames.size(); ++i) {
                ArrayList<StockPO> stockPOS = this.stockDataDao.getStockPOsByTimeInterval(s, e, strategyInputVO.stockNames.get(i));

                if(stockPOS != null && stockPOS.size() != 0) {
                    stockInfos.add(new StockInfo(strategyInputVO.startDate, stockPOS.get(0).getStockCode(), stockPOS));
                }
            }

            stockPool = new StockPool(stockInfos);
        }

        return stockPool;
    }
}
