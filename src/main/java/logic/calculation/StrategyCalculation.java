package logic.calculation;

import logic.strategy.*;
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

        BlockType blockType = null;
        if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
            blockType = strategyInputVO.blockType;
        }

        StrategyBackTesting strategyBackTesting = new StrategyBackTesting(stockPool, strategyInputVO.holdingPeriod, strategyInputVO.returnPeriod, strategy, blockType);

        strategyBackTesting.start();

        BackTestingResultVO backTestingResultVO = strategyBackTesting.getBackTestingResultVO();

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

        BlockType blockType = null;
        if(strategyInputVO.strategyInputType == StrategyInputType.SPECIFIC_BLOCK) {
            blockType = strategyInputVO.blockType;
        }

        int period;
        if(isHoldingPeriod) {
            period = strategyInputVO.holdingPeriod;
        } else {
            period = strategyInputVO.returnPeriod;
        }

        StrategyAbnormalReturn strategyAbnormalReturn = new StrategyAbnormalReturn(stockPool, period, isHoldingPeriod, strategy, blockType);

        strategyAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = strategyAbnormalReturn.getAbnormalReturnGraphVO();

        assert (abnormalReturnGraphVO != null) : "logic.calculation.StrategyCalculation.getAbnormalReturnGraphInfo返回值异常" ;

        return abnormalReturnGraphVO;
    }


    /**
     * 工厂模式初始化策略
     * @param strategyType strategyType
     */
    private void initStrategy(StrategyType strategyType) {
        this.strategy = StrategyFactory.getInstance().getStrategy(strategyType);

        assert (strategy != null) : "logic.calculation成员变量strategy异常" ;
    }

    /**
     * 判断StrategyInputVO是否相同 用来确定是否要重新加载股票池
     * @param strategyInputVO StrategyInputVO
     */
    private void initStockPool(StrategyInputVO strategyInputVO) {
        if(stockPool == null) {
            stockPool = new StockPool(strategyInputVO);
        } else {

            if(!(strategyInputVO.equals(stockPool.getStrategyInputVO()))) {
                stockPool = new StockPool(strategyInputVO);
            }
        }
    }
}
