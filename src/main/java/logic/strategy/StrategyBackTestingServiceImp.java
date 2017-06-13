package logic.strategy;

import logic.strategy.backTesting.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import service.strategy.StrategyBackTestingService;
import vo.strategy.AbnormalReturnResultVO;
import vo.strategy.StrategyBackTestResultVO;
import vo.strategy.StrategyBackTestInputVO;

/**
 * Created by Mark.W on 2017/3/23.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StrategyBackTestingServiceImp implements StrategyBackTestingService{

    @Autowired
    private StockPool stockPool;

    @Override
    public StrategyBackTestResultVO getStrategyBackTesting(StrategyBackTestInputVO inputVO) {

        System.out.println();
        System.out.println(inputVO.toString());

        stockPool.initStockPool(inputVO);
        IStrategy iStrategy = this.getStrategy(inputVO.getStrategyType());

        StrategyBackTesting strategyBackTesting = new StrategyBackTesting(stockPool, inputVO.getHoldingPeriod(), inputVO.getReturnPeriod(), iStrategy,false);
        strategyBackTesting.start();
        StrategyBackTestResultVO result = strategyBackTesting.getStrategyBackTestResultVO();

        return result;
    }

    @Override
    public AbnormalReturnResultVO getAbnormalReturnGraphInfo(StrategyBackTestInputVO inputVO) {
        stockPool.initStockPool(inputVO);
        IStrategy iStrategy = this.getStrategy(inputVO.getStrategyType());

        int period;
        if(inputVO.isHoldingPeriodFixed()) {
            period = inputVO.getHoldingPeriod();
        } else {
            period = inputVO.getReturnPeriod();
        }

        StrategyAbnormalReturn strategyAbnormalReturn = new StrategyAbnormalReturn(stockPool, period, inputVO.isHoldingPeriodFixed(), iStrategy);
        strategyAbnormalReturn.start();
        AbnormalReturnResultVO result = strategyAbnormalReturn.getAbnormalReturnResult();

        return result;
    }


    /**
     * 工厂模式初始化策略
     * @param strategyType strategyType
     */
    private IStrategy getStrategy(int strategyType) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStrategy iStrategy = (IStrategy)context.getBean(String.valueOf(strategyType));
        return iStrategy;
    }

}
