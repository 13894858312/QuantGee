//package logic.strategy;
//
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
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
//    private Strategy strategy;
//    private StockPool stockPool;
//
//    @Override
//    public StrategyBackTestResultVO getStrategyBackTesting(StrategyBackTestInputVO inputVO) {
//
//        this.initStockPool(strategyInputVO);
//        this.initStrategy(strategyType);
//
//        //回测
//        StrategyBackTesting strategyBackTesting = new StrategyBackTesting(stockPool, strategyInputVO.holdingPeriod,
//                strategyInputVO.returnPeriod, strategy, false);
//        strategyBackTesting.start();
//
//        StrategyBackTestResultVO backTestingResultVO = strategyBackTesting.getBackTestingResultVO();
//
//        assert (backTestingResultVO != null) : "logic.calculation.StrategyCalculation.getCumulativeYieldGraphInfo返回值异常";
//
//        return null;
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
//        this.initStockPool(strategyInputVO);
//        this.initStrategy(strategyType);
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
