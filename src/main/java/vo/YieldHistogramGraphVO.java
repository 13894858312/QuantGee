package vo;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 */
public class YieldHistogramGraphVO {

    public int groupNum; //组数
    public double groupInterval; //组间差距，组左端值与右端值的差距

    public int positiveEarningNum; //正收益周期数
    public int negativeEarningNum; //负收益周期数
    public double winRate; //赢率

    ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOS; //坐标信息

    /**
     *
     * @param groupNum 组数
     * @param groupInterval 组间差距，组左端值与右端值的差距
     * @param positiveEarningNum 正收益周期数
     * @param negativeEarningNum 负收益周期数
     * @param winRate 赢率
     * @param yieldHistogramGraphDataVOS 坐标信息
     */
    public YieldHistogramGraphVO(int groupNum, double groupInterval, int positiveEarningNum, int negativeEarningNum,
                                 double winRate, ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOS) {
        this.groupNum = groupNum;
        this.groupInterval = groupInterval;
        this.positiveEarningNum = positiveEarningNum;
        this.negativeEarningNum = negativeEarningNum;
        this.winRate = winRate;
        this.yieldHistogramGraphDataVOS = yieldHistogramGraphDataVOS;
    }
}
