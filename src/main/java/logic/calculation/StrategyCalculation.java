package logic.calculation;

import logic.strategy.MomentumDriveStrategy;
import logic.strategy.StockPool;
import logic.strategy.Strategy;
import logic.tools.DateHelper;
import logic.tools.StrategyFactory;
import logicService.StrategyCalculationService;
import vo.*;

/**
 * Created by Mark.W on 2017/3/23.
 */
public class StrategyCalculation implements StrategyCalculationService{

    private Strategy strategy;
    private StockPool stockPool;

    public StrategyCalculation() {
        this.strategy = new MomentumDriveStrategy();
    }

    /**
     * 策略回测
     * 计算累计收益率的图和收益分布直方图
     * @param strategyInputVO 股票信息
     * @return BackTestingResultVO
     */
    @Override
    public BackTestingResultVO getStrategyBackTestingGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO) {
        this.initStockPool(strategyInputVO);
        this.initStrategy(strategyType);

        BackTestingResultVO backTestingResultVO = strategy.getStrategyBackTestingGraphInfo(stockPool, strategyInputVO);

        assert (backTestingResultVO != null) : "logic.calculation.StrategyCalculation.getCumulativeYieldGraphInfo返回值异常" ;

        return backTestingResultVO;
    }

    /**
     * 计算收益率和策略胜率的图
     * @param strategyType 策略类型
     * @param strategyInputVO 股票信息
     * @param isHoldingPeriod period参数是否是持有期，true为持有期，false为形成期
     * @return AbnormalReturnGraphVO
     */
    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO, boolean isHoldingPeriod) {
        this.initStockPool(strategyInputVO);
        this.initStrategy(strategyType);

        AbnormalReturnGraphVO abnormalReturnGraphVO = strategy.getAbnormalReturnGraphInfo(stockPool, strategyInputVO, isHoldingPeriod);

        assert (abnormalReturnGraphVO != null) : "logic.calculation.StrategyCalculation.getAbnormalReturnGraphInfo返回值异常" ;

        return abnormalReturnGraphVO;
    }


    private void initStrategy(StrategyType strategyType) {
        this.strategy = StrategyFactory.getInstance().getStrategy(strategyType);

        assert (strategy != null) : "logic.calculation成员变量strategy异常" ;
    }

    private void initStockPool(StrategyInputVO strategyInputVO) {
        if(stockPool == null) {
            stockPool = new StockPool(strategyInputVO);
        } else {

            String s1 = DateHelper.getInstance().dateTransToString(stockPool.getStartDate());
            String e1 = DateHelper.getInstance().dateTransToString(stockPool.getEndDate());

            String s2 = DateHelper.getInstance().dateTransToString(strategyInputVO.startDate);
            String e2 = DateHelper.getInstance().dateTransToString(strategyInputVO.endDate);

            if(!(s1.equals(s2) && e1.equals(e2))) {
                stockPool = new StockPool(strategyInputVO);
            }

        }
    }
}
