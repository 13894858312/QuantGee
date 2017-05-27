package vo.strategy;

/**
 * 策略回测结果的vo
 * 包括累计收益率图的数据和频率分布直方图的数据
 * Created by Mark.W on 2017/3/13.
 */
public class BackTestingResultVO {
    public CumulativeYieldGraphVO cumulativeYieldGraphVO;
    public YieldHistogramGraphVO yieldHistogramGraphVO;

    /**
     * @param cumulativeYieldGraphVO 累计收益率图的数据
     * @param yieldHistogramGraphVO 频率分布直方图的数据
     */
    public BackTestingResultVO(CumulativeYieldGraphVO cumulativeYieldGraphVO, YieldHistogramGraphVO yieldHistogramGraphVO) {
        this.cumulativeYieldGraphVO = cumulativeYieldGraphVO;
        this.yieldHistogramGraphVO = yieldHistogramGraphVO;
    }
}
