package com.zhangshixu.java.demo.calendar.cal;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {
//	    // write your code here
//        Calendar calendar = Calendar.getInstance();
//        //calendar.setFirstDayOfWeek(Calendar.MONDAY);
//        calendar.setTime(new Date());
//        calendar.getWeeksInWeekYear();
//        System.out.println( "周数：" + calendar.get(Calendar.WEEK_OF_YEAR));
//        System.out.println( "该周第几天：" + calendar.get(Calendar.DAY_OF_WEEK));
//
//
//        //calendar.setFirstDayOfWeek(Calendar.MONDAY);
//
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        Date startOfWeek = calendar.getTime();
//        calendar.add(calendar.DATE, 6);
//        Date endOfWeek = calendar.getTime();
//        System.out.println("该周开始日期" + startOfWeek);
//        System.out.println("该周结束日期" + endOfWeek);
//        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        System.out.println(calendar.getTime());

//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getTime());
//
//        print(calendar.getWeekYear());
//        print(calendar.getFirstDayOfWeek());
//        print(calendar.getTimeInMillis());
//        print(calendar.getTime());
//        print(calendar.getWeeksInWeekYear());
//        print(calendar.getTimeZone());
//        print(calendar.getCalendarType());
//        print(calendar.getMinimalDaysInFirstWeek());

//        int i = Calendar.JANUARY;     //0
//        i = Calendar.FEBRUARY;
//        i = Calendar.MARCH;
//        i = Calendar.APRIL;
//        i = Calendar.MAY;
//        i = Calendar.JUNE;
//        i = Calendar.JULY;
//        i = Calendar.AUGUST;
//        i = Calendar.SEPTEMBER;
//        i = Calendar.OCTOBER;
//        i = Calendar.NOVEMBER;
//        i = Calendar.DECEMBER;        //11
//
//        int j = Calendar.SUNDAY;      //1
//        j = Calendar.MONDAY;
//        j = Calendar.TUESDAY;
//        j = Calendar.WEDNESDAY;
//        j = Calendar.THURSDAY;
//        j = Calendar.FRIDAY;
//        j = Calendar.SATURDAY;        //7
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            Long date = scanner.nextLong();
//            String[] result = getWeekDate(date, 0);
//            System.out.println("当前周");
//            System.out.println(result[0] + "  "+ result[1] + "  " + result[2] + "  " + result[3]);
//            result = getWeekDate(date, -7);
//            System.out.println("上一周");
//            System.out.println(result[0] + "  "+ result[1] + "  " + result[2] + "  " + result[3]);
//        }

//        System.out.println();
//

        //2017-06-05 07:59:59 GMT+8   1496620799000
        //2017-06-05 08:00:00 GMT+8   1496620800000
        //2017-06-05 00:00:00 GMT+8   1496592000000
        //2017-06-04 23:59:59 GMT+8   1496591999000

        long[] timeArr = new long[]{1496620799000L, 1496620800000L, 1496592000000L, 1496591999000L};

        for (int j=0; j< timeArr.length; j++) {
            String[] arr = getWeekDate(timeArr[j], 0);

            for(int i=0; i<arr.length; i++) {
                System.out.println(arr[i]);
            }

            System.out.println("*******************");
        }

//        String[] arr = getWeekDate(1496620799999L, 0);
//
//        for(int i=0; i<arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//
//        System.out.println("*******************");

//        arr = getWeekDateZhang(1496620800000L, 0);
//
//        for(int i=0; i<arr.length; i++) {
//            System.out.println(arr[i]);
//        }

    }

    //2017-06-05 07:59:59 GMT+8   1496620799000
    //2017-06-05 08:00:00 GMT+8   1496620800000
    //2017-06-05 00:00:00 GMT+8   1496592000000
    //2017-06-04 23:59:59 GMT+8   1496591999000

    public static String[] getWeekDate(Long str,int offset)
    {
        String[] result = new String[4];
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date date = new Date(str);
            Calendar cal =  Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            int weekno=cal.get(Calendar.WEEK_OF_YEAR);
            if (cal.get(Calendar.DAY_OF_WEEK) == 1) {          //当前日期是周日
                result[0] = String.valueOf(weekno - 1);
                result[3] = "7";
                cal.add(Calendar.DATE, -6);
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                cal.add(Calendar.DATE, offset);// 上周一的日期
                result[1] = sdf.format(cal.getTime());
                cal.add(Calendar.DATE,6);
                result[2] = sdf.format(cal.getTime());
            }
            else {
                result[0] = String.valueOf(weekno);
                result[3] = String.valueOf(cal.get(Calendar.DAY_OF_WEEK) - 1);
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                cal.add(Calendar.DATE, offset);// 上周一的日期
                result[1] = sdf.format(cal.getTime());
                cal.add(Calendar.DATE,6);
                result[2] = sdf.format(cal.getTime());
            }
            return result;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

        public static void print(Object object) {
            System.out.println(object);
        }

        public static String[] getWeekDateZhang(Long str,int offset)
        {
            System.out.println(new Date(str));
            String[] result = new String[4];
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(str);
                Calendar cal =  Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("GMT+0"));
                cal.setTime(date);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                int weekno=cal.get(Calendar.WEEK_OF_YEAR);
                if (cal.get(Calendar.DAY_OF_WEEK) == 1) {          //当前日期是周日
                    result[0] = String.valueOf(weekno - 1);
                    result[3] = "7";
                    cal.add(Calendar.DATE, -6);
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    cal.add(Calendar.DATE, offset);// 上周一的日期
                    result[1] = sdf.format(cal.getTime());
                    cal.add(Calendar.DATE,6);
                    result[2] = sdf.format(cal.getTime());
                }
                else {
                    result[0] = String.valueOf(weekno);
                    result[3] = String.valueOf(cal.get(Calendar.DAY_OF_WEEK) - 1);
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    cal.add(Calendar.DATE, offset);// 上周一的日期
                    result[1] = sdf.format(cal.getTime());
                    cal.add(Calendar.DATE,6);
                    result[2] = sdf.format(cal.getTime());
                }
                return result;
            }
            catch (Exception ex)
            {
                return null;
            }
        }

}
