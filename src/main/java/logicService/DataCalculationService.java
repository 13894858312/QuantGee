package logicService;

import vo.*;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public interface DataCalculationService {

    /**
     * 根据股票编号获取股票信息
     * @param stockCode 股票编号
     * @return  StockVO
     */
    public StockVO getStockInfo(String stockCode, Date startDate, Date endDate);

    /**
     * 根据时间获取股票市场行情数据
     * @param date 日期
     * @return MarketInfoVO
     */
    public MarketInfoVO getMarketInfo(Date date);

}
