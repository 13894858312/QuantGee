package logic.stock;

import org.springframework.stereotype.Service;
import vo.stock.StockHistoricalVO;

/**
 * Created by Mark.W on 2017/5/16.
 * 股票数据分析的类
 */
@Service
public class StockDataCalculation {

    /**
     * 首先找到该日的最高和最低价，垂直地连成一条直线;然后再找出当日的开 市和收市价，把这两个价位连接成一条狭长的长方柱体(实体)。
     * 假如当日的收 市价较开市价为高(即低开高收)，我们便以红色来表示，或是在柱体上留白， 这种柱体就称之为“阳线”。
     * 如果当日的收市价较开市价为低(即高开低收)，我 们则以绿色表示，又或是在柱上涂黑色，这柱体就是“阴线”。
     * 在 K 线图中，从实体向上延伸的细线叫上影线。在阳线中，它是当日最高价与 收盘价之差; 在阴线中，它是当日最高价与开盘价之差。
     * 在 K 线图中，从实体向下延伸的细线叫下影线。在阳线中，它是当日开盘价与 最低价之差; 在阴线中，它是当日收盘价与最低价之差。
     */
    public KLineData calculateKLine(StockHistoricalVO historicalVO) {
        if(historicalVO == null) {
            return null;
        }
        boolean positive = false;
        double upper = 0;
        double lower = 0;

        //如果开盘价低于收盘价 阳线
        if(historicalVO.getOpen() < historicalVO.getClose()) {
            positive = true;
        }

        //在阳线中 上影线是当日最高价与收盘价之差 下影线是当日开盘价与最低价之差
        //在阴线中 上影线是当日最高价与开盘价之差 下影线是当日收盘价与最低价之差
        if(positive) {
            upper = historicalVO.getHigh() - historicalVO.getClose();
            lower = historicalVO.getOpen() - historicalVO.getLow();
        } else {
            upper = historicalVO.getHigh() - historicalVO.getOpen();
            lower = historicalVO.getClose() - historicalVO.getLow();
        }

        return new KLineData(positive, upper, lower);
    }

}
