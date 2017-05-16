package service.stock;

import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 * 个股信息的接口
 */
public interface StockInfoService {

    /**
     * 获取所有股票的实时信息
     * 用于列表展示
     * @return ArrayList<Stock>
     */
    public ArrayList<StockCurrentVO> getAllRealTimeStocks();

    /**
     * 根据股票代码获取指定个股实时数据
     * @param stockCode 股票代码
     * @return StockCurrentVO
     */
    public StockCurrentVO getRealTimeStockInfo(String stockCode);

    /**
     * 获取指定时间段和股票代码股票历史数据
     * 包括股票k线图 均线图 成交量直方图 的历史数据
     * @return ArrayList<StockHistoricalVO>
     */
    public ArrayList<StockHistoricalVO> getStockHistoricalInfo(StockInputVO stockInputVO);

    /**
     * 根据行业名称获取行业所有股票的实时数据
     * @param industryName 行业名称
     * @return 股票数据
     */
    public ArrayList<StockCurrentVO> getStocksByIndustry(String industryName);

    /**
     * 股票走势预测
     * @param stockCode 股票代码
     * @return StockPredictionVO
     */
    public StockPredictionVO predictStockTrend(String stockCode);

}
