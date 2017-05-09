package temp.vo;

import logic.tools.MathHelper;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/3/23.
 * 收益分布直方图的vo
 */
public class YieldHistogramGraphVO {

    public int positiveEarningNum; //正收益周期数
    public int negativeEarningNum; //负收益周期数
    public double winRate; //赢率

    public ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOS; //坐标信息

    /**
     *
     * @param positiveEarningNum 正收益周期数
     * @param negativeEarningNum 负收益周期数
     * @param winRate 赢率
     * @param yieldHistogramGraphDataVOS 坐标信息
     */
    public YieldHistogramGraphVO(int positiveEarningNum, int negativeEarningNum, double winRate,
                                 ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOS) {
        this.positiveEarningNum = positiveEarningNum;
        this.negativeEarningNum = negativeEarningNum;
        this.winRate = MathHelper.formatData(winRate*100, 2);
        this.yieldHistogramGraphDataVOS = yieldHistogramGraphDataVOS;
    }
}
