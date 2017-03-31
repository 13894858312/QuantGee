package logic.tools;

import org.junit.Test;
import po.StockPO;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/3/7.
 */
public class DateHelperTest {

    @Test
    public void dateTransToString() throws Exception {
         Date date = DateHelper.getInstance().stringTransToDate("3/12/17");

        assertEquals("3/12/17", DateHelper.getInstance().dateTransToString(date));
    }


    @Test
    public void calculateDaysBetween() throws Exception {
        String dateString1 = "3/2/17";
        String dateString2 = "3/1/17";
        Date date1 = DateHelper.getInstance().stringTransToDate(dateString1);
        Date date2 = DateHelper.getInstance().stringTransToDate(dateString2);

        assertEquals(-1, DateHelper.getInstance().calculateDaysBetween(date1, date2));
    }



    @Test
    public void nextTradeDay() throws Exception {
        String dateString = "3/4/17";
        Date date = DateHelper.getInstance().stringTransToDate(dateString);

        assertEquals("3/6/17", DateHelper.getInstance().dateTransToString(DateHelper.getInstance().nextTradeDay(date)));
    }

    @Test
    public void formerTradeDay() throws Exception {
        ArrayList<StockPO>[] arrayLists = new ArrayList[10];

        for(int i = 0; i<arrayLists.length; ++i) {
            ArrayList<StockPO> stockPOS = new ArrayList<>();
            stockPOS.add(new StockPO("3/1/17", 90, 150, 90, 8.15, 3000, 130, "1", "aaa", "a", null));
            arrayLists[i] = stockPOS;
        }

        for(int i = 0; i<arrayLists.length; ++i) {
            System.out.println(arrayLists[i].get(0).getADJ());
        }


        String dateString = "3/6/17";
        Date date = DateHelper.getInstance().stringTransToDate(dateString);

        assertEquals("3/3/17", DateHelper.getInstance().dateTransToString(DateHelper.getInstance().formerTradeDay(date)));
    }

}