package com.jltour.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuzhaolin on 2017/1/5.
 */
public class MapUtil {

    public static Map<String,Object> generate(String[] keys,Object[] values) {
        if (keys != null && values != null && keys.length == values.length) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0, len = keys.length; i < len; i++) {
                map.put(keys[i], values[i]);
            }
            return map;
        }
        return null;
    }

    public static String mapJoin(Map<String, String> map, boolean keyLower, boolean valueUrlencode){
        StringBuilder stringBuilder = new StringBuilder();
        for(String key :map.keySet()){
            if(map.get(key)!=null&&!"".equals(map.get(key))){
                try {
                    String temp = (key.endsWith("_")&&key.length()>1)?key.substring(0,key.length()-1):key;
                    stringBuilder.append(keyLower?temp.toLowerCase():temp)
                            .append("=")
                            .append(valueUrlencode? URLEncoder.encode(map.get(key),"utf-8").replace("+", "%20"):map.get(key))
                            .append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if(stringBuilder.length()>0){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }

    public static Map resultInfo(String info, boolean status) {
        Map map = new HashMap();
        map.put("result", info);
        map.put("status", status);
        return map;
    }
}
