package logic.tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/5/21.
 */
public class DateHelperTest {
    @Test
    public void getNowDate() throws Exception {
        assertEquals("2017-05-21", DateHelper.getNowDate());

    }

    @Test
    public void getNowTime() throws Exception {
        System.out.println(DateHelper.getNowTime());
    }

}