package logic.tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/6/5.
 */
public class TimeHelperTest {
    @Test
    public void getNowTime() throws Exception {
        System.out.println(TimeHelper.getNowTime());
    }

    @Test
    public void nextNMinutes() throws Exception {
        assertEquals("09:22:02",TimeHelper.nextNMinutes("09:20:02",2));
    }

    @Test
    public void isMarketOpen() throws Exception {
        assertEquals(0,TimeHelper.isMarketOpen("09:31:00"));
        assertEquals(-1,TimeHelper.isMarketOpen("23:31:00"));
        assertEquals(1, TimeHelper.isMarketOpen("13:00:10"));
    }

}