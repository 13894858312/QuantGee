package logic.tools;

import java.text.DecimalFormat;

/**
 * Created by Mark.W on 2017/3/6.
 */
public class MathHelper {

    public static double sampleVariance(double[] data) {
        double average = MathHelper.average(data);

        double sum = 0;

        for(int i=0; i<data.length; ++i) {
            sum += Math.pow(data[i]-average, 2);
        }

        double temp = sum/(data.length-1);
        return MathHelper.formatData(temp);
    }

    public static double average(double[] data) {
        double sum = 0;

        for(int i=0; i<data.length; ++i) {
            sum += data[i];
        }


        double temp = sum/data.length;

        return MathHelper.formatData(temp);
    }

    public static double formatData(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(d));
    }
}
