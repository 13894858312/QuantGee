package vo;


import java.util.Date;

/**
 * Created by Mark.W on 2017/3/6.
 * 股票的每日信息，包括涨跌幅 收盘价 对数收益率
 */
public class StockDailyInfoVO {

    public String stockCode;
    public String stockName;
    public Date date;
    public double inOrDecreaseRate;
    public double closePrice;
    public double logarithmYield;

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param date 日期
     * @param inOrDecreaseRate 涨幅／跌幅
     * @param closePrice  收盘价
     * @param logarithmYield 对数收益率
     */
    public StockDailyInfoVO(String stockCode, String stockName, Date date,
                            double inOrDecreaseRate, double closePrice, double logarithmYield) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.date = date;
        this.inOrDecreaseRate = inOrDecreaseRate;
        this.closePrice = closePrice;
        this.logarithmYield = logarithmYield;
    }
}
