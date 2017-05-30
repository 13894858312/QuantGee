package vo.strategy;

/**
 * 策略回测结果的vo
 * 包括累计收益率图的数据和频率分布直方图的数据
 * Created by Mark.W on 2017/3/13.
 */
public class StrategyBackTestResultVO {
    private CumulativeYieldResultVO cumulativeYieldResultVO;
    private YieldHistogramResultVO yieldHistogramResultVO;

    /**
     * @param cumulativeYieldResultVO 累计收益率图的数据
     * @param yieldHistogramResultVO 频率分布直方图的数据
     */
    public StrategyBackTestResultVO(CumulativeYieldResultVO cumulativeYieldResultVO, YieldHistogramResultVO yieldHistogramResultVO) {
        this.cumulativeYieldResultVO = cumulativeYieldResultVO;
        this.yieldHistogramResultVO = yieldHistogramResultVO;
    }

    public CumulativeYieldResultVO getCumulativeYieldResultVO() {
        return cumulativeYieldResultVO;
    }

    public void setCumulativeYieldResultVO(CumulativeYieldResultVO cumulativeYieldResultVO) {
        this.cumulativeYieldResultVO = cumulativeYieldResultVO;
    }

    public YieldHistogramResultVO getYieldHistogramResultVO() {
        return yieldHistogramResultVO;
    }

    public void setYieldHistogramResultVO(YieldHistogramResultVO yieldHistogramResultVO) {
        this.yieldHistogramResultVO = yieldHistogramResultVO;
    }
}
