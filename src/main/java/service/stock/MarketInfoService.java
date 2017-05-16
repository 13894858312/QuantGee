package service.stock;

import vo.stock.*;

/**
 * Created by Mark.W on 2017/5/5.
 * 大盘数据的service
 */
public interface MarketInfoService {
    /**
     * 获取大盘实时数据
     * @param marketType 大盘类型
     *                   sh=上证指数 sz=深圳成指 hs300=沪深300指数 sz50=上证50 zxb=中小板 cyb=创业板
     * @return MarketInfoVO
     */
    public MarketInfoVO getRealTimeMarketInfo(String marketType);

    /**
     * 获取历史数据大盘信息
     * @param marketType 大盘类型
     *                   sh=上证指数 sz=深圳成指 hs300=沪深300指数 sz50=上证50 zxb=中小板 cyb=创业板
     * @param date 日期
     * @return MarketInfoVO
     */
    public MarketInfoVO getHistoryMarketInfo(String marketType, String date);
}
