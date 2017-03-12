package vo;


import logic.tools.AverageLineType;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class AverageLineVO {
    public String stockCode;
    public String stockName;
    public AverageLineType averageLineType;
    public Date date;
    public double averageValue;

    /**
     * @param stockCode 股票代码
     * @param stockName 股票名称
     * @param averageLineType 类型
     * @param date 时间
     * @param averageValue 对应平均值
     */
    public AverageLineVO(String stockCode, String stockName, AverageLineType averageLineType,
                         Date date, double averageValue) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.averageLineType = averageLineType;
        this.date = date;
        this.averageValue = averageValue;
    }
}
