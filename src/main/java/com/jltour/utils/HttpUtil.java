package com.jltour.utils;



import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
/**
 * Created by Administrator on 2017/12/17 0017.
 */
public class HttpUtil {

    /**
     * 发送get请求
     *
     * @param url     请求地址
     * @param charset 获取结果编码 默认utf8
     * @return 请求结果
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public static String sendGet(String url, String charset) throws Exception {
        String result = "";
        BufferedReader in = null;
        try {
            if (null == url || "".equals(url)) {
                return "";
            } else {
                url = url.indexOf("?") != -1 ? url : url + "?";
            }
            charset = (null == charset || "".equals(charset)) ? "utf-8" : charset;//默认编码为utf8
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();// 打开和URL之间的连接
            connection.setRequestProperty("accept", "*/*");// 设置通用的请求属性
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setReadTimeout(1000);
            connection.connect();// 建立实际的连接
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));// 定义 BufferedReader输入流来读取URL的响应

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } finally {
            if (in != null) in.close();//关闭输入流
        }
        return result;
    }

    /**
     * 发送Get请求
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param header  请求头
     * @param charset 请求编码默认utf8
     *                请求结果
     * @throws Exception
     */
    public static String sendGet(String url, Map<String, String> params, Map<String, String> header, String charset) throws Exception {
        String result = "";
        BufferedReader in = null;
        try {
            if (null == url || "".equals(url)) {
                return "";
            } else {
                url = url.indexOf("?") != -1 ? url : url + "?";
            }
            charset = (null == charset || "".equals(charset)) ? "utf-8" : charset;//默认编码为utf8
            StringBuffer buffer = new StringBuffer();
            if (params != null && !params.isEmpty()) {//组装参数
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if (null != entry.getValue() && !"".equals(entry.getValue())) {
                        buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), charset)).append("&");
                    }

                }
            }
            buffer.deleteCharAt(buffer.length() - 1);//截取末尾&
           // System.out.println(url + buffer.toString());
            URL realUrl = new URL(url + buffer.toString());
            URLConnection connection = realUrl.openConnection();// 打开和URL之间的连接
            connection.setRequestProperty("accept", "*/*");// 设置通用的请求属性
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if (header != null && !header.isEmpty()) {
                for (String str : header.keySet()) {
                    if (!StringUtils.isBlank(header.get(str))) {
                        connection.setRequestProperty(str, header.get(str));
                    }
                }
            }
            connection.connect();// 建立实际的连接
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));// 定义 BufferedReader输入流来读取URL的响应
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } finally {
            if (in != null) in.close();//关闭输入流
        }
        return result;
    }

    /**
     * POST请求，字符串形式数据
     *
     * @param url     请求地址
     * @param param   请求数据
     * @param charset 编码方式 默认为utf8
     * @return 请求结果
     * @throws IOException
     */
    public static String sendPost(String url, String param, String charset) throws Exception {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            if (null == url || "".equals(url)) {
                return "";
            } else {
                url = url.indexOf("?") != -1 ? url : url + " ? ";
            }
            charset = (null == charset || "".equals(charset)) ? "utf-8" : charset;//默认编码为utf8
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();// 打开和URL之间的连接
            conn.setRequestProperty("accept", "*/*");// 设置通用的请求属性
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);// 发送POST请求必须设置如下两行
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());// 获取URLConnection对象对应的输出流
            out.print(param);// 发送请求参数
            out.flush();// flush输出流的缓冲
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));// 定义BufferedReader输入流来读取URL的响应
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } finally {
            if (out != null) out.close();//关闭输出流
            if (in != null) in.close();//关闭输入流
        }
        return result;
    }

    /**
     * POST请求，Map形式数据
     *
     * @param url     请求地址
     * @param param   请求数据
     * @param charset 编码方式 默认为utf8
     * @return 请求返回结果
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public static String sendPost(String url, Map<String, String> param, String charset) throws Exception {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";//获取结果
        try {
            if (null == url || "".equals(url)) {
                return "";
            } else {
                url = url.indexOf("?") != -1 ? url : url + "?";
            }
            charset = (null == charset || "".equals(charset)) ? "utf-8" : charset;//默认编码为utf8
            StringBuffer buffer = new StringBuffer("&");
            if (param != null && !param.isEmpty()) {//组装参数
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    String k = entry.getKey();
                    Object v = entry.getValue();
                    if (StringUtils.isBlank(v.toString())) {// 过滤空值
                        continue;
                    }
                    buffer.append(k).append("=").append(v).append("&");
                }
            }
            buffer.deleteCharAt(buffer.length() - 1);//截取末尾&
            URL realUrl = new URL(url);// 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();//开始请求
            conn.setRequestProperty("accept", "*/*");// 设置通用的请求属性
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);// 发送POST请求必须设置如下两行
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());// 获取URLConnection对象对应的输出流
            out.print(buffer);// 发送请求参数
            out.flush();// flush输出流的缓冲
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));// 定义BufferedReader输入流来读取URL的响应
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } finally {
            if (out != null) out.close();//关闭输出流
            if (in != null) in.close();//关闭输入流
        }
        return result;
    }

    /**
     * 利用URL发起POST请求，并接收返回信息(for Osii)
     *
     * @param url        请求URL
     * @param paramsJson 请求参数
     * @return 响应内容
     * @throws Exception
     */
    public static String postOsii(String url, String paramsJson) {
        if (!url.toLowerCase().startsWith("http://")) {
            return "非 http请求";
        }

        try {
            URL u = new URL(url);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(60000);// 设置超时
            connection.setReadTimeout(60000);// 设置读取超时
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(paramsJson);
            out.flush();
            out.close();
            // 读取响应
            int length = (int) connection.getContentLength();// 获取长度
            InputStream is = connection.getInputStream();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"body\": {}" +
                    "    \"head\": {\n" +
                    "        \"status\": 1,\n" +
                    "        \"responseCode\": \"0000\",\n" +
                    "        \"responseDescription\": \"连接PMS异常\"\n" +
                    "    }\n" +
                    "}\n";
        }
        return "{\\\"body\\\": {}\" +\n" +
                "\t\t\t\t\t\"    \\\"head\\\": {\\n\" +\n" +
                "\t\t\t\t\t\"        \\\"status\\\": 1,\\n\" +\n" +
                "\t\t\t\t\t\"        \\\"responseCode\\\": \\\"0000\\\",\\n\" +\n" +
                "\t\t\t\t\t\"        \\\"responseDescription\\\": \\\"连接PMS异常\\\"\\n\" +\n" +
                "\t\t\t\t\t\"    }\\n\" +\n" +
                "\t\t\t\t\t\"}\\n";
    }
}
