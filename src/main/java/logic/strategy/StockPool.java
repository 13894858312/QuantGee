package logic.strategy;

import data.StockData;
import dataDao.StockDataDao;
import logic.tools.DateHelper;
import logic.tools.SwitchBlockType;
import po.BaseCumulativeYieldPO;
import po.StockPO;
import vo.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * 股票池
 * Created by Mark.W on 2017/3/29.
 */
public class StockPool {

    private StockDataDao stockDataDao;

    private StrategyInputVO strategyInputVO; //用于判断该股票池是否可以继续被复用

    private ArrayList<BaseCumulativeYieldPO> blockBaseRaito;
    private ArrayList<StockInfo> stockInfos;
    private Date startDate;
    private Date endDate;

    private int tradeDays;   //时间区间內的交易日数，即投资天数
    private int startIndex;     //indexStocks的结束下标

    private BlockType blockType;
    private int holdingStockNum;
    private ArrayList<StockPO> indexStocks;

    public StockPool(StrategyInputVO strategyInputVO) {
        this.strategyInputVO = strategyInputVO;
        this.stockDataDao = new StockData();

        this.startDate = strategyInputVO.startDate;
        this.endDate = strategyInputVO.endDate;
        this.stockInfos = new ArrayList<>();

        this.initStockInfos(strategyInputVO);
        this.initIndexStocks();

        //确定持有股票的数量
        if(strategyInputVO.ratio > 0) {
            holdingStockNum = (int)(stockInfos.size() * strategyInputVO.ratio);
        } else {
            holdingStockNum = strategyInputVO.holdingStockNum;
        }


        if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
            blockType = strategyInputVO.blockType;
        }

        //如果是板块 初始化基准收益率
        if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK
                && strategyInputVO.blockType != null) {
            this.blockBaseRaito = this.stockDataDao.getBaseYieldByBlockName(SwitchBlockType.getBlockName(strategyInputVO.blockType),
                    DateHelper.getInstance().dateTransToString(this.startDate),  DateHelper.getInstance().dateTransToString(this.endDate));
        }
    }

    private void initIndexStocks() {
        int index = 0;
        for(int i=0; i<this.stockInfos.size(); ++i) {
            if(this.stockInfos.get(i).getStockSize() > this.stockInfos.get(index).getStockSize()) {
                index = i;
            }
        }

        this.startIndex = this.stockInfos.get(index).getStartIndex();
        this.tradeDays = this.stockInfos.get(index).getStockSize();

        this.indexStocks =  this.stockInfos.get(index).getStockPOS();
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
//
//    /**
//     * 根据时间获取板块基准收益率数据
//     * @param date date
//     * @return StockPO
//     */
//    public CumulativeYieldGraphDataVO findSpecificBlockBaseRatio(Date date) {
//
//        for(int i=0; i<this.blockBaseRaito.size(); ++i) {
//            int days = DateHelper.getInstance().calculateDaysBetween(date, this.blockBaseRaito.get(i).getDate());
//
//            if(days < 0) {
//               return null;
//            }
//            if(days == 0) {
//                return new CumulativeYieldGraphDataVO(date, this.blockBaseRaito.get(i).getBaseRatio());
//            }
//        }
//
//        return null;
//    }

    /**
     * 获取stockpo size最大的stockinfo 作为标杆
     * @return StockInfo
     */
    public ArrayList<StockPO> getIndexStocks() {
        return indexStocks;
    }

    /**
     * 将数组转换为arraylist 初始化股票
     * @param stockPOS 从数据层获取的po
     */
    public void setStockInfosFromDataDao(ArrayList<ArrayList<StockPO>> stockPOS) {

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

        //根据特定股票板块构造股票池
        Date sd = DateHelper.getInstance().formerNTradeDay(startDate, strategyInputVO.returnPeriod);
        //时间范围之前的returnPeriod天的数据也需要拿
        String s = DateHelper.getInstance().dateTransToString(sd);
        String e = DateHelper.getInstance().dateTransToString(endDate);

        if(DateHelper.getInstance().dateOutOfRange(sd)) {
            this.stockInfos = null;
        } else {
            if(strategyInputVO.strategyInputType == StrategyInputType.ALL) {
                //选择所有股票构造股票池
                ArrayList<ArrayList<StockPO>> stocks = this.stockDataDao.getAllStockPO(s, e);
                this.setStockInfosFromDataDao(stocks);

            } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {

                ArrayList<ArrayList<StockPO>> stocks = this.stockDataDao.getStockPOsByBlockName(s, e, SwitchBlockType.getBlockName(strategyInputVO.blockType));
                this.setStockInfosFromDataDao(stocks);

            } else if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_STOCKS) {

                for(int i=0; i<strategyInputVO.stockNames.size(); ++i) {
                    ArrayList<StockPO> stockPOS = this.stockDataDao.getStockPOsByTimeInterval(s, e, strategyInputVO.stockNames.get(i));

                    if(stockPOS != null && stockPOS.size() != 0) {
                        stockInfos.add(new StockInfo(startDate, stockPOS.get(0).getStockCode(), stockPOS));
                    }
                }

            }
        }
    }

    /**
     * 获取
     * @return
     */
    public ArrayList<CumulativeYieldGraphDataVO> getBlockBaseRaito() {
        ArrayList<CumulativeYieldGraphDataVO> cumulativeYieldGraphDataVOS = new ArrayList<>();

        for(int i=0; i<this.blockBaseRaito.size(); ++i) {
            cumulativeYieldGraphDataVOS.add(new CumulativeYieldGraphDataVO(DateHelper.getInstance().stringTransToDate(blockBaseRaito.get(i).getDate()),
                    blockBaseRaito.get(i).getBaseRatio()));
        }

        return  cumulativeYieldGraphDataVOS;
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

    public int getTradeDays() {
        return tradeDays;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public StrategyInputVO getStrategyInputVO() {
        return strategyInputVO;
    }

    public int getHoldingStockNum() {
        return holdingStockNum;
    }

    public BlockType getBlockType() {
        return blockType;
    }
}
