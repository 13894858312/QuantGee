package service.stock;

import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 * 大盘数据的service
 */
public interface MarketInfoService {

//    /**
//     * 获取大盘实时数据 用于画实时线
//     * @param marketType 大盘类型
//     *                   sh=上证指数 sz=深圳成指 szxb=中小板 cyb=创业板
//     * @return MarketInfoVO
//     */
//    public ArrayList<RealTimeLineVO> getMarketRealTimeLineInfo(String marketType);
//
//    /**
//     * 获取大盘实时的数据 包括涨跌股票数量等
//     * @param marketType 大盘类型
//     *                   sh=上证指数 sz=深圳成指 szxb=中小板 cyb=创业板
//     * @return MarketInfoVO
//     */
//    public MarketInfoVO getMarketRealTimeInfo(String marketType);

    /**
     * 获取历史数据大盘信息
     * @param marketType 大盘类型
     *                   sh=上证指数 sz=深圳成指 zxb=中小板 cyb=创业板
     * @param date 日期
     * @return MarketInfoVO
     */
    public MarketInfoVO getHistoryMarketInfo(String marketType, String date);

    /**
     * 获取个股涨跌榜
     * @param upOrDown 0 涨幅前十 1 跌幅前十
     * @return ArrayList<TopStockVO>
     */
    public ArrayList<TopStockVO> getTopStocks(int upOrDown);

    /**
     * 获取行业涨跌榜
     * @param upOrDown 0 涨幅前十 1 跌幅前十
     * @return ArrayList<TopStockVO>
     */
    public ArrayList<TopStockVO> getTopIndustryStocks(int upOrDown);
}
