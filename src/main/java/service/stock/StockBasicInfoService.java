package service.stock;

import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 * 个股信息的接口
 */
public interface StockBasicInfoService {

    /**
     * 获取个股股票实时数据 用于画实时图
     * @param code 股票代码
     * @return RealTimeLineVO
     */
    public RealTimeLineVO getStockRealTimeLineInfo(String code);

    /**
     * 根据股票代码获取指定个股实时数据
     * 用于列表展示
     * @param code 股票代码或大盘代码
     * @return ArrayList<StockCurrentVO>
     */
    public StockCurrentVO getStockRealTimeInfo(String code);

    /**
     * 获取指定时间段和股票代码股票历史数据
     * 包括股票k线图 均线图 成交量直方图 的历史数据
     *   sh=上证指数 sz=深圳成指 hs300=沪深300指数 sz50=上证50 zxb=中小板 cyb=创业板
     * @return ArrayList<StockHistoricalVO>
     */
    public StockHistoricalVO getStockHistoricalInfo(StockInputVO stockInputVO);

    /**
     * 根据股票名称获得股票代码（错误返回null）
     * @param name 股票名称
     * @return 股票代码
     */
    public String getCodeByName(String name);

    /**
     * 获取所有的股票代码
     * @return 代码
     */
    public ArrayList<String> getAllStockCodeAndNames();

    /**
     * 获取所有股票的实时信息 用于列表展示
     * @return ArrayList<Stock>
     */
    public ArrayList<StockCurrentVO> getAllStockRealTime();

    /**
     * 根据行业名称获取行业所有股票的实时数据
     * @param industryName 行业名称
     * @return 股票数据
     */
    public ArrayList<StockCurrentVO> getStocksByIndustry(String industryName);

}
