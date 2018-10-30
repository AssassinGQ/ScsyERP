package cn.AssassinG.ScsyERP.common.utils;

import java.util.Random;

public class StringUtils {
    public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static String getRandomStr(int length){
        char[] ret = new char[length];
        Random random = new Random();
        for(int i = 0; i < length; i++)
            ret[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        return new String(ret);
    }
}
