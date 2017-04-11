package logic.strategy;

import vo.AbnormalReturnGraphVO;
import vo.CumulativeYieldGraphVO;
import vo.StrategyInputVO;
import vo.YieldHistogramGraphVO;

/**
 * Created by Mark.W on 2017/3/29.
 * 策略的接口 采用策略模式
 */
public interface Strategy {

    /**
     * 计算累计收益率的图
     * @param stockPool 股票池
     * @return CumulativeYieldGraphVO
     */
    CumulativeYieldGraphVO getCumulativeYieldGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO);

    /**
     * 计算收益率和策略胜率的图
     * @param stockPool 股票池
     * @param strategyInputVO 股票信息
     * @param period 周期
     * @param isHoldingPeriod period参数是否是持有期，true为持有期，false为形成期
     * @return AbnormalReturnGraphVO
     */
    AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO, double period, boolean isHoldingPeriod);

    /**
     * 计算收益分布直方图
     * @param stockPool 股票池
     * @param strategyInputVO 股票信息
     * @return YieldHistogramGraphVO
     */
    YieldHistogramGraphVO getYieldHistogramGraphInfo(StockPool stockPool, StrategyInputVO strategyInputVO);
}
