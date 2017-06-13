package service.stock;

import vo.stock.*;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/5.
 * 大盘数据的service
 */
public interface MarketInfoService {

    /**
     * 获取大盘实时数据 用于画实时图
     * @param indexName 大盘名字
     *             上证指数 A股指数 B股指数 综合指数 上证380 上证180 基金指数 国债指数 上证50
     *             新综指 沪深300 中证500 深证成指 深成指R 成分B指 深证100R 中小板指 创业板指
     *             中小300 新指数 中小板综 深证综指 深证A指 深证B指 中小板R 创业板R
     * @return RealTimeLineVO
     */
    public RealTimeLineVO getIndexRealTimeLine(String indexName);


    /**
     * 获取大盘实时数据 用于课表展示
     * @param indexName 大盘名字
     *             上证指数 A股指数 B股指数 综合指数 上证380 上证180 基金指数 国债指数 上证50
     *             新综指 沪深300 中证500 深证成指 深成指R 成分B指 深证100R 中小板指 创业板指
     *             中小300 新指数 中小板综 深证综指 深证A指 深证B指 中小板R 创业板R
     * @return CurrentIndexVO
     */
    public CurrentIndexVO getIndexRealTimeInfo(String indexName);

    /**
     * 获取个股涨跌榜
     * @param upOrDown 0 涨幅前十五 1 跌幅前十
     * @return ArrayList<TopStockVO>
     */
    public ArrayList<TopStockVO> getTopStocks(int upOrDown);

    /**
     * 获取行业涨跌榜
     * @param upOrDown 0 涨幅前十五 1 跌幅前十
     * @return ArrayList<TopStockVO>
     */
    public ArrayList<TopStockVO> getTopIndustryStocks(int upOrDown);

    /**
     * 获取历史数据大盘信息
     * @param marketType 大盘类型
     *                   sh=上证指数 sz=深圳成指 zxb=中小板 cyb=创业板
     * @param date 日期
     * @return MarketInfoVO
     */
    public MarketInfoVO getRealTimeMarketInfo(String marketType);
}
