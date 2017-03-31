package logic.strategy;

import dataDao.StockDataDao;
import logic.tools.DateHelper;
import mock.MockStockData;
import po.StockPO;
import vo.BaseCumulativeYieldGraphDataVO;
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
    private  ArrayList<BaseCumulativeYieldGraphDataVO> baseCumulativeYieldGraphDataVOS; //基准收益率
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
        this.baseCumulativeYieldGraphDataVOS = new ArrayList<>();
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
     * 在第一次运行时 确定持有的股票
     */
    private void initHoldingStockOnfirstRun() {
        ArrayList<StockYield> stockYields = new ArrayList<>();

        for(int i=0; i<stockInfos.size(); ++i) {
            StockPO before = stockInfos.get(i).getBeforeStockPO();
            StockPO yesterday = stockInfos.get(i).getStockByDate(DateHelper.getInstance().formerTradeDay(startDate));

            if(yesterday == null || before == null) {
                continue;
            }

            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        this.initTopNStocks(stockYields);
    }

    /**
     * 从所有股票的收益率中选取前holdingStockNum作为持有的股票
     * @param stockYields stockYields
     */
    private void initTopNStocks(ArrayList<StockYield> stockYields) {
        //冒泡排序 排序holdingStockNum次 得到收益前holdingStockNum的股票

        for(int i=stockYields.size()-1;i>stockYields.size()-this.holdingStockNum-1; i--) {
            for(int j=0; j<i; ++ j) {
                if(stockYields.get(j).getYield() < stockYields.get(j+1).getYield()) {
                    StockYield temp = stockYields.get(j);
                    stockYields.set(j, new StockYield(stockYields.get(j+1).getStockCode(), stockYields.get(j+1).getYield()));
                    stockYields.set(j+1, temp);
                }
            }
        }

        //确定持有股票的代码
        for(int i=0; i<this.holdingStockNum; ++i) {
            this.holdingStockCodes.add(stockYields.get(i).getStockCode());
        }
    }

    /**
     * 计算指定日期所有股票形成期收益，并获取前holdingStockNum个的股票代码
     * @param date 日期
     */
    private void rebalance(Date date) {
        ArrayList<StockYield> stockYields = new ArrayList<>();

        Date beforeDate = DateHelper.getInstance().formerNTradeDay(date, returnPeriod);

        for(int i=0; i<stockInfos.size(); ++i) {
            StockPO before = stockInfos.get(i).getStockByDate(beforeDate);
            StockPO yesterday = stockInfos.get(i).getStockByDate(DateHelper.getInstance().formerTradeDay(date));

            if(yesterday == null || before == null) {
                continue;
            }

            //计算收益，昨天的收盘价- returnPeriod天前的收盘价)/ returnPeriod天前的收盘价
            double yield = (yesterday.getADJ()-before.getADJ())/before.getADJ();

            stockYields.add(new StockYield(yesterday.getStockCode(), yield));
        }

        this.initTopNStocks(stockYields);

    }

    /**
     * 计算持有股票每天的收益，并将数据存入cumulativeYieldGraphDataVOS
     * @param date 日期
     */
    private void calculateHoldingStockYield(Date date) {
        int yieldNum = 0; //计算该日期有多少未停牌，用于计算平均值
        double yield = 0;

        for(int i=0; i<this.holdingStockCodes.size(); ++i) {
            StockPO stockPO = this.findSpecificStock(this.holdingStockCodes.get(i), date);
            StockPO startDatePO = this.findStartDateStock(this.holdingStockCodes.get(i));

            if(stockPO == null || startDatePO == null) {
                continue;
            }

            yieldNum ++;

            //计算累计收益率
             yield += (stockPO.getADJ()-startDatePO.getADJ())/startDatePO.getADJ();
        }

        this.cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(date,yield/yieldNum));

    }

    /**
     * 根据股票代码和时间获取股票数据
     * @param stockCode stockCode
     * @param date date
     * @return StockPO
     */
    private StockPO findSpecificStock(String stockCode, Date date) {
        for(int i=0; i<this.stockInfos.size(); ++i) {
            if(stockInfos.get(i).getStockCode().equals(stockCode)) {
                StockPO stockPO = stockInfos.get(i).getStockByDate(date);
                return stockPO;
            }
        }

        return null;
    }

    /**
     * 根据股票代码获取开始日期那一天的股票信息
     * @param stockCode 股票代码
     * @return StockPO
     */
    private StockPO findStartDateStock(String stockCode) {
        for(int i=0; i<this.stockInfos.size(); ++i) {
            if(stockInfos.get(i).getStockCode().equals(stockCode)) {
                StockPO po = stockInfos.get(i).getStartDateStockPO();
                return po;
            }
        }

        return null;
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
    private void setStockInfosFromDataDao(ArrayList<ArrayList<StockPO>> stockPOS) {

        this.stockInfos = new ArrayList<>();

        for(int i=0; i<stockPOS.size(); ++i) {
            if(stockPOS.get(i) != null && stockPOS.get(i).size() != 0) {
                this.stockInfos.add(new StockInfo(startDate, stockPOS.get(i).get(0).getStockCode(), stockPOS.get(i)));
            }
        }
    }

    /**
     * 初始化股票池的股票信息
     * @param strategyInputVO strategyInputVO
     */
    private void initStockInfos(StrategyInputVO strategyInputVO) {

        if(strategyInputVO.strategyInputType == StrategyInputType.ALL) {
            //选择所有股票构造股票池
            ArrayList<ArrayList<StockPO>> stocks = this.stockDataDao.getAllStockPO();
            this.setStockInfosFromDataDao(stocks);

        } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
            //根据特定股票板块构造股票池
            Date sd = DateHelper.getInstance().formerNTradeDay(startDate, returnPeriod);
            //时间范围之前的returnPeriod天的数据也需要拿

            if(DateHelper.getInstance().dateOutOfRange(sd)) {
                 this.stockInfos = null;
            } else {

                String s = DateHelper.getInstance().dateTransToString(sd);
                String e = DateHelper.getInstance().dateTransToString(endDate);

                ArrayList<ArrayList<StockPO>> stocks = this.stockDataDao.getStockPOsByBlockName(s, e, strategyInputVO.blockName);
                this.setStockInfosFromDataDao(stocks);
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

    public ArrayList<BaseCumulativeYieldGraphDataVO> getBaseCumulativeYieldGraphDataVOS() {
        return baseCumulativeYieldGraphDataVOS;
    }
}
