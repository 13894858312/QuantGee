package logic.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.strategy.StrategyBackTestingService;
import vo.strategy.AbnormalReturnResultVO;
import vo.strategy.StrategyBackTestInputVO;
import vo.strategy.StrategyBackTestResultVO;
import vo.strategy.StrategyTradeRecordVO;

import java.util.ArrayList;

/**
 * Created by Mark.W on 2017/5/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class StrategyBackTestingServiceImpTest {

    @Autowired
    private StrategyBackTestingService strategyBackTestingService;

    //动量策略
    @Test
    public void getStrategyBackTesting0() throws Exception {
        StrategyBackTestInputVO inputVO = new StrategyBackTestInputVO();
        inputVO.setStockPoolType(1);
        inputVO.setStrategyType(0);
        inputVO.setInitFund(10000);
        inputVO.setStockCodes(initStockIDs());
        inputVO.setStartDate("2015-01-30");
        inputVO.setEndDate("2016-08-24");
        inputVO.setHoldingPeriod(10);
        inputVO.setReturnPeriod(10);
        inputVO.setNotST(false);
        inputVO.setStopLoss(20);
        inputVO.setStopProfit(20);

        inputVO.setRatio(20);

        StrategyBackTestResultVO result = strategyBackTestingService.getStrategyBackTesting(inputVO);

        System.out.println("*********RESULT**********  AnnualRevenue:  " + result.getCumulativeYieldResultVO().getAnnualRevenue());
        System.out.println("*********RESULT**********  Alpha:  " + result.getCumulativeYieldResultVO().getAlpha());
        System.out.println("*********RESULT**********  Beta:  " + result.getCumulativeYieldResultVO().getBeta());
        System.out.println("*********RESULT**********  BaseAnnualRevenue:  " + result.getCumulativeYieldResultVO().getBaseAnnualRevenue());
        System.out.println("*********RESULT**********  SharpeRatio:  " + result.getCumulativeYieldResultVO().getSharpeRatio());
        System.out.println("*********RESULT**********  MaxDrawdown:  " + result.getCumulativeYieldResultVO().getMaxDrawdown());
    }

    //均值回归策略
    @Test
    public void getStrategyBackTesting1() throws Exception {
        StrategyBackTestInputVO inputVO = new StrategyBackTestInputVO();
        inputVO.setStockPoolType(0);
        inputVO.setStrategyType(1);
        inputVO.setInitFund(10000);
        inputVO.setBlockType("zxb");
        inputVO.setStartDate("2015-01-02");
        inputVO.setEndDate("2016-08-24");
        inputVO.setHoldingPeriod(10);
        inputVO.setReturnPeriod(10);
        inputVO.setNotST(false);
        inputVO.setStopLoss(20);
        inputVO.setStopProfit(20);

        inputVO.setHoldingStockNum(100);

        StrategyBackTestResultVO result = strategyBackTestingService.getStrategyBackTesting(inputVO);

        System.out.println("*********RESULT**********  AnnualRevenue:  " + result.getCumulativeYieldResultVO().getAnnualRevenue());
        System.out.println("*********RESULT**********  Alpha:  " + result.getCumulativeYieldResultVO().getAlpha());
        System.out.println("*********RESULT**********  Beta:  " + result.getCumulativeYieldResultVO().getBeta());
        System.out.println("*********RESULT**********  BaseAnnualRevenue:  " + result.getCumulativeYieldResultVO().getBaseAnnualRevenue());
        System.out.println("*********RESULT**********  SharpeRatio:  " + result.getCumulativeYieldResultVO().getSharpeRatio());
        System.out.println("*********RESULT**********  MaxDrawdown:  " + result.getCumulativeYieldResultVO().getMaxDrawdown());
    }

    //双均线策略
    @Test
    public void getStrategyBackTesting2() throws Exception {
        StrategyBackTestInputVO inputVO = new StrategyBackTestInputVO();
        inputVO.setStockPoolType(0);
        inputVO.setStrategyType(2);
        inputVO.setInitFund(10000);
        inputVO.setBlockType("zxb");
        inputVO.setStartDate("2015-01-30");
        inputVO.setEndDate("2015-08-24");
        inputVO.setHoldingPeriod(2);
        inputVO.setReturnPeriod(20);
        inputVO.setNotST(false);
        inputVO.setStopLoss(20);
        inputVO.setStopProfit(20);

        inputVO.setShortReturnPeriod(5);
        inputVO.setHoldingStockNum(90);

        StrategyBackTestResultVO result = strategyBackTestingService.getStrategyBackTesting(inputVO);

        System.out.println("*********RESULT**********  AnnualRevenue:  " + result.getCumulativeYieldResultVO().getAnnualRevenue());
        System.out.println("*********RESULT**********  Alpha:  " + result.getCumulativeYieldResultVO().getAlpha());
        System.out.println("*********RESULT**********  Beta:  " + result.getCumulativeYieldResultVO().getBeta());
        System.out.println("*********RESULT**********  BaseAnnualRevenue:  " + result.getCumulativeYieldResultVO().getBaseAnnualRevenue());
        System.out.println("*********RESULT**********  SharpeRatio:  " + result.getCumulativeYieldResultVO().getSharpeRatio());
        System.out.println("*********RESULT**********  MaxDrawdown:  " + result.getCumulativeYieldResultVO().getMaxDrawdown());
    }

    //羊驼策略
    @Test
    public void getStrategyBackTesting3() throws Exception {
        StrategyBackTestInputVO inputVO = new StrategyBackTestInputVO();
        inputVO.setStockPoolType(0);
        inputVO.setStrategyType(3);
        inputVO.setInitFund(10000);
        inputVO.setBlockType("zxb");
        inputVO.setStartDate("2015-01-30");
        inputVO.setEndDate("2015-08-24");
        inputVO.setHoldingPeriod(10);
        inputVO.setReturnPeriod(10);
        inputVO.setNotST(false);
        inputVO.setStopLoss(20);
        inputVO.setStopProfit(20);

        inputVO.setHoldingStockNum(80);
        inputVO.setChangeNumber(40);

        StrategyBackTestResultVO result = strategyBackTestingService.getStrategyBackTesting(inputVO);

        System.out.println("*********RESULT**********  AnnualRevenue:  " + result.getCumulativeYieldResultVO().getAnnualRevenue());
        System.out.println("*********RESULT**********  Alpha:  " + result.getCumulativeYieldResultVO().getAlpha());
        System.out.println("*********RESULT**********  Beta:  " + result.getCumulativeYieldResultVO().getBeta());
        System.out.println("*********RESULT**********  BaseAnnualRevenue:  " + result.getCumulativeYieldResultVO().getBaseAnnualRevenue());
        System.out.println("*********RESULT**********  SharpeRatio:  " + result.getCumulativeYieldResultVO().getSharpeRatio());
        System.out.println("*********RESULT**********  MaxDrawdown:  " + result.getCumulativeYieldResultVO().getMaxDrawdown());
    }


    //knn策略
    @Test
    public void getStrategyBackTesting4() throws Exception {
        StrategyBackTestInputVO inputVO = new StrategyBackTestInputVO();
        inputVO.setStockPoolType(1);
        inputVO.setStrategyType(4);
        inputVO.setInitFund(10000);
        inputVO.setStockCodes(initStockIDs());
        inputVO.setStartDate("2015-01-30");
        inputVO.setEndDate("2016 -08-24");
        inputVO.setHoldingPeriod(10);
        inputVO.setReturnPeriod(10);
        inputVO.setTrainPeriod(100);
        inputVO.setNotST(false);
        inputVO.setStopLoss(20);
        inputVO.setStopProfit(20);

        inputVO.setK(10);
        inputVO.setVectorLength(20);
        inputVO.setHoldingStockNum(5);

        StrategyBackTestResultVO result = strategyBackTestingService.getStrategyBackTesting(inputVO);

        System.out.println("*********RESULT**********  AnnualRevenue:  " + result.getCumulativeYieldResultVO().getAnnualRevenue());
        System.out.println("*********RESULT**********  Alpha:  " + result.getCumulativeYieldResultVO().getAlpha());
        System.out.println("*********RESULT**********  Beta:  " + result.getCumulativeYieldResultVO().getBeta());
        System.out.println("*********RESULT**********  BaseAnnualRevenue:  " + result.getCumulativeYieldResultVO().getBaseAnnualRevenue());
        System.out.println("*********RESULT**********  SharpeRatio:  " + result.getCumulativeYieldResultVO().getSharpeRatio());
        System.out.println("*********RESULT**********  MaxDrawdown:  " + result.getCumulativeYieldResultVO().getMaxDrawdown());
    }

    @Test
    public void getAbnormalReturnGraphInfo() throws Exception {
        initStockIDs();

        StrategyBackTestInputVO inputVO = new StrategyBackTestInputVO();
        inputVO.setStockPoolType(1);
        inputVO.setStrategyType(0);
        inputVO.setStockCodes(initStockIDs());
        inputVO.setInitFund(10000);
        inputVO.setStartDate("2017-03-30");
        inputVO.setEndDate("2017-05-24");
        inputVO.setHoldingPeriodFixed(true);
        inputVO.setReturnPeriod(10);
        inputVO.setRatio(0.2);
        inputVO.setHoldingStockNum(9);
        inputVO.setHoldingPeriod(10);

        AbnormalReturnResultVO result = strategyBackTestingService.getAbnormalReturnGraphInfo(inputVO);

        System.out.println("*********RESULT**********  isHoldingPeriodFixed:  " + result.isHoldingPeriodFixed());
        System.out.println("*********RESULT**********  BestHoldingPeriod:  " + result.getBestHoldingPeriod());
        System.out.println("*********RESULT**********  BestReturnPeriod:  " + result.getBestReturnPeriod());
        System.out.println("*********RESULT**********  BestAbnormalReturn:  " + result.getBestAbnormalReturn());
        System.out.println("*********RESULT**********  BestStategyWinRate:  " + result.getBestStategyWinRate());

    }

    private ArrayList<String> initStockIDs() {
        ArrayList<String> stockIDs = new ArrayList<>();

        stockIDs.add("000001");
        stockIDs.add("000002");
        stockIDs.add("000004");
        stockIDs.add("000005");
        stockIDs.add("000006");
        stockIDs.add("000007");
        stockIDs.add("000008");
        stockIDs.add("000009");
        stockIDs.add("000010");
        stockIDs.add("000011");
        stockIDs.add("000012");
        stockIDs.add("000014");
        stockIDs.add("000016");
        stockIDs.add("000018");
        stockIDs.add("000019");
        stockIDs.add("000020");
        stockIDs.add("000021");
        stockIDs.add("000023");
        stockIDs.add("000025");
        stockIDs.add("000026");
        stockIDs.add("000027");
        stockIDs.add("000028");
        stockIDs.add("000029");
        stockIDs.add("000030");
        stockIDs.add("000031");
        stockIDs.add("000032");
        stockIDs.add("000034");
        stockIDs.add("000035");
        stockIDs.add("000036");
        stockIDs.add("000037");
        stockIDs.add("000038");
        stockIDs.add("000039");
        stockIDs.add("000040");
        stockIDs.add("000042");
        stockIDs.add("000043");
        stockIDs.add("000045");
        stockIDs.add("000046");
        stockIDs.add("000048");
        stockIDs.add("000049");
        stockIDs.add("000050");
        stockIDs.add("000055");
        stockIDs.add("000056");
        stockIDs.add("000059");
        stockIDs.add("000060");
        stockIDs.add("000061");
        stockIDs.add("000062");

        return stockIDs;
    }

}