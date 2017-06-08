package logic.strategy.backTesting;

import DAO.stockInfoDAO.StockInfoDAO;
import bean.Stock;
import logic.tools.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.stock.LineVO;
import vo.strategy.StrategyBackTestInputVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 股票池
 * Created by Mark.W on 2017/3/29.
 */
@Service
public class StockPool {

    @Autowired
    private StockInfoDAO stockInfoDAO;

    private StrategyBackTestInputVO inputVO;

    private int stockPoolType;
    private String startDate;
    private String endDate;

    private HashMap<String, LogicStock> stocksMap;       //key是股票code
    private ArrayList<LogicStock> stocksList;
    private int tradeDays;                                      //时间区间內的交易日数，即投资天数

    private ArrayList<Stock> indexStocks;                       //stockPO size最大的stock作为标杆
    private int startIndex;                                    //indexStocks的开始下标

    public StockPool() {}

    public void initStockPool(StrategyBackTestInputVO inputVO) {
        this.inputVO = inputVO;
        this.stockPoolType = inputVO.getStockPoolType();
        this.startDate = inputVO.getStartDate();
        this.endDate = inputVO.getEndDate();

        this.initStocks();

        this.tradeDays = indexStocks.size() - startIndex;
        this.startIndex = this.stocksMap.get(indexStocks.get(0).getCode()).getStartIndex();
    }

    /**
     * 初始化股票池的股票信息
     */
    private void initStocks() {
        //时间范围之前的returnPeriod天的数据也需要拿
        String s = DateHelper.formerNTradeDay(inputVO.getStartDate(), inputVO.getReturnPeriod());
        String e = inputVO.getEndDate();

        ArrayList<ArrayList<Stock>> allStocks = new ArrayList<>();

        //选择指定 板块 构造股票池
        if(inputVO.getStockPoolType() == 0) {
            Iterator<String> codes = stockInfoDAO.getAllStockCodesByBlock(inputVO.getBlockType());
            while(codes.hasNext()) {
                Iterator<Stock> stocks = stockInfoDAO.getStockInfo(codes.next(), s, e);
                allStocks.add(transToList(stocks));
            }
            //选择指定 股票 构造股票池
        } else if(inputVO.getStockPoolType() == 1) {
            for(int i = 0; i< inputVO.getStockCodes().size(); ++i) {
                Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.getStockCodes().get(i), s, e);
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
     * @param allStocks 从数据层获取的po
     */
    public void initStocksFromData(ArrayList<ArrayList<Stock>> allStocks) {
        stocksMap = new HashMap<>();
        stocksList = new ArrayList<>();

        int index = 0;                       //记录size最大的下标index
        for(int i = 0; i< allStocks.size(); ++i) {
            if(allStocks.get(i) != null && allStocks.get(i).size() != 0) {
                LogicStock logicStock = new LogicStock(this.inputVO.getStartDate(), allStocks.get(i));
                //如果该股票各项数据都有 才加入到股票池
                if(logicStock.getBeforeStock() != null && logicStock.getStartDateStock() != null) {
                    this.stocksMap.put(allStocks.get(i).get(0).getCode(), logicStock);           //初始化map
                    this.stocksList.add(logicStock);                                                 //初始化list

                    if(allStocks.get(i).size() > allStocks.get(index).size()) {           //用来确定indexStock
                        index = i;
                    }
                }
            }
        }

        this.indexStocks = allStocks.get(index);
    }


    /**
     * 根据股票代码和时间获取股票数据
     * @param stockCode stockCode
     * @param date date
     * @return Stock
     */
    public Stock getStockByCodeAndDate(String stockCode, String date) {
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
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

    public StrategyBackTestInputVO getInputVO() {
        return inputVO;
    }

    public ArrayList<Stock> getIndexStocks() {
        return indexStocks;
    }

    public int getStockPoolType() {
        return stockPoolType;
    }

    /**
     * 获取指定板块基准收益率
     * @return ArrayList<LineVO>
     */
    public ArrayList<LineVO> getBlockBaseRaito() {
        ArrayList<LineVO> blockBaseRaito = new ArrayList<>();
        //如果是板块 初始化基准收益率
        if(inputVO.getStockPoolType() == 0 && inputVO.getBlockType() != null) {
            Iterator<Stock> stocks = stockInfoDAO.getStockInfo(inputVO.getBlockType(), inputVO.getStartDate(), this.inputVO.getEndDate());
            double initClose = stocks.next().getClose();
            while(stocks.hasNext()) {
                Stock stock = stocks.next();
                //数据均是百分数 所以需要 /100
                blockBaseRaito.add(new LineVO(stock.getDate(), (stock.getClose()-initClose)/initClose));
            }
        }
        return blockBaseRaito;
    }

    /**
     * 获取持有股票数量
     * @return holdingStockNum
     */
    public int getHoldingStockNum() {
        int holdingStockNum;

        //确定持有股票的数量
        if(inputVO.getRatio() > 0) {
            holdingStockNum = (int)(stocksList.size() * inputVO.getRatio());
        } else {
            holdingStockNum = inputVO.getHoldingStockNum();
        }
        return holdingStockNum;
    }

}

