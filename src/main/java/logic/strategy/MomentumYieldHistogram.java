package logic.strategy;

import vo.YieldHistogramGraphDataVO;
import vo.YieldHistogramGraphVO;

import java.util.ArrayList;

/**
 * 动量策略计算收益率直方图
 * Created by Mark.W on 2017/4/4.
 */
public class MomentumYieldHistogram {
    private StockPool stockPool;

    private ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOS; //坐标信息
    private YieldHistogramGraphVO yieldHistogramGraphVO;

    public MomentumYieldHistogram(StockPool stockPool) {
        this.stockPool = stockPool;
    }

    public void start() {

        this.calculateData();
    }


    /**
     * 计算累计收益率分布直方图的分析结果数据
     */
    private void calculateData() {
    }


    public YieldHistogramGraphVO getYieldHistogramGraphVO() {
        return yieldHistogramGraphVO;
    }
}
