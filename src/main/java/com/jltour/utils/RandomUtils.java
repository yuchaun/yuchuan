package com.jltour.utils;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final String RANDOM_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static final String RANDOM_NUMBER_STR="0123456789";

    public static String getRandomNumber() {
        return getRandomNumberStr(6,RANDOM_STR);
    }
     public static String getRandomCodeStr(){
         return getRandomNumberStr(6,RANDOM_NUMBER_STR);
     }

    public static  String getUserToken() {
        return getRandomNumberStr(12, RANDOM_STR);
    }

    private static String getRandomNumberStr(int length,String randomStr) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; ++i) {
            sb.append(randomStr.charAt(random.nextInt(randomStr.length())));
        }
        return sb.toString();
    }

    /**
     * 二维码乱码
     * @return
     */
    public static String getPickQr(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 微信支付随机字符串
     * @return
     */
    public static String getNonceStr() {
        return getRandomString(32);
    }

    public static String getRandomString(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i <length;i++){
            int number = ThreadLocalRandom.current().nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
