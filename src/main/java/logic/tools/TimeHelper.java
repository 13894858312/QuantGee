package logic.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mark.W on 2017/6/5.
 */
public class TimeHelper {

    private static final String TIME_FORMAT = "HH:mm";//可以方便地修改日期格式
    private static final String AM_START_TIME = "09:30";
    private static final String AM_END_TIME = "11:30";
    private static final String PM_START_TIME = "13:00";
    private static final String PM_END_TIME = "15:00";

    public static String getNowTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        String date = dateFormat.format(now);
        return date;
    }

    /**
     * 获取指定时间的后n分钟的时间
     *
     * @param time 时间
     * @param n    n
     * @return String
     */
    public static String nextNMinutes(String time, int n) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.MINUTE, n);

        return dateFormat.format(calendar.getTime());
    }


    /**
     * 判断指定时间是否是开盘时间
     * am 9.30-11.30
     * pm 13.00-15.00
     *
     * @param time time
     * @return 0:am 1:pm 2 noon -1:不再开盘时间
     */
    public static int isMarketOpen(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);

        Date date1 = null, date2 = null, date3 = null, date4 = null, nowDate = null;

        try {
            date1 = dateFormat.parse(AM_START_TIME);
            date2 = dateFormat.parse(AM_END_TIME);
            date3 = dateFormat.parse(PM_START_TIME);
            date4 = dateFormat.parse(PM_END_TIME);
            nowDate = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long delta1 = nowDate.getTime() - date1.getTime();
        long delta2 = nowDate.getTime() - date2.getTime();
        long delta3 = nowDate.getTime() - date3.getTime();
        long delta4 = nowDate.getTime() - date4.getTime();

        if (delta1 >= 0 && delta2 <= 0) {
            return 0;
        }

        if (delta3 >= 0 && delta4 <= 0) {
            return 1;
        }

        if (delta2 >0 && delta3 <0) {
            return 2;
        }

        return -1;
    }

}