package logic.tools;

/**
 * Created by Mark.W on 2017/3/10.
 */
public class SwitchAverageLineType {

    public static int getDayInterval(AverageLineType averageLineType) {
        int result = 0;

        switch (averageLineType) {
            case DAYS_5:
                result = 5;
                break;
            case DAYS_10:
                result = 10;
                break;
            case DAYS_30:
                result = 30;
                break;
            case DAYS_60:
                result = 60;
                break;
            case DAYS_120:
                result = 120;
                break;
            case DAYS_240:
                result = 240;
                break;
            case DAYS_20:
                result =20;
                break;
        }

        return result;
    }
}
