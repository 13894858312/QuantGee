package vo;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class MarketInfoVO {

    public Date date;
    public int volume;
    public int[] rateNums;
    public int greaterThanFiveNum;
    public int lessThanFiveNum;

    /**
     * @param date 日期
     * @param volume 当日总成交量
     * @param rateNums 数据依次为跌停，-10%- -5%，-5%-0，0-5%，5%-10%， 涨停，
     * @param greaterThanFiveNum  开盘‐收盘大于 5%*上一个交易日收盘价的股票个数
     * @param lessThanFiveNum  开盘‐收盘小于‐5%*上一个交易日收盘价的股票个数
     */
    public MarketInfoVO(Date date, int volume, int[] rateNums,
                        int greaterThanFiveNum, int lessThanFiveNum) {
        this.date = date;
        this.volume = volume;
        this.rateNums = rateNums;
        this.greaterThanFiveNum = greaterThanFiveNum;
        this.lessThanFiveNum = lessThanFiveNum;
    }
}
