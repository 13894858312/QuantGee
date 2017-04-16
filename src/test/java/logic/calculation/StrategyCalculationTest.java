package logic.calculation;

import logic.tools.DateHelper;
import logicService.StrategyCalculationService;
import org.junit.Test;
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
        Date startDate = DateHelper.getInstance().stringTransToDate("4/1/14");
        Date endDate = DateHelper.getInstance().stringTransToDate("4/23/14");
        StrategyInputVO strategyInputVO = new StrategyInputVO(startDate, endDate, 10, 10, 0.2);

        StrategyCalculationService s = new StrategyCalculation();
        BackTestingResultVO backTestingResultVO = s.getStrategyBackTestingGraphInfo(StrategyType.MOMENTUM_DRIVEN, strategyInputVO);
    }

    @Test
    public void getAbnormalReturnGraphInfo() throws Exception {
    }

}