package logic.calculation;

import logic.tools.DateHelper;
import logicService.StrategyCalculationService;
import org.junit.Test;
import vo.AbnormalReturnGraphVO;
import vo.BackTestingResultVO;
import vo.StrategyInputVO;
import vo.StrategyType;

import java.util.Date;


/**
 * Created by Mark.W on 2017/4/15.
 */
public class StrategyCalculationTest {
    @Test
    public void getStrategyBackTestingGraphInfo() throws Exception {
        Date startDate = DateHelper.getInstance().stringTransToDate("2/1/10");
        Date endDate = DateHelper.getInstance().stringTransToDate("4/10/12");
        StrategyInputVO strategyInputVO = new StrategyInputVO(startDate, endDate, 20, 20, 0.2);

        StrategyCalculationService s = new StrategyCalculation();
        BackTestingResultVO backTestingResultVO = s.getStrategyBackTestingGraphInfo(StrategyType.MOMENTUM_DRIVEN, strategyInputVO);

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
        Date startDate = DateHelper.getInstance().stringTransToDate("4/2/12");
        Date endDate = DateHelper.getInstance().stringTransToDate("9/3/12");
        StrategyInputVO strategyInputVO = new StrategyInputVO(startDate, endDate, 10, 10, 0.2);

        StrategyCalculationService s = new StrategyCalculation();
        AbnormalReturnGraphVO abnormalReturnGraphVO = s.getAbnormalReturnGraphInfo(StrategyType.MOMENTUM_DRIVEN, strategyInputVO, true);

        System.out.println();
        System.out.println("bestHoldingPeriod: " + abnormalReturnGraphVO.bestHoldingPeriod);
        System.out.println("bestReturnPeriod: " + abnormalReturnGraphVO.bestReturnPeriod);
        System.out.println("bestAbnormalReturn: " + abnormalReturnGraphVO.bestAbnormalReturn);
        System.out.println("bestStategyWinRate: " + abnormalReturnGraphVO.bestStategyWinRate);
    }

}