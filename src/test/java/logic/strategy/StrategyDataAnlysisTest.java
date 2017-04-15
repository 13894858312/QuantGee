package logic.strategy;

import logic.tools.DateHelper;
import org.junit.Before;
import org.junit.Test;
import vo.CumulativeYieldGraphDataVO;
import vo.CumulativeYieldGraphVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/4/15.
 */
public class StrategyDataAnlysisTest {
    private StrategyDataAnlysis strategyDataAnlysis;

    @Before
    public void setUp() {
        this.strategyDataAnlysis = new StrategyDataAnlysis();
    }

    @Test
    public void analyseYieldHistogram() throws Exception {
    }

    /*
    double income, double init_fund, int tradeDays,
    ArrayList<CumulativeYieldGraphDataVO> strategyYield,
    ArrayList<CumulativeYieldGraphDataVO> baseYield
     */
    @Test
    public void analyseCumulativeYieldGraph() throws Exception {
        double income = 1200;
        double init_fund = 1000;
        int tradeDays = 10;

        ArrayList<CumulativeYieldGraphDataVO> strategyYield = new ArrayList<>();
        ArrayList<CumulativeYieldGraphDataVO> baseYield = new ArrayList<>();

        Date date = DateHelper.getInstance().stringTransToDate("3/12/17");

        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.09));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.10));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.12));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.08));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.07));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.13));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.10));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.11));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.09));
        strategyYield.add(new CumulativeYieldGraphDataVO(date, 0.11));

        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.09));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.07));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.10));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.06));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.08));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.08));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.09));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.10));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.05));
        baseYield.add(new CumulativeYieldGraphDataVO(date, 0.08));

        CumulativeYieldGraphVO cumulativeYieldGraphVO = this.strategyDataAnlysis.analyseCumulativeYieldGraph(income, init_fund, tradeDays, strategyYield, baseYield);



    }



}