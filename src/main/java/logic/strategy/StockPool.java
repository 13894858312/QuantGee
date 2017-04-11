package logic.strategy;

import dataDao.StockDataDao;
import logic.tools.DateHelper;
import mock.MockStockData;
import po.StockPO;
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

    public StockPool(StrategyInputVO strategyInputVO) {
        this.stockDataDao = new MockStockData();

        this.startDate = DateHelper.getInstance().getNextFirstTradeDay(strategyInputVO.startDate);
        this.endDate = strategyInputVO.endDate;

        this.initStockInfos(strategyInputVO);
    }

    /**
     * 获取stockpo size最大的stockinfo 作为标杆
     * @return StockInfo
     */
    public ArrayList<StockPO> getIndexStocks() {
        int index = 0;
        for(int i=0; i<this.stockInfos.size(); ++i) {
            if(this.stockInfos.get(i).getStockSize() > this.stockInfos.get(index).getStockSize()) {
                index = i;
            }
        }

        return this.stockInfos.get(index).getStockPOS();
    }

    /**
     * 根据股票代码和时间获取股票数据
     * @param stockCode stockCode
     * @param date date
     * @return StockPO
     */
    public StockPO findSpecificStock(String stockCode, Date date) {
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
    public StockPO findStartDateStock(String stockCode) {
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
    public void setStockInfos(ArrayList<StockInfo> stockInfos) {
        this.stockInfos = stockInfos;
    }

    /**
     * 将数组转换为arraylist 初始化股票
     * @param stockPOS 从数据层获取的po
     */
    public void setStockInfosFromDataDao(ArrayList<ArrayList<StockPO>> stockPOS) {

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
            Date sd = DateHelper.getInstance().formerNTradeDay(startDate, strategyInputVO.returnPeriod);
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
            Date sd = DateHelper.getInstance().formerNTradeDay(startDate, strategyInputVO.returnPeriod);
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ArrayList<StockInfo> getStockInfos() {
        return stockInfos;
    }
}
