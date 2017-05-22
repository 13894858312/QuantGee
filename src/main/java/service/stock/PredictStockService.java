package service.stock;

import vo.stock.BOLLVO;
import vo.stock.KDJVO;
import vo.stock.MACDVO;
import vo.stock.RSIVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 * 股票趋势预测的接口
 */
public interface PredictStockService {

    /**
     * 获取股票MACD指标数据
     * @param stockCode 股票代码
     * @return ArrayList<MACDVO>
     */
    public ArrayList<MACDVO> getMACDInfo(String stockCode);

    /**
     * 获取股票KDJ指标数据
     * @param stockCode 股票代码
     * @return ArrayList<KDJVO>
     */
    public ArrayList<KDJVO> getKDJInfo(String stockCode);

    /**
     * 获取股票RSI指标数据
     * @param stockCode 股票代码
     * @return ArrayList<RSIVO>
     */
    public ArrayList<RSIVO> getRSIInfo(String stockCode);

    /**
     * 获取股票BOLL指标数据
     * @param stockCode 股票代码
     * @return ArrayList<BOLLVO>
     */
    public ArrayList<BOLLVO> getBOLLInfo(String stockCode);
}
