//package logic.strategy;
//
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Service;
//import service.strategy.StrategyBackTestingService;
//import vo.strategy.StrategyBackTestInputVO;
//import vo.strategy.StrategyBackTestResultVO;
//
///**
// * Created by Mark.W on 2017/5/26.
// */
//@Service
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//public class StrategyBackTestingServiceImp implements StrategyBackTestingService {
//
//    private IStrategy iStrategy;
//    private StockPool stockPool;
//
//    @Override
//    public StrategyBackTestResultVO getStrategyBackTesting(StrategyBackTestInputVO inputVO) {
//
//        this.initStrategy(inputVO.getStrategyType());
//        this.initStockPool(strategyInputVO);
//
//        //回测
//        StrategyBackTesting strategyBackTesting = new StrategyBackTesting(stockPool, inputVO.getHoldingPeriod(),
//                inputVO.getReturnPeriod(), iStrategy, false);
//        strategyBackTesting.start();
//
//        StrategyBackTestResultVO backTestingResultVO = strategyBackTesting.getBackTestingResultVO();
//
//        assert (backTestingResultVO != null) : "logic.calculation.StrategyCalculation.getCumulativeYieldGraphInfo返回值异常";
//
//        return backTestingResultVO;
//    }
//
//
//    /**
//     * 计算收益率和策略胜率的图
//     * @param strategyType 策略类型
//     * @param strategyInputVO 股票信息
//     * @param isHoldingPeriod period参数是否是持有期，true为持有期，false为形成期
//     * @return AbnormalReturnGraphVO
//     */
//    @Override
//    public AbnormalReturnGraphVO getAbnormalReturnGraphInfo(StrategyType strategyType, StrategyInputVO strategyInputVO, boolean isHoldingPeriod) {
//        this.initStrategy(inputVO.getStrategyType());
//        this.initStockPool(strategyInputVO);
//
//        int period;
//        if(isHoldingPeriod) {
//            period = strategyInputVO.holdingPeriod;
//        } else {
//            period = strategyInputVO.returnPeriod;
//        }
//
//        StrategyAbnormalReturn strategyAbnormalReturn = new StrategyAbnormalReturn(stockPool, period, isHoldingPeriod, strategy);
//        strategyAbnormalReturn.start();
//
//        AbnormalReturnGraphVO abnormalReturnGraphVO = strategyAbnormalReturn.getAbnormalReturnGraphVO();
//
//        assert (abnormalReturnGraphVO != null) : "logic.calculation.StrategyCalculation.getAbnormalReturnGraphInfo返回值异常" ;
//
//        return abnormalReturnGraphVO;
//    }
//
//    public void initStrategy(int strategyType) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        iStrategy= (IStrategy) context.getBean(String.valueOf(strategyType));
//    }
//
//    /**
//     * 判断StrategyInputVO是否相同 用来确定是否要重新加载股票池
//     *
//     * @param strategyInputVO StrategyInputVO
//     */
//    private void initStockPool(StrategyInputVO strategyInputVO) {
//        if (stockPool == null) {
//            stockPool = new StockPool(strategyInputVO);
//        } else {
//
//            if (!(strategyInputVO.equals(stockPool.getStrategyInputVO()))) {
//                stockPool = new StockPool(strategyInputVO);
//            }
//
//        }
//    }
//}
