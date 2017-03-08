package logic.tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/3/7.
 */
public class MathHelperTest {

    @Test
    public void calculateVariance1() throws Exception {
        double[] data = new double[6];
        data[0] = 2.2;
        data[1] = 1.8;
        data[2] = 1.9;
        data[3] = 2.1;
        data[4] = 2.1;
        data[5] = 1.9;

        assertEquals(0.02, MathHelper.calculateVariance(data), 0);
    }

    @Test
    public void calculateVariance2() throws Exception {
        double[] data = new double[6];
        data[0] = 2;
        data[1] = 1;
        data[2] = 3;
        data[3] = 5;
        data[4] = -1;
        data[5] = 2;

        assertEquals(3.33, MathHelper.calculateVariance(data), 0);
    }


    @Test
    public void average() throws Exception {
        double[] data = new double[6];
        data[0] = 2.2;
        data[1] = 1.8;
        data[2] = 1.9;
        data[3] = 2.1;
        data[4] = 2.1;
        data[5] = 1.9;

        assertEquals(2.0, MathHelper.average(data), 0);
    }

}