import java.util.*;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //char c = 19968 (4e00)最后一个中文字，char c = 40891 (9FBB)
//        getSubStr("ABC", 2);
//
//        getSubStr("我ABC", 2);

        String str = "我ABC";

        getSubStr(str, 4);


    }

    public static String getSubStr(String str, int count) throws Exception {

//        System.out.println(str.length());
//        byte[] arr = str.getBytes();
//        for (int i=0; i< arr.length; i++) {
//            System.out.print(arr[i] + "  ");
//        }
//        System.out.println();
//
//        char[] charArr = str.toCharArray();
//        for (int j=0; j<charArr.length; j++) {
//            System.out.print(charArr[j] + 0);
//            System.out.print("  ");
//        }
//        System.out.println();

        Properties properties = System.getProperties();
        Set<Object> keys = properties.keySet();
        for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
            String key = iterator.next().toString();
            System.out.println(key + "  " + properties.getProperty(key));
        }

        String fileEncoding = System.getProperty("file.encoding");
        if (fileEncoding.equalsIgnoreCase("utf-8")) {
            byte[] arr = str.getBytes("UTF-8");

        }
        System.out.println(fileEncoding);

        return null;
    }

}
