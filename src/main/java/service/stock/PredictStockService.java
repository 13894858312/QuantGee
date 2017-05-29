package service.stock;


import vo.stock.StockInputVO;
import vo.stock.StockPredictVO;

/**
 * Created by Mark.W on 2017/5/21.
 * 股票趋势预测的接口
 */
public interface PredictStockService {

    /**
     * 获取股票预测的信息
     * @param inputVO 股票代码
     * @return StockPredictVO
     */
    public StockPredictVO getStockPredictInfo(StockInputVO inputVO);
}
