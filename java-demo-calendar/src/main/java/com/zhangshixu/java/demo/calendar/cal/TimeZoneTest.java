package com.zhangshixu.java.demo.calendar.cal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * This is {@link TimeZoneTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class TimeZoneTest {

    public static void main(String[] args) throws Exception {

        /**
         * 对于字符串的时间，并没有时区的概念，所以在解析的时候回将该时间默认为零时区的时间，
         * PS：1. 这个和SimpleDateFormat设置哪个时区并没有关系
         *     2. 在使用SimpleDateFormat进行字符串转为Date的时候，JVM会使用操作系统的时区把刚刚零时区对应的时间转换为当前时区的时间
         */

        String dateStr = "2017-05-31 22:09:00";   //零时区的2017年5月31日22点10分00秒


        /**
         * 在new 出SimpleDateFormat实例后，如果不指定时区，会使用系统默认的时区；
         * 也就是说，如果在使用TimeZone.setDefault进行本地时区默认设置的时候，这部操作需要在SimpleDateFormat实例化之前，否则SimpleDateFormat的时区就不是预期的值了*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //全部采用系统默认时区 GMT+8  打印出时间为
        System.out.println("东八区");
        System.out.println("dateFormat TimeZone: " + dateFormat.getTimeZone());   //中国时区东八区  sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
        Date dateTmp = dateFormat.parse(dateStr);
        Long timeStamp = dateTmp.getTime();
        System.out.println(dateTmp);    //Wed May 31 22:09:00 CST 2017
        System.out.println(timeStamp);      //1496239740000

        System.out.println("*************************");

        //全部采用系统默认时区 GMT
        System.out.println("零时区");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("dateFormat TimeZone: " + dateFormat.getTimeZone());     //零时区 sun.util.calendar.ZoneInfo[id="GMT",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null]
        dateTmp = dateFormat.parse(dateStr);
        timeStamp = dateTmp.getTime();
        System.out.println(dateTmp);        //Wed May 31 22:09:00 GMT 2017
        System.out.println(timeStamp);      //1496268540000

        System.out.println("*************************");

        //默认零时区，解析使用东八区
        System.out.println("系统默认零时区，解析使用东八区");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println("dateFormat TimeZone: " + dateFormat.getTimeZone());     //东八区 sun.util.calendar.ZoneInfo[id="GMT+08:00",offset=28800000,dstSavings=0,useDaylight=false,transitions=0,lastRule=null]
        dateTmp = dateFormat.parse(dateStr);       //在内部解析的时候，会转换成long型值，再根据默认时区转换成Date类型
        timeStamp = dateTmp.getTime();
        System.out.println(dateTmp);        //Wed May 31 14:09:00 GMT 2017
        System.out.println(timeStamp);      //1496239740000

        System.out.println("*************************");

        //默认东八时区，解析使用零时区
        System.out.println("系统默认零时区，解析使用东八区");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("dateFormat TimeZone: " + dateFormat.getTimeZone());     //零时区 sun.util.calendar.ZoneInfo[id="GMT+08:00",offset=28800000,dstSavings=0,useDaylight=false,transitions=0,lastRule=null]
        dateTmp = dateFormat.parse(dateStr);       //在内部解析的时候，会转换成long型值，再根据默认时区转换成Date类型
        timeStamp = dateTmp.getTime();
        System.out.println(dateTmp);        //Thu Jun 01 06:09:00 GMT+08:00 2017
        System.out.println(timeStamp);      //1496268540000

        System.out.println("*************************");


        /**
         * 总结
         * 其实字符串和long都是没有时区的概念的，所谓没有时区可以理解为都是默认零时区
         * 因为对于东八区的 2017年5月31日22时10分0秒 和 零时区的 2017年5月31日 14时10分0秒 的 long型值是一样的
         *
         * 一个字符串解析为Date类型的过程是：
         * SimpleDateFormat实例化，是否制定了时区？ 指定了的话使用指定的时区，未指定则使用默认的时区
         * SimpleDateFormat对象将字符串根据自身的时区设置转换为long型值，这个值与时区无关，或者这个值是零时区的绝对时间
         * Date类在构造时，会自动根据时区将long转换为对应时区内的时间戳
         *
         *
         */

        //全部采用系统默认时区 GMT
        System.out.println("零时区");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("dateFormat TimeZone: " + dateFormat.getTimeZone());     //零时区 sun.util.calendar.ZoneInfo[id="GMT",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null]
        dateTmp = dateFormat.parse("2017-05-31 14:09:00");
        timeStamp = dateTmp.getTime();
        System.out.println(dateTmp);        //Wed May 31 22:09:00 GMT 2017
        System.out.println(timeStamp);      //1496268540000

        System.out.println("*************************");


        //下面两例说明了 同一个时间点上，任意一个时区使用Date.getTime得到的UnixTimestamp应该是一致的，不同之处在于，当转换成Date等类型的时候，内部会考虑当前的时区，并对该时间戳进行时区上的加和减
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Date date = new Date();

        System.out.println(date.getTime());

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        date = new Date();
        System.out.println(date.getTime());




//        Date date = new Date(1496239800000L);// 2013-1-31 22:17:14
//        String dateStrTmp = dateFormat.format(date);
//        System.out.println(dateStrTmp);
    }

}
