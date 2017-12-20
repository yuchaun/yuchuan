package com.jltour.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xuzhaolin on 2017/5/19.
 */
public class PasswordUtils {

    public static boolean checkPassword(String password, String salt, String passwordHash){
        if(encryptBySHA(new StringBuilder(password).append(salt).toString()).equals(passwordHash)){
            return true;
        }else{
            return false;
        }
    }

    public static String encryptBySHA(String password)  {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        String encryptedStr = bytes2Hex(md.digest());
        return encryptedStr;
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
