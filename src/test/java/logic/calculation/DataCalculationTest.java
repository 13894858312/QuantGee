package logic.calculation;

import logic.tools.DateHelper;
import org.junit.Before;
import org.junit.Test;
import vo.MarketInfoVO;
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
        Date startDate = DateHelper.stringTransToDate("3/1/17");
        Date endDate = DateHelper.stringTransToDate("3/14/17");
        StockVO stockVO = this.dataCalculation.getStockInfoByName("1", startDate, endDate);

        assertEquals("1", stockVO.stockCode);

        assertEquals(4, stockVO.minValue, 0);
        assertEquals(320, stockVO.maxValue, 0);

        assertEquals(10, stockVO.stockDailyInfoVOs.size());

        assertEquals(52, stockVO.stockDailyInfoVOs.get(9).closePrice, 0);

        assertEquals(-0.6923076923076923, stockVO.stockDailyInfoVOs.get(1).inOrDecreaseRate, 0);

        assertEquals(0.3076923076923077, stockVO.stockDailyInfoVOs.get(1).logarithmYield, 0);

    }
    @Test
    public void getMarketInfo() throws Exception {

        MarketInfoVO marketInfoVO = this.dataCalculation.getMarketInfo(DateHelper.stringTransToDate("3/2/17"));

        assertEquals("3/2/17", DateHelper.dateTransToString(marketInfoVO.date));

        assertEquals(3620, marketInfoVO.volume);

        assertEquals(3, marketInfoVO.rateNums[0]);

        assertEquals(1, marketInfoVO.rateNums[2]);
        assertEquals(1, marketInfoVO.rateNums[4]);

    }

}