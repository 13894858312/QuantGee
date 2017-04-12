package logic.calculation;

import logic.tools.AverageLineType;
import logic.tools.DateHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/3/12.
 */
public class GraphCalculationTest {

    private GraphCalculation graphCalculation;

    @Before
    public void setUp() {
        this.graphCalculation = new GraphCalculation();
    }

    @Test
    public void getKLineInfoByCode() throws Exception {

        Date date = DateHelper.getInstance().stringTransToDate("3/3/17");
        ArrayList<KLineVO> kLineVOs = this.graphCalculation.getKLineInfoByCode(date, date, "1");

        assertEquals("1", kLineVOs.get(0).stockCode);

        assertEquals(true, kLineVOs.get(0).isPositive);

        assertEquals(20, kLineVOs.get(0).upperShadow,0);

        assertEquals(0, kLineVOs.get(0).lowerShadow,0);

        assertEquals(150, kLineVOs.get(0).maxValue,0);

        assertEquals(90, kLineVOs.get(0).minValue,0);

        assertEquals(90, kLineVOs.get(0).openPrice,0);

        assertEquals(130, kLineVOs.get(0).closePrice,0);

    }

    @Test
    public void getAverageLineInfoByCode() throws Exception {

        Date date1 = DateHelper.getInstance().stringTransToDate("3/3/17");
        Date date2 = DateHelper.getInstance().stringTransToDate("3/13/17");

        ArrayList<AverageLineVO> averageLineVOS = this.graphCalculation.getAverageLineInfoByCode(date1, date2, "3", AverageLineType.DAYS_5);

        assertEquals(6, averageLineVOS.size());

        assertEquals(8.31, averageLineVOS.get(0).averageValue, 0);

        assertEquals(8.50, averageLineVOS.get(1).averageValue, 0);

        assertEquals(8.73, averageLineVOS.get(2).averageValue, 0);

        assertEquals(8.78, averageLineVOS.get(3).averageValue, 0);

        assertEquals(8.95, averageLineVOS.get(4).averageValue, 0);

        assertEquals(9.01, averageLineVOS.get(5).averageValue, 0);

    }

}