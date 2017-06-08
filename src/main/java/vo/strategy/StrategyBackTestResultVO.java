package vo.strategy;

import java.util.ArrayList;

/**
 * 策略回测结果的vo
 * 包括累计收益率图的数据和频率分布直方图的数据
 * Created by Mark.W on 2017/3/13.
 */
public class StrategyBackTestResultVO {
    private CumulativeYieldResultVO cumulativeYieldResultVO;
    private YieldHistogramResultVO yieldHistogramResultVO;
    private ArrayList<StrategyTradeRecordVO> tradeRecords;

    /**
     * @param cumulativeYieldResultVO 累计收益率图的数据
     * @param yieldHistogramResultVO 频率分布直方图的数据
     * @param tradeRecords 策略回测时的交易记录
     */
    public StrategyBackTestResultVO(CumulativeYieldResultVO cumulativeYieldResultVO, YieldHistogramResultVO yieldHistogramResultVO, ArrayList<StrategyTradeRecordVO> tradeRecords) {
        this.cumulativeYieldResultVO = cumulativeYieldResultVO;
        this.yieldHistogramResultVO = yieldHistogramResultVO;
        this.tradeRecords = tradeRecords;
    }

    public CumulativeYieldResultVO getCumulativeYieldResultVO() {
        return cumulativeYieldResultVO;
    }

    public YieldHistogramResultVO getYieldHistogramResultVO() {
        return yieldHistogramResultVO;
    }

    public ArrayList<StrategyTradeRecordVO> getTradeRecords() {
        return tradeRecords;
    }
}
