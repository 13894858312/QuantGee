package logic.tools;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/6.
 */
public class DateHelper {

    public static String dateTransToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yy");

        return simpleDateFormat.format(date);
    }

    public static int calculateDaysBetween(Date startDate, Date endDate) {
        long start = 0, end = 0;
        start = startDate.getTime();
        end = endDate.getTime();

        int res = (int) ((start - end) / (1000 * 60 * 60 * 24));

        return res;
    }

    /**
     * 给定日期计算下一个交易日（除去周末）
     *
     * @param date 日期
     * @return
     */
    public static Date nextTradeDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);

        return c.getTime();
    }

    /**
     * 给定日期计算前一个交易日（除去周末）
     * @param date 日期
     * @return
     */
    public static Date formerTradeDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);

        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, -1);
        }

        return c.getTime();
    }

    public static Date stringTransToDate(String dateformat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yy");

        Date date = null;
        try {
            date = simpleDateFormat.parse(dateformat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

}
