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

    private static DateHelper dateHelper;

    public static DateHelper getInstance() {
        if(dateHelper == null) {
            dateHelper = new DateHelper();
        }

        return dateHelper;
    }

    /**
     * 给定日期计算下一个交易日（除去周末）
     * @param date 日期
     * @return Date
     */
    public Date nextTradeDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);

        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

        return c.getTime();
    }

    /**
     * 给定日期计算前一个交易日（除去周末）
     * @param date 日期
     * @return Date
     */
    public Date formerTradeDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);

        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, -1);
        }

        return c.getTime();
    }

    /**
     * 计算给定日期前n个交易日的日期
     * @param date 日期
     * @param n n
     * @return Date
     */
    public Date formerNTradeDay(Date date, int n) {
        Date d = date;
        for(int i=0; i<n; ++i) {
            d = formerTradeDay(d);
        }

        return d;
    }

    public  Date nextNTradeDay(Date date, int n) {
        Date d = date;
        for(int i=0; i<n; ++i) {
            d = nextTradeDay(d);
        }

        return d;
    }

    /**
     * 获得给定日期的下一个第一个交易日
     * 如果给定日期是交易日，则日期不改变
     * @param date
     * @return
     */
    public Date getNextFirstTradeDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        while(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

        return c.getTime();
    }

    /**
     * 判断给定日期是否落在有股票数据的区间
     * @param date 日期
     * @return boolean
     */
    public boolean dateOutOfRange(Date date) {

        Date start = this.stringTransToDate("2/1/05");
        Date end = this.stringTransToDate("4/29/14");

        long s = start.getTime();
        long e = end.getTime();

        long d = date.getTime();

        if(s-d>=0 || e-d<=0) {
            return true;
        }

        return false;
    }

    /**
     * 计算两个日期间相差的天数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 天数 可为负数
     */
    public int calculateDaysBetween(Date startDate, Date endDate) {
        long start, end;
        start = startDate.getTime();
        end = endDate.getTime();

        int res = (int) ((end - start) / (1000 * 60 * 60 * 24));

        return res;
    }

    //保留小数
    public String getDealDate(double d){
        return new java.text.DecimalFormat("0.000000").format(d);
    }

    public Date stringTransToDate(String dateformat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yy");

        Date date = null;
        try {
            date = simpleDateFormat.parse(dateformat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public String dateTransToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yy");
        return simpleDateFormat.format(date);
    }

}
