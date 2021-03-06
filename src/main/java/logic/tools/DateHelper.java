package logic.tools;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mark.W on 2017/3/6.
 * 日期计算的帮助类
 */
public class DateHelper {
    private static final String DATE_FORMAT = "yyyy-MM-dd";//可以方便地修改日期格式
    public static final String INDEX_DATE = "2014-05-26";

    public static String getNowDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String date = dateFormat.format(now);
        return date;
    }

    /**
     * 判断当前时间是否已经收盘
     * @return boolean
     */
    public static boolean isClosed() {
        return false;
    }

    /**
     * 判断指定时期是否是交易日
     * @param date 日期
     * @return boolean
     */
    public static boolean isTradeDay(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(stringTransToDate(date));
        c.add(Calendar.DAY_OF_MONTH, -1);

        if (c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            return false;
        }

        return true;
    }

    /**
     * 计算两个日期间相差的天数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 天数 可为负数
     */
    public static int calculateDaysBetween(String startDate, String endDate) {

        Date s = stringTransToDate(startDate);
        Date e = stringTransToDate(endDate);

        long start, end;
        start = s.getTime();
        end = e.getTime();

        int res = (int) ((end - start) / (1000 * 60 * 60 * 24));
        return res;
    }

    /**
     * 将string格式化为日期
     * @param dateformat string
     * @return Date
     */
    public static Date stringTransToDate(String dateformat) {
        if(dateformat == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

        Date date = null;
        try {
            date = simpleDateFormat.parse(dateformat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 给定日期计算前一个交易日（除去周末）
     * @param date 日期
     * @return Date
     */
    public static String formerTradeDay(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(stringTransToDate(date));
        c.add(Calendar.DAY_OF_MONTH, -1);

        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, -1);
        }

        return dateTransToString(c.getTime());
    }

    /**
     * 给定日期计算下一个交易日（除去周末）
     * @param date 日期
     * @return Date
     */
    public static String nextTradeDay(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(stringTransToDate(date));
        c.add(Calendar.DAY_OF_MONTH, 1);

        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dateTransToString(c.getTime());
    }

    /**
     * 计算给定日期前n个交易日的日期
     * @param date 日期
     * @param n n
     * @return Date
     */
    public static String formerNTradeDay(String date, int n) {
        String d = date;
        for(int i=0; i<n; ++i) {
            d = formerTradeDay(d);
        }

        return d;
    }

    public static String dateTransToString(Date date) {
        if(date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
}