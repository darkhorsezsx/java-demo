package com.zhangshixu.java.demo.blahblah;

import org.apache.commons.lang3.StringUtils;

/**
 * This is {@link VersionTransfer}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class VersionTransfer {

    public static String[] versions = {
//            "1.1.4",
//            "1.2.6",
//            "1.12.1",
//            "1.2.4 alpha1",
//            "1.2.4 BETA1",
//            "1.2.4 RC1",
            "1.2.999 rc999",
            "1.3.0"
    };

    public static String[] qualifiers = {
            "alpha",
            "beta",
            "rc"
    };

    public static Long[] scopes= {
            100000000000L,
            100000000L,
            100000L,
            100L,
            1L
    };

    public static void main(String[] args) {
        for (String str : versions) {
            Long value = transfer(str);
            System.out.println(value);
        }
//        transfer("1.2.4");
    }


    public static Long transfer(String version) {
        version = version.toLowerCase();
        Long result = 0L;
        int qualifierTag = -1;
        version = version.replace(" ", ".");
        for (int i = 0; i < qualifiers.length; i++) {
            if (version.contains(qualifiers[i])) {
                qualifierTag = i;
                version = version.replace(qualifiers[i], "");
                break;
            }
        }

        String[] verArray = version.split("\\.");
        for (int i=0; i < verArray.length; i++) {
            String str = verArray[i];
            int value = 0;
            value = Integer.parseInt(str);
            result += scopes[i] * value;
        }
        if (qualifierTag == -1) {
            result += 999 * scopes[3] + 99 * scopes[4];
        }
        return result;
    }

}
