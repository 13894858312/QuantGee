package logic.tools;

/**
 * Created by Mark.W on 2017/3/6.
 */
public class MathHelper {

    public static double calculateVariance(double[] data) {
        double average = MathHelper.average(data);

        double sum = 0;

        for(int i=0; i<data.length; ++i) {
            sum += Math.pow(data[i]-average, 2);
        }

        return sum/data.length;
    }

    public static double average(double[] data) {
        double sum = 0;

        for(int i=0; i<data.length; ++i) {
            sum += data[i];
        }

        return sum/data.length;
    }

}
