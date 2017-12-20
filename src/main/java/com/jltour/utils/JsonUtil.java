package com.jltour.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/29 0029.
 */
public class JsonUtil {

    private static Gson gson = null;

    static {
        gson = new Gson();//todo yyyy-MM-dd HH:mm:ss
    }

    public static HashMap<String, Object> getJsonFromString(String jsonString) {
        HashMap<String, Object> result = new HashMap<>();
        int i = 0;
        while(i < jsonString.length() - 1) {
            int nextKeyIndex = i;
            i = jsonString.indexOf(":", i);
            if (i == -1) {
                return result;
            }
            String key = getKey(jsonString.substring(nextKeyIndex, i));
            if ("".equals(key)) {
                return result;
            }
            String valueString = getValueString(jsonString.substring(i + 1));
            Object value = getValue(valueString);
            if (value == null) {
                return result;
            }
            result.put(key, value);
            i = i + valueString.length() + 2;
        }
        return result;
    }

    private static String getKey(String keyString) {
        String key = "";
        if (keyString.endsWith("\"")) {
            key = keyString.substring(keyString.indexOf("\"") + 1, keyString.length()-1);
        }
        if(key.contains("\"")){
            key = "";
        }
        System.out.println("key = " + key);
        return key;
    }

    private static String getValueString(String jsonValueString){
        String result = "";
        if (jsonValueString.startsWith("{")) {
            int count = 0;
            for (int i = 0; i < jsonValueString.length(); i++) {
                if ("{".equals(String.valueOf(jsonValueString.charAt(i)))) {
                    count++;
                } else if ("}".equals(String.valueOf(jsonValueString.charAt(i)))) {
                    if (count == 1) {
                        result = jsonValueString.substring(0, i + 1);
                    }
                    count--;
                }
            }
        } else if (jsonValueString.startsWith("[")){
            int count = 0;
            for (int i = 0; i < jsonValueString.length(); i++) {
                if ("[".equals(String.valueOf(jsonValueString.charAt(i)))) {
                    count++;
                } else if ("]".equals(String.valueOf(jsonValueString.charAt(i)))) {
                    if (count == 1) {
                        result = jsonValueString.substring(0, i + 1);
                    }
                    count--;
                }
            }
        } else {
            int valueEndIndex = jsonValueString.indexOf(",");
            if (valueEndIndex == -1) {
                if (jsonValueString.endsWith("}")) {
                    result = jsonValueString.substring(0, jsonValueString.length() - 1);
                } else {
                    result = jsonValueString.substring(0, jsonValueString.length());
                }
            } else {
                result = jsonValueString.substring(0, valueEndIndex);
            }
        }
        System.out.println("ValueString = " + result);
        return result;
    }

    private static Object getValue (String jsonValueString) {
        Object result = null;
        if (jsonValueString.startsWith("{")) {
            result = getJsonFromString(jsonValueString);
        } else if (jsonValueString.startsWith("[")){
            ArrayList<Object> list = new ArrayList<Object>();
            String tmp = jsonValueString.substring(1, jsonValueString.length() -1);
            while(tmp.length() > 0) {
                String valueString = getValueString(tmp);
                Object value = getValue(valueString);
                list.add(value);
                if (tmp.length() == valueString.length()) {
                    tmp = "";
                } else {
                    tmp = tmp.substring(valueString.length() + 1, tmp.length());
                }
            }
            result = list;
        } else if (jsonValueString.startsWith("\"")) {
            result = jsonValueString.substring(1, jsonValueString.length()-1);
        } else {
            try {
                result = Integer.parseInt(jsonValueString);
            } catch(NumberFormatException e) {
                if ("true".equals(jsonValueString.toLowerCase())
                        || "false".equals(jsonValueString.toLowerCase())) {
                    result = Boolean.parseBoolean(jsonValueString);
                }
                result = jsonValueString;
            }
        }
        System.out.println("value = " + result.toString());
        return result;
    }

    public static synchronized Gson newInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static String objectToJson(Object ts) {
        String jsonStr = null;
        if (gson != null) {
            jsonStr = gson.toJson(ts);
        }
        return jsonStr;
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T toBean(String json, Class<T> clz) {

        return gson.fromJson(json, clz);
    }

    /**
     * 将json转换成vo
     * @param jsonStr
     * @param cl
     * @return
     */
    public static Object jsonToBean(String jsonStr, Class<?> cl) {
        Object obj = null;
        if (gson != null) {
            obj = gson.fromJson(jsonStr, cl);
        }
        return obj;
    }

    public static <T> Map<String, T> toMap(String json, Class<T> clz) {
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String, JsonObject>>() {
        }.getType());
        Map<String, T> result = new HashMap<>();
        for (String key : map.keySet()) {
            result.put(key, gson.fromJson(map.get(key), clz));
        }
        return result;
    }

    public static <T> List<T> toList(String json, Class<T> clz) {
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list = new ArrayList<>();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, clz));
        }
        return list;
    }

    /**
     * 将json格式转换成list对象，并准确指定类型
     * @param jsonStr
     * @param type
     * @return
     */
    public static List<?> jsonToList(String jsonStr, java.lang.reflect.Type type) {
        List<?> objList = null;
        if (gson != null) {
            objList = gson.fromJson(jsonStr, type);
        }
        return objList;
    }

    public static Map<String, String> jsonToMap(String jsonStr) {
        Map<String, String> objMap = null;
        if (gson != null) {
            java.lang.reflect.Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            objMap = gson.fromJson(jsonStr, type);
        }
        return objMap;
    }
}
