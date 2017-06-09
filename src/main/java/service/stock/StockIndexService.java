package service.stock;

import vo.stock.StockIndexVO;
import vo.stock.StockInputVO;

/**
 * Created by Mark.W on 2017/6/9.
 */
public interface StockIndexService {

    /**
     * 根据股票代码和时间的段获取股票指标数据
     * @param stockInputVO stockInputVO
     * @return StockIndexVO
     */
    public StockIndexVO getStockIndex(StockInputVO stockInputVO);
}
