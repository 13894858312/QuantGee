package vo;


import logic.tools.AverageLineType;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/5.
 */
public class AverageLineVO {
    public AverageLineType averageLineType;
    public Date date;
    public double averageValue;

    /**
     * @param averageLineType 类型
     * @param date 时间
     * @param averageValue 对应平均值
     */
    public AverageLineVO(AverageLineType averageLineType, Date date, double averageValue) {
        this.date = date;
        this.averageValue = averageValue;
    }
}
