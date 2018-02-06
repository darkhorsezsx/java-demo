import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.sun.javafx.binding.StringFormatter;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Calendar.JANUARY;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] agrgs) throws Exception {

        String input = "28527a53-7419-4889-9536-71835d3c6410J%d3m4b3c6495-780c-4b7f-818f-38dc02a0f953";

        // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）

        MessageDigest messageDigest =MessageDigest.getInstance("MD5");


        // 输入的字符串转换成字节数组

        byte[] inputByteArray = input.getBytes();



        // inputByteArray是输入字符串转换得到的字节数组

        messageDigest.update(inputByteArray);



        // 转换并返回结果，也是字节数组，包含16个元素

        byte[] resultByteArray = messageDigest.digest();



        // 字符数组转换成字符串返回

        System.out.println(byteArrayToHex(resultByteArray));

    }

    public static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））

        char[] resultCharArray = new char[byteArray.length * 2];

        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去

        int index = 0;
        for (byte b : byteArray) {

            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];

        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }

        //获取周数、周一及周日的数据
    public static String[] getWeekDate(Long str,int offset)
    {
        String[] result = new String[4];
        Calendar cal =  Calendar.getInstance();
        System.out.println(cal.getMinimalDaysInFirstWeek());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date date = new Date(str);

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

    public static String[] getWeekDate2(Long str,int offset) {
        String[] result = new String[4];
        Calendar cal =  Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTimeInMillis(str);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date date = cal.getTime();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        int weekno=cal.get(Calendar.WEEK_OF_YEAR);
        result[0] = String.valueOf(weekno);
        result[3] = String.valueOf(cal.get(Calendar.DAY_OF_WEEK) - 1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.DATE, offset);// 上周一的日期
        result[1] = sdf.format(cal.getTime());
        cal.add(Calendar.DATE,6);
        result[2] = sdf.format(cal.getTime());
        return result;
    }

}
