package logic.tools;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/3/7.
 */
public class DateHelperTest {

    @Test
    public void calculateDaysBetween() throws Exception {
        String dateString1 = "2/28/17";
        String dateString2 = "3/2/17";
        Date date1 = DateHelper.stringTransToDate(dateString1);
        Date date2 = DateHelper.stringTransToDate(dateString2);

        assertEquals(2, DateHelper.calculateDaysBetween(date1, date2));
    }



    @Test
    public void nextTradeDay() throws Exception {
        String dateString = "3/4/17";
        Date date = DateHelper.stringTransToDate(dateString);

        assertEquals("3/6/17", DateHelper.dateTransToString(DateHelper.nextTradeDay(date)));
    }

    @Test
    public void formerTradeDay() throws Exception {
        String dateString = "3/6/17";
        Date date = DateHelper.stringTransToDate(dateString);

        assertEquals("3/3/17", DateHelper.dateTransToString(DateHelper.formerTradeDay(date)));
    }

}