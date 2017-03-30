package logic.strategy;

import dataDao.StockDataDao;
import logic.tools.DateHelper;
import mock.MockStockData;
import po.StockPO;
import vo.CumulativeYieldGraphDataVO;
import vo.StrategyInputType;
import vo.StrategyInputVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 股票池
 * Created by Mark.W on 2017/3/29.
 */
public class StockPool {

    private StockDataDao stockDataDao;

    private ArrayList<StockInfo> stockInfos;
    private Date startDate;
    private Date endDate;
    private int holdingPeriod;  //持有期
    private int returnPeriod;    //形成期
    private int holdingStockNum;  //每个持有期持有的股票数量

    private  ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS;  //每天的收益率
    private ArrayList<String> holdingStockCodes;


    public StockPool(StrategyInputVO strategyInputVO) {
        this.stockDataDao = new MockStockData();

        this.startDate = DateHelper.getInstance().getNextFirstTradeDay(strategyInputVO.startDate);
        this.endDate = strategyInputVO.endDate;
        this.holdingPeriod = strategyInputVO.holdingPeriod;
        this.returnPeriod = strategyInputVO.returnPeriod;
        this.holdingStockNum = strategyInputVO.holdingStockNum;

        this.initStockInfos(strategyInputVO);

        this.cumulativeYieldGraphDataVOS = new ArrayList<>();
        this.holdingStockCodes = new ArrayList<>();
    }


    /**
     *  执行回测的主程序
     */
    public void start() {
        this.initHoldingStockOnfirstRun();

         Date temp = startDate;
         int index = 0;     //记录是否达到一个holdingPeriod的index

         while(!DateHelper.getInstance().dateTransToString(temp).equals(DateHelper.getInstance().dateTransToString(endDate))) {
             if(index == this.holdingPeriod) { //若达到holdingPeriod index置0 同时进行rebalance
                 index = 0;
                 this.rebalance(temp);

             } else {
                 index ++;
             }

             this.calculateHoldingStockYield(temp); //计算收益
             temp = DateHelper.getInstance().nextTradeDay(temp);
         }

    }

    /**
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * @param date 日期
     */
    public void rebalance(Date date) {

    }

    /**
     * 计算持有股票每天的收益，并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    public void calculateHoldingStockYield(Date date) {

    }

    /**
     * 在第一次运行时 确定持有的股票
     */
    private void initHoldingStockOnfirstRun() {
        ArrayList<StockYield> stockYields = new ArrayList<>();
        for(int i=0; i<stockInfos.size(); ++i) {
            StockPO before = stockInfos.get(i).getBeforeStockPO();
            StockPO now = stockInfos.get(i).getStockByDate(DateHelper.getInstance().formerTradeDay(startDate));

            if(now == null || before == null) {
                continue;
            }

            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (now.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(now.getStockCode(), yield));
        }

        this.initTopNStocks(stockYields);
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum 作为持有的股票
     * @param stockYields stockYields
     */
    private void initTopNStocks(ArrayList<StockYield> stockYields) {

    }


    /**
     * 初始化股票
     * @param stockInfos ArrayList<StockInfo>
     */
    private void setStockInfos(ArrayList<StockInfo> stockInfos) {
        this.stockInfos = stockInfos;
    }

    /**
     * 将数组转换为arraylist 初始化股票
     * @param stockPOS 从数据层获取的po
     */
    private void setStockInfos(ArrayList<StockPO>[] stockPOS) {
        this.stockInfos = new ArrayList<>();

        for(int i=0; i<stockPOS.length; ++i) {
            if(stockPOS[i] != null && stockPOS[i].size() != 0) {
                this.stockInfos.add(new StockInfo(startDate, stockPOS[i].get(0).getStockCode(), stockPOS[i]));
            }
        }
    }

    /**
     * 初始化股票池
     * @param strategyInputVO strategyInputVO
     */
    private void initStockInfos(StrategyInputVO strategyInputVO) {

        if(strategyInputVO.strategyInputType == StrategyInputType.ALL) {
            //选择所有股票构造股票池
            ArrayList<StockPO>[] stocks = this.stockDataDao.getAllStockPO();
            this.setStockInfos(stocks);

        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
            //根据特定股票板块构造股票池
            Date sd = DateHelper.getInstance().formerNTradeDay(startDate, returnPeriod);
            //时间范围之前的returnPeriod天的数据也需要拿

            if(DateHelper.getInstance().dateOutOfRange(sd)) {
                 this.stockInfos = null;
            } else {

                String s = DateHelper.getInstance().dateTransToString(sd);
                String e = DateHelper.getInstance().dateTransToString(endDate);

                ArrayList<StockPO>[] stocks = this.stockDataDao.getStockPOsByBlockName(s, e, strategyInputVO.blockName);
                this.setStockInfos(stocks);
            }

        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_STOCKS) {
            //选定特定股票构造股票池
            Date sd = DateHelper.getInstance().formerNTradeDay(startDate, returnPeriod);
            //时间范围之前的returnPeriod天的数据也需要拿

            if(DateHelper.getInstance().dateOutOfRange(sd)) {
                this.stockInfos = null;
            } else {

                String s = DateHelper.getInstance().dateTransToString(sd);
                String e = DateHelper.getInstance().dateTransToString(endDate);

                ArrayList<StockInfo> stockInfos = new ArrayList<>();
                for(int i=0; i<strategyInputVO.stockNames.size(); ++i) {
                    ArrayList<StockPO> stockPOS = this.stockDataDao.getStockPOsByTimeInterval(s, e, strategyInputVO.stockNames.get(i));

                    if(stockPOS != null && stockPOS.size() != 0) {
                        stockInfos.add(new StockInfo(startDate, stockPOS.get(0).getStockCode(), stockPOS));
                    }
                }

                this.setStockInfos(stockInfos);
            }
        }
    }

    public ArrayList<CumulativeYieldGraphDataVO> getCumulativeYieldGraphDataVOS() {
        return cumulativeYieldGraphDataVOS;
    }
}
