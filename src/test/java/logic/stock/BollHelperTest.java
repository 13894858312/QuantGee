package logic.stock;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/6/13.
 */
public class BollHelperTest {
    @Test
    public void lineFit1() throws Exception {
        ArrayList<Double> data = new ArrayList<>();
        data.add(1.0);
        data.add(2.3);
        data.add(2.9);
        data.add(2.5);
        data.add(5.2);
        data.add(6.0);
        data.add(7.2);

        System.out.println(BollHelper.lineFit(data));
    }

    @Test
    public void lineFit2() throws Exception {
        ArrayList<Double> data = new ArrayList<>();
        data.add(10.2);
        data.add(6.0);
        data.add(5.3);
        data.add(4.7);
        data.add(2.9);
        data.add(2.3);
        data.add(1.0);

        System.out.println(BollHelper.lineFit(data));
    }

}