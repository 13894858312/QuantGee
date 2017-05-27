package logic.strategy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.strategy.AbnormalReturnGraphVO;
import vo.strategy.BackTestingResultVO;
import vo.strategy.StrategyBackTestInputVO;

/**
 * Created by Mark.W on 2017/3/23.
 */
public class StrategyBackTestingServiceImp {

    private IStrategy iStrategy;
    private StockPool stockPool;

    public StrategyBackTestingServiceImp() {
        this.iStrategy = new MomentumDriveIStrategy();
    }

    /**
     * 策略回测
     * 计算累计收益率的图和收益分布直方图
     * @param strategyBackTestInputVO 股票信息
     * @return BackTestingResultVO
     */
    public BackTestingResultVO getStrategyBackTestingGraphInfo(int strategyType, StrategyBackTestInputVO strategyBackTestInputVO) {

        this.initStockPool(strategyBackTestInputVO);
        this.initStrategy(strategyType);

        //回测
        StrategyBackTesting strategyBackTesting = new StrategyBackTesting(stockPool, strategyBackTestInputVO.holdingPeriod,
                strategyBackTestInputVO.returnPeriod, iStrategy,false);
        strategyBackTesting.start();

        BackTestingResultVO backTestingResultVO = strategyBackTesting.getBackTestingResultVO();

        assert (backTestingResultVO != null) : "logic.calculation.StrategyBackTestingServiceImp.getCumulativeYieldGraphInfo返回值异常" ;

        return backTestingResultVO;
    }

    /**
     * 计算收益率和策略胜率的图
     * @param strategyType 策略类型
     * @param strategyBackTestInputVO 股票信息
     * @param isHoldingPeriod period参数是否是持有期，true为持有期，false为形成期
     * @return AbnormalReturnGraphVO
     */
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(int strategyType, StrategyBackTestInputVO strategyBackTestInputVO, boolean isHoldingPeriod) {
        this.initStockPool(strategyBackTestInputVO);
        this.initStrategy(strategyType);

        int period;
        if(isHoldingPeriod) {
            period = strategyBackTestInputVO.holdingPeriod;
        } else {
            period = strategyBackTestInputVO.returnPeriod;
        }

        StrategyAbnormalReturn strategyAbnormalReturn = new StrategyAbnormalReturn(stockPool, period, isHoldingPeriod, iStrategy);
        strategyAbnormalReturn.start();

        AbnormalReturnGraphVO abnormalReturnGraphVO = strategyAbnormalReturn.getAbnormalReturnGraphVO();

        assert (abnormalReturnGraphVO != null) : "logic.calculation.StrategyBackTestingServiceImp.getAbnormalReturnGraphInfo返回值异常" ;

        return abnormalReturnGraphVO;
    }


    /**
     * 工厂模式初始化策略
     * @param strategyType strategyType
     */
    private void initStrategy(int strategyType) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        iStrategy = (IStrategy)context.getBean(String.valueOf(strategyType));
    }

    /**
     * 判断StrategyInputVO是否相同 用来确定是否要重新加载股票池
     * @param strategyBackTestInputVO StrategyBackTestInputVO
     */
    private void initStockPool(StrategyBackTestInputVO strategyBackTestInputVO) {
        if(stockPool == null) {
            stockPool = new StockPool(strategyBackTestInputVO);
        } else {

            if(!(strategyBackTestInputVO.equals(stockPool.getStrategyBackTestInputVO()))) {
                stockPool = new StockPool(strategyBackTestInputVO);
            }
        }
    }
}
