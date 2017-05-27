package logic.strategy;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;
import logic.tools.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import vo.strategy.CumulativeYieldGraphDataVO;
import vo.strategy.StrategyBackTestInputVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 股票池
 * Created by Mark.W on 2017/3/29.
 */
public class StockPool {

    @Autowired
    private StockInfoDAO stockInfoDAO;

    private StrategyBackTestInputVO strategyBackTestInputVO; //用于判断该股票池是否可以继续被复用

//    private ArrayList<BaseCumulativeYieldPO> blockBaseRaito;

    private HashMap<String, LogicStock> stocksMap = new HashMap<>();       //key是股票code
    private ArrayList<LogicStock> stocksList = new ArrayList<>();

    private int tradeDays;   //时间区间內的交易日数，即投资天数
    private int startIndex;     //indexStocks的开始下标
//    private int stockPoolSize;  //股票池的大小

    private String blockType;
    private int holdingStockNum;
    private ArrayList<Stock> indexStocks = new ArrayList<>(); //stockPO size最大的stock作为标杆

    public StockPool(StrategyBackTestInputVO strategyBackTestInputVO) {
        this.strategyBackTestInputVO = strategyBackTestInputVO;

        this.initStocks(strategyBackTestInputVO);

        this.tradeDays = indexStocks.size();
        this.startIndex = this.stocksMap.get(indexStocks.get(0).getStockId()).getStartIndex();
        this.tradeDays = this.stocksMap.get(indexStocks.get(0).getStockId()).getStockSize();

        //确定持有股票的数量
        if(strategyBackTestInputVO.ratio > 0) {
            holdingStockNum = (int)(stocksList.size() * strategyBackTestInputVO.ratio);
        } else {
            holdingStockNum = strategyBackTestInputVO.holdingStockNum;
        }


        if(strategyBackTestInputVO.strategyInputType == 0) {
            blockType = strategyBackTestInputVO.blockType;
        }

        //如果是板块 初始化基准收益率
//        if(strategyBackTestInputVO.strategyInputType == 0 && strategyBackTestInputVO.blockType != null) {
//            this.blockBaseRaito = this.stockDataDao.getBaseYieldByBlockName(strategyBackTestInputVO.blockType,
//                   strategyBackTestInputVO.startDate, this.strategyBackTestInputVO.endDate);
//        }
    }

    /**
     * 根据股票代码和时间获取股票数据
     * @param stockCode stockCode
     * @param date date
     * @return Stock
     */
    public Stock getStockPOByCodeAndDate(String stockCode, String date) {
       LogicStock temp = this.stocksMap.get(stockCode);
       if(temp != null) {
           return temp.getStockByDate(date);
       }

       return null;
    }

    /**
     * 根据股票代码和时间获取股票数据
     * @param stockCode stockCode
     * @return LogicStock
     */
    public LogicStock getStockByCode(String stockCode) {
        return this.stocksMap.get(stockCode);
    }


    /**
     * 初始化股票池的股票信息
     * @param inputVO inputVO
     */
    private void initStocks(StrategyBackTestInputVO inputVO) {

        String s = DateHelper.formerNTradeDay(inputVO.startDate, inputVO.returnPeriod);
        //时间范围之前的returnPeriod天的数据也需要拿
        String e = inputVO.endDate;

        ArrayList<ArrayList<Stock>> allStocks = new ArrayList<>();

        //选择指定板块股票构造股票池
        if(inputVO.strategyInputType == 0) {
            Iterator<String> codes = stockInfoDAO.getAllStockCodesByBlock(inputVO.blockType);
            while(codes.hasNext()) {
                Iterator<Stock> stocks = stockInfoDAO.getStockInfo(codes.next(), s, e);
                allStocks.add(transToList(stocks));
            }
        //选择指定股票构造股票池
        } else if(inputVO.strategyInputType == 1) {
            for(int i = 0; i< inputVO.stockNames.size(); ++i) {
                Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.stockNames.get(i), s, e);
                allStocks.add(transToList(stocks));
            }
        }

        this.initStocksFromData(allStocks);
    }


    private ArrayList<Stock> transToList(Iterator<Stock> stocks) {
        ArrayList<Stock> result = new ArrayList<>();
        while(stocks.hasNext()) {
            result.add(stocks.next());
        }
        return result;
    }



    /**
     * 初始化list和map
     * 同时初始化indexStocks
     * @param allStockPOs 从数据层获取的po
     */
    public void initStocksFromData(ArrayList<ArrayList<Stock>> allStockPOs) {

        int index = 0;          //记录size最大的下标index
        for(int i=0; i<allStockPOs.size(); ++i) {
            if(allStockPOs.get(i) != null && allStockPOs.get(i).size() != 0) {
                LogicStock logicStock = new LogicStock(this.strategyBackTestInputVO.startDate, allStockPOs.get(i));
                //如果该股票各项数据都有 才加入到股票池
                if(logicStock.getBeforeStock() != null && logicStock.getStartDateStockPO() != null && logicStock.getYesterdayStock() != null) {
                    this.stocksMap.put(allStockPOs.get(i).get(0).getStockId(), logicStock);           //初始化map
                    this.stocksList.add(logicStock);                                                 //初始化list
//                this.stockPoolSize ++;

                    if(allStockPOs.get(i).size() > allStockPOs.get(index).size()) {           //用来确定indexStock
                        index = i;
                    }
                }
            }
        }

        this.indexStocks = allStockPOs.get(index);
    }


//    /**
//     * 获取指定板块基准收益率
//     * @return ArrayList<CumulativeYieldGraphDataVO>
//     */
//    public ArrayList<CumulativeYieldGraphDataVO> getBlockBaseRaito() {
//        assert (blockBaseRaito != null && blockBaseRaito.size() != 0) : "StockPool.getBlockBaseRaito.blockBaseRaito异常";
//
//        ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS = new ArrayList<>();
//
//        for(int i=0; i<this.blockBaseRaito.size(); ++i) {
//            cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(DateHelper.getInstance().stringTransToDate(blockBaseRaito.get(i).getDate()),
//                    blockBaseRaito.get(i).getBaseRatio()/100));
//        }
//
//        return  cumulativeYieldGraphDataVOS;
//    }

    public String getStartDate() {
        return strategyBackTestInputVO.startDate;
    }

    public String getEndDate() {
        return strategyBackTestInputVO.endDate;
    }

    public ArrayList<LogicStock> getStocksList() {
        return stocksList;
    }

    public int getTradeDays() {
        return tradeDays;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public StrategyBackTestInputVO getStrategyBackTestInputVO() {
        return strategyBackTestInputVO;
    }

    public int getHoldingStockNum() {
        return holdingStockNum;
    }

    public String getBlockType() {
        return blockType;
    }

    public ArrayList<Stock> getIndexStocks() {
        return indexStocks;
    }
}

