package service.stock;

import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 * 股票趋势预测的接口
 */
public interface PredictStockService {

    /**
     * 获取股票MACD指标数据
     * @param inputVO 股票股票代码和时间信息代码
     * @return ArrayList<MACDVO>
     */
    public ArrayList<MACDVO> getMACDInfo(StockInputVO inputVO);

    /**
     * 获取股票KDJ指标数据
     * @param inputVO 股票代码和时间信息
     * @return ArrayList<KDJVO>
     */
    public ArrayList<KDJVO> getKDJInfo(StockInputVO inputVO);

    /**
     * 获取股票RSI指标数据
     * @param inputVO 股票代码和时间信息
     * @return ArrayList<RSIVO>
     */
    public ArrayList<RSIVO> getRSIInfo(StockInputVO inputVO);

    /**
     * 获取股票BOLL指标数据
     * @param inputVO 股票代码和时间信息
     * @return ArrayList<BOLLVO>
     */
    public ArrayList<BOLLVO> getBOLLInfo(StockInputVO inputVO);
}
