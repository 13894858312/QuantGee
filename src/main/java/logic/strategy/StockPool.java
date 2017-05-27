//package logic.strategy;
//
//import logic.tools.DateHelper;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//
///**
// * 股票池
// * Created by Mark.W on 2017/3/29.
// */
//public class StockPool {
//
//    private StrategyInputVO strategyInputVO; //用于判断该股票池是否可以继续被复用
//
//    private ArrayList<BaseCumulativeYieldPO> blockBaseRaito;
//
//    private HashMap<String, Stock> stocksMap = new HashMap<>();       //key是股票code
//    private ArrayList<Stock> stocksList = new ArrayList<>();
//
//    private int tradeDays;   //时间区间內的交易日数，即投资天数
//    private int startIndex;     //indexStocks的开始下标
////    private int stockPoolSize;  //股票池的大小
//
//    private BlockType blockType;
//    private int holdingStockNum;
//    private ArrayList<StockPO> indexStocks = new ArrayList<>(); //stockPO size最大的stock作为标杆
//
//    public StockPool(StrategyInputVO strategyInputVO) {
//        this.strategyInputVO = strategyInputVO;
//
//        this.initStocks(strategyInputVO);
//
//        this.tradeDays = indexStocks.size();
//        this.startIndex = this.stocksMap.get(indexStocks.get(0).getStockCode()).getStartIndex();
//        this.tradeDays = this.stocksMap.get(indexStocks.get(0).getStockCode()).getStockSize();
//
//        //确定持有股票的数量
//        if(strategyInputVO.ratio > 0) {
//            holdingStockNum = (int)(stocksList.size() * strategyInputVO.ratio);
//        } else {
//            holdingStockNum = strategyInputVO.holdingStockNum;
//        }
//
//
//        if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
//            blockType = strategyInputVO.blockType;
//        }
//
//        //如果是板块 初始化基准收益率
//        if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK
//                && strategyInputVO.blockType != null) {
//            this.blockBaseRaito = this.stockDataDao.getBaseYieldByBlockName(SwitchBlockType.getBlockName(strategyInputVO.blockType),
//                    DateHelper.getInstance().dateTransToString(this.strategyInputVO.startDate),
//                    DateHelper.getInstance().dateTransToString(this.strategyInputVO.endDate));
//        }
//    }
//
//    /**
//     * 根据股票代码和时间获取股票数据
//     * @param stockCode stockCode
//     * @param date date
//     * @return StockPO
//     */
//    public StockPO getStockPOByCodeAndDate(String stockCode, String date) {
//       Stock temp = this.stocksMap.get(stockCode);
//       if(temp != null) {
//           return temp.getStockByDate(date);
//       }
//
//       return null;
//    }
//
//    /**
//     * 根据股票代码和时间获取股票数据
//     * @param stockCode stockCode
//     * @return Stock
//     */
//    public Stock getStockByCode(String stockCode) {
//        return this.stocksMap.get(stockCode);
//    }
//
//
//    /**
//     * 初始化股票池的股票信息
//     * @param strategyInputVO strategyInputVO
//     */
//    private void initStocks(StrategyInputVO strategyInputVO) {
//
//        //根据特定股票板块构造股票池
//        Date sd = DateHelper.getInstance().formerNTradeDay(strategyInputVO.startDate, strategyInputVO.returnPeriod);
//        //时间范围之前的returnPeriod天的数据也需要拿
//        String s = DateHelper.getInstance().dateTransToString(sd);
//        String e = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);
//
//        if(DateHelper.getInstance().dateOutOfRange(sd)) {
//            this.stocksMap = null;
//        } else {
//            ArrayList<ArrayList<StockPO>> allStockPOs = new ArrayList<>();
//
//            if(strategyInputVO.strategyInputType == StrategyInputType.ALL) {
//                //选择所有股票构造股票池
//                allStockPOs = this.stockDataDao.getAllStockPO(s, e, this.strategyInputVO.notST);
//            } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
//                //选择指定板块股票构造股票池
//                allStockPOs = this.stockDataDao.getStockPOsByBlockName(s, e, SwitchBlockType.getBlockName(strategyInputVO.blockType), this.strategyInputVO.notST);
//                System.out.println(SwitchBlockType.getBlockName(strategyInputVO.blockType));
//            } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_STOCKS) {
//                //选择指定股票构造股票池
//                for(int i=0; i<strategyInputVO.stockNames.size(); ++i) {
//                    ArrayList<StockPO> stockPOS = this.stockDataDao.getStockPOsByTimeInterval(s, e, strategyInputVO.stockNames.get(i), this.strategyInputVO.notST);
//                    if(stockPOS != null && stockPOS.size() != 0) {
//                        allStockPOs.add(stockPOS);
//                    }
//                }
//            }
//
//            this.initStocksFromData(allStockPOs);
//        }
//    }
//
//
//    /**
//     * 初始化list和map
//     * 同时初始化indexStocks
//     * @param allStockPOs 从数据层获取的po
//     */
//    public void initStocksFromData(ArrayList<ArrayList<StockPO>> allStockPOs) {
//
//        int index = 0;          //记录size最大的下标index
//        for(int i=0; i<allStockPOs.size(); ++i) {
//            if(allStockPOs.get(i) != null && allStockPOs.get(i).size() != 0) {
//                Stock stock = new Stock(this.strategyInputVO.startDate, allStockPOs.get(i));
//                //如果该股票各项数据都有 才加入到股票池
//                if(stock.getBeforeStockPO() != null && stock.getStartDateStockPO() != null && stock.getYesterdayStock() != null) {
//                    this.stocksMap.put(allStockPOs.get(i).get(0).getStockCode(), stock);           //初始化map
//                    this.stocksList.add(stock);                                                 //初始化list
////                this.stockPoolSize ++;
//
//                    if(allStockPOs.get(i).size() > allStockPOs.get(index).size()) {           //用来确定indexStock
//                        index = i;
//                    }
//                }
//            }
//        }
//
//        this.indexStocks = allStockPOs.get(index);
//    }
//
//
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
//            cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(DateHelper.getInstance().stringTransToDate(blockBaseRaito.get(i).getTime()),
//                    blockBaseRaito.get(i).getBaseRatio()/100));
//        }
//
//        return  cumulativeYieldGraphDataVOS;
//    }
//
//    public Date getStartDate() {
//        return strategyInputVO.startDate;
//    }
//
//    public Date getEndDate() {
//        return strategyInputVO.endDate;
//    }
//
//    public ArrayList<Stock> getStocksList() {
//        return stocksList;
//    }
//
//    public int getTradeDays() {
//        return tradeDays;
//    }
//
//    public int getStartIndex() {
//        return startIndex;
//    }
//
//    public StrategyInputVO getStrategyInputVO() {
//        return strategyInputVO;
//    }
//
//    public int getHoldingStockNum() {
//        return holdingStockNum;
//    }
//
//    public BlockType getBlockType() {
//        return blockType;
//    }
//
//    public ArrayList<StockPO> getIndexStocks() {
//        return indexStocks;
//    }
//}
//
