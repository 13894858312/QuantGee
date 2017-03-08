package vo;


import java.util.Date;

/**
 * Created by Mark.W on 2017/3/6.
 */
public class StockDailyInfoVO {

    public Date date;
    public double inOrDecreaseRate;
    public double closePrice;
    public double logarithmYield;

    /**
     * @param date 日期
     * @param inOrDecreaseRate 涨幅／跌幅
     * @param closePrice  收盘价
     * @param logarithmYield 对数收益率
     */
    public StockDailyInfoVO(Date date, double inOrDecreaseRate, double closePrice,
                            double logarithmYield) {
        this.date = date;
        this.inOrDecreaseRate = inOrDecreaseRate;
        this.closePrice = closePrice;
        this.logarithmYield = logarithmYield;
    }
}
