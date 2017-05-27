package logic.strategy;

import logic.strategy.backTesting.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import service.strategy.StrategyBackTestingService;
import vo.strategy.AbnormalReturnGraphVO;
import vo.strategy.StrategyBackTestResultVO;
import vo.strategy.StrategyBackTestInputVO;

/**
 * Created by Mark.W on 2017/3/23.
 */
@Service
public class StrategyBackTestingServiceImp implements StrategyBackTestingService{

    private IStrategy iStrategy;

    @Autowired
    private StockPool stockPool;

    public StrategyBackTestingServiceImp() {
        this.iStrategy = new MomentumDriveIStrategy();
    }

    @Override
    public StrategyBackTestResultVO getStrategyBackTesting(StrategyBackTestInputVO inputVO) {

        this.initStockPool(inputVO);
        this.initStrategy(inputVO.getStratrgyType());

        //回测
        StrategyBackTesting strategyBackTesting = new StrategyBackTesting(stockPool, inputVO.getHoldingPeriod(),
                inputVO.getReturnPeriod(), iStrategy,false);
        strategyBackTesting.start();

        StrategyBackTestResultVO strategyBackTestResultVO = strategyBackTesting.getStrategyBackTestResultVO();

        assert (strategyBackTestResultVO != null) : "logic.calculation.StrategyBackTestingServiceImp.getCumulativeYieldGraphInfo返回值异常" ;

        return strategyBackTestResultVO;
    }

    @Override
    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyBackTestInputVO inputVO) {
        this.initStockPool(inputVO);
        this.initStrategy(inputVO.getStratrgyType());

        int period;
        if(inputVO.isHoldingPeriod()) {
            period = inputVO.getHoldingPeriod();
        } else {
            period = inputVO.getReturnPeriod();
        }

        StrategyAbnormalReturn strategyAbnormalReturn = new StrategyAbnormalReturn(stockPool, period, inputVO.isHoldingPeriod(), iStrategy);
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
            stockPool.initStockPool(strategyBackTestInputVO);
        } else {

            if(!(strategyBackTestInputVO.equals(stockPool.getStrategyBackTestInputVO()))) {
                stockPool.initStockPool(strategyBackTestInputVO);
            }
        }
    }
}
