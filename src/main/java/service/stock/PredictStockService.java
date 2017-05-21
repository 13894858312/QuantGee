package service.stock;

import vo.stock.BOLLVO;
import vo.stock.KDJVO;
import vo.stock.MACDVO;
import vo.stock.RSIVO;

/**
 * Created by Mark.W on 2017/5/21.
 * 股票趋势预测的接口
 */
public interface PredictStockService {

    /**
     * 获取股票MACD指标数据
     * @param stockCode 股票代码
     * @return MACDVO
     */
    public MACDVO getMACDInfo(String stockCode);

    /**
     * 获取股票KDJ指标数据
     * @param stockCode 股票代码
     * @return KDJVO
     */
    public KDJVO getKDJInfo(String stockCode);

    /**
     * 获取股票RSI指标数据
     * @param stockCode 股票代码
     * @return RSIVO
     */
    public RSIVO getRSIInfo(String stockCode);

    /**
     * 获取股票BOLL指标数据
     * @param stockCode 股票代码
     * @return BOLLVO
     */
    public BOLLVO getBOLLInfo(String stockCode);
}
