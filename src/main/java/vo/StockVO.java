package vo;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class StockVO {

    public String stockCode;
    public String stockName;
    public String stockMarket;
    public double minValue;
    public double maxValue;
    public double logarithmYieldVariance;
    public ArrayList<StockDailyInfoVO> stockDailyInfoVOs;

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param stockMarket   市场名称
     * @param minValue 最低值
     * @param maxValue 最高值
     * @param logarithmYieldVariance 对数收益率方差
     * @param stockDailyInfoVOs stockDailyInfoVOs
     */
    public StockVO(String stockCode, String stockName, String stockMarket, double minValue,
                   double maxValue, double logarithmYieldVariance, ArrayList<StockDailyInfoVO> stockDailyInfoVOs) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.logarithmYieldVariance = logarithmYieldVariance;
        this.stockDailyInfoVOs = stockDailyInfoVOs;
    }
}
