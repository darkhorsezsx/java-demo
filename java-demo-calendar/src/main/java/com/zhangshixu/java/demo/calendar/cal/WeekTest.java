package com.zhangshixu.java.demo.calendar.cal;

import java.util.Calendar;

/**
 * This is {@link WeekTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class WeekTest {

/*    Calendar.SATURDAY = 1
    Calendar.MONDAY = 2
    Calendar.SATURDAY = 7 */

    public static long[] dates = new long[] {1514649600000L};

    public static void main (String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(1514649600000L);
        System.out.println(cal.getTime());

        System.out.println(cal.getFirstDayOfWeek());
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));

        Calendar cal2 = Calendar.getInstance();
        cal2.setFirstDayOfWeek(Calendar.MONDAY);
        cal2.setTimeInMillis(1514649600000L);
        System.out.println(cal2.getFirstDayOfWeek());
        System.out.println(cal2.get(Calendar.WEEK_OF_YEAR));
    }

    public static String[] getWeekInfo(Long timeInMillisSeconds) {
        String[] result = new String[4];




        return result;
    }

}
