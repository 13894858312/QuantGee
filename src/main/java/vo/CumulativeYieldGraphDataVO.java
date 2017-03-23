package vo;

import java.util.Date;

/**
 * Created by Mark.W on 2017/3/23.
 * 累计收益率图中坐标信息
 */
public class CumulativeYieldGraphDataVO {
    public Date date;
    public double baseRatio; //基准收益率
    public double ratio;  //收益率

    /**
     *
     * @param date 日期 横坐标
     * @param baseRatio 基准收益率
     * @param ratio 收益率
     */
    public CumulativeYieldGraphDataVO(Date date, double baseRatio, double ratio) {
        this.date = date;
        this.baseRatio = baseRatio;
        this.ratio = ratio;
    }
}
