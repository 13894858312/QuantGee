package service.stock;


import vo.stock.StockPredictVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/21.
 * 股票趋势预测的接口
 */
public interface PredictStockService {

    /**
     * 获取股票预测的信息
     * @param code 股票代码
     * @return ArrayList<StockPredictVO>
     */
    public ArrayList<StockPredictVO> getStockPredictInfo(String code);
}
