package logic.strategy;

import vo.YieldHistogramGraphDataVO;
import vo.YieldHistogramGraphVO;

import java.util.ArrayList;

/**
 * 均值回归策略收益率分布直方图
 * Created by Mark.W on 2017/4/4.
 */
public class MeanReversionYieldHistogram {
    private StockPool stockPool;

    private ArrayList<YieldHistogramGraphDataVO> yieldHistogramGraphDataVOS; //坐标信息
    private YieldHistogramGraphVO yieldHistogramGraphVO;

    public MeanReversionYieldHistogram(StockPool stockPool) {
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
