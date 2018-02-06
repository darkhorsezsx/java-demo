package com.zhangshixu.java.demo.calendar.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * This is {@link DateFormat}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class DateFormat {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat formatChinese = new SimpleDateFormat("G yyyy-MM-dd 今年第w周，本月第W周，本年第DDD天，本月第dd天，本周第F天；今天是E，u，HH:mm:ss Z", Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        String timeStr = formatChinese.format(calendar.getTime());
        System.out.println(Locale.CHINA + "  " +timeStr);

        SimpleDateFormat formatEn = new SimpleDateFormat("G yyyy-MM-dd 今年第w周，本月第W周，本年第DDD天，本月第dd天，本周第F天；今天是E，u，HH:mm:ss Z", Locale.ENGLISH);
        timeStr = formatEn.format(calendar.getTime());
        System.out.println(Locale.ENGLISH + "  " +timeStr);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        sf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date posttime =sf.parse("2017-05-09");
        System.out.println(posttime);

        sf = new SimpleDateFormat("yyyy-MM-dd");
        sf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        posttime =sf.parse("2017-05-09");
        System.out.println(posttime);



        StringBuilder sb = new StringBuilder();
        sb.append("SELECT e.content,e.title,e.title_color ,substr(E.show_date,0,10) show_date,EPS_ARTICLE_SIGN.Create_Date approvedDate,EPS_ARTICLE_SIGN.Content approvedContent,e.ext_Str12 approved, e.dept_name");
        sb.append(" FROM EPS_ENTITY e");
        sb.append(" left join EPS_ARTICLE_SIGN on EPS_ARTICLE_SIGN.Article_Key = e.key");
        sb.append(" where 1=1");
        sb.append(" and e.id = ?");
        sb.append(" and e.key = ? ORDER BY E.show_date DESC");

        String sqlStr = sb.toString();
        System.out.println(sqlStr);

//        String str = String.format("%d.html", posttime.getTime());
//        System.out.println(str);
    }

}
