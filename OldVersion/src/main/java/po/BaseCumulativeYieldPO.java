package po;

import java.util.Date;

/**
 * 基准累计收益率图中坐标信息
 * Created by Mark.W on 2017/3/31.
 */
public class BaseCumulativeYieldPO {
    private String date;
    private double baseRatio; //基准收益率

    public BaseCumulativeYieldPO(String date, double baseRatio) {
        this.date = date;
        this.baseRatio = baseRatio;
    }

    public String getDate() {
        return date;
    }

    public double getBaseRatio() {
        return baseRatio;
    }
}
