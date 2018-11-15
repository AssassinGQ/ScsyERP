package cn.AssassinG.ScsyERP.common.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static String getRandomStr(int length){
        char[] ret = new char[length];
        Random random = new Random();
        for(int i = 0; i < length; i++)
            ret[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        return new String(ret);
    }

    public static boolean isMobileNum(String number){
        if(number == null)
            return false;
        Pattern p = Pattern.compile("^((13[0-9])|(14[57])|(15[^4,\\D])|(17[5678])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
