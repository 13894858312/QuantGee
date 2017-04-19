package logic.calculation;

import logic.tools.DateHelper;
import logicService.StrategyCalculationService;
import org.junit.Test;
import vo.*;

import java.util.Date;


/**
 * Created by Mark.W on 2017/4/15.
 */
public class StrategyCalculationTest {
    @Test
    public void getStrategyBackTestingGraphInfo() throws Exception {
        Date startDate = DateHelper.getInstance().stringTransToDate("2/2/10");
        Date endDate = DateHelper.getInstance().stringTransToDate("4/5/11");
        StrategyInputVO strategyInputVO = new StrategyInputVO(startDate, endDate, 10, 5, 50, false);

        StrategyCalculationService s = new StrategyCalculation();
        BackTestingResultVO backTestingResultVO = s.getStrategyBackTestingGraphInfo(StrategyType.MEAN_REVERSION, strategyInputVO);

        System.out.println();
        System.out.println("result:");
        System.out.println("annualRevenue: " + backTestingResultVO.cumulativeYieldGraphVO.annualRevenue);
        System.out.println("baseAnnualRevenue: " + backTestingResultVO.cumulativeYieldGraphVO.baseAnnualRevenue);
        System.out.println("alpha: " + backTestingResultVO.cumulativeYieldGraphVO.alpha);
        System.out.println("beta: " + backTestingResultVO.cumulativeYieldGraphVO.beta);
        System.out.println("sharpeRatio: " + backTestingResultVO.cumulativeYieldGraphVO.sharpeRatio);
        System.out.println("maxDrawdown: " + backTestingResultVO.cumulativeYieldGraphVO.maxDrawdown);

        System.out.println("positiveEarningNum: " + backTestingResultVO.yieldHistogramGraphVO.positiveEarningNum);
        System.out.println("negativeEarningNum: " + backTestingResultVO.yieldHistogramGraphVO.negativeEarningNum);
        System.out.println("winRate: " + backTestingResultVO.yieldHistogramGraphVO.winRate);
    }

    @Test
    public void getAbnormalReturnGraphInfo() throws Exception {
        Date startDate = DateHelper.getInstance().stringTransToDate("2/2/10");
        Date endDate = DateHelper.getInstance().stringTransToDate("4/5/11");
        StrategyInputVO strategyInputVO = new StrategyInputVO(startDate, endDate, 10, 5, 50,false);

        StrategyCalculationService s = new StrategyCalculation();
        AbnormalReturnGraphVO abnormalReturnGraphVO = s.getAbnormalReturnGraphInfo(StrategyType.MEAN_REVERSION, strategyInputVO, true);

        System.out.println();
        System.out.println("bestHoldingPeriod: " + abnormalReturnGraphVO.bestHoldingPeriod);
        System.out.println("bestReturnPeriod: " + abnormalReturnGraphVO.bestReturnPeriod);
        System.out.println("bestAbnormalReturn: " + abnormalReturnGraphVO.bestAbnormalReturn);
        System.out.println("bestStategyWinRate: " + abnormalReturnGraphVO.bestStategyWinRate);
    }

}