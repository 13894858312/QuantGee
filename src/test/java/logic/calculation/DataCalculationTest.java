package logic.calculation;

import logic.tools.DateHelper;
import org.junit.Before;
import org.junit.Test;
import vo.StockVO;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mark.W on 2017/3/7.
 */
public class DataCalculationTest {

    private DataCalculation dataCalculation;

    @Before
    public void setUp() {
        this.dataCalculation = new DataCalculation();
    }

    @Test
    public void getStockInfo() throws Exception {

    }

    @Test
    public void getMarketInfo() throws Exception {
        Date startDate = DateHelper.stringTransToDate("3/1/17");
        Date endDate = DateHelper.stringTransToDate("3/14/17");
        StockVO stockVO = this.dataCalculation.getStockInfo("1", startDate, endDate);

        assertEquals("1", stockVO.stockCode);

        assertEquals(6, stockVO.minValue, 0);
        assertEquals(320, stockVO.maxValue, 0);

        assertEquals(10, stockVO.stockDailyInfoVOs.size());
    }

}