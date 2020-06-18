package cn.even.kingsum.origin.util;

import com.sun.net.ssl.internal.www.protocol.https.Handler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static sun.rmi.transport.TransportConstants.Magic;

/**
 * Created by Administrator on 2017/6/4.
 */
public class SystemUtil {

    /**
     * 根椐网址得到返回的字符串</br>
     *
     * @param url 传入的网址
     */
    public static String responseText(String url, Map<String, String> args) {

        StringBuffer ret = new StringBuffer();
        try {
            InputStream inputStream = getInputStream(url, args);
            if (inputStream != null) {
                BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = buf.readLine()) != null) {
                    ret.append(line);
                }
            } else {
                System.out.println("InputStream is null");
            }
            return ret.toString();

        } catch (Exception e) {
            System.err.println(url);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根椐网址得到返回的字符串</br>
     *
     * @param url 传入的网址
     */
    public static String responseText(String url) {
        return responseText(url, null);
    }

    public static String postObject(String urlStr, Map<String, String> textMap, Map<String, String> fileMap) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }

            // file
            if (fileMap != null) {
                Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();

                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
                    strBuf.append("Content-Type: image/jpeg"  + "\r\n\r\n");
                    out.write(strBuf.toString().getBytes());

                    DataInputStream in = new DataInputStream(new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }



    public static InputStream getInputStream(String uri, Map<String, String> args) {
        try {
            HttpURLConnection conn = null;
            URL url = new URL(null, uri, new Handler());
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");

            conn.setUseCaches(false);
            conn.setConnectTimeout(10 * 1000);

            if (args != null) {
                Set<String> key = args.keySet();
                for (String k : key) {
                    conn.setRequestProperty(k, args.get(k));
                }
            }

            InputStream inputStream = conn.getInputStream();
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回网页的bytes
     */
    public static InputStream getInputStream(String urlStr, String requestMethod) {
        return getInputStream(urlStr, null, requestMethod);
    }

    /**
     * 返回网页的bytes,传MAP类型的参数
     *
     * @param urlStr 清求的地址
     * @data 转入的参数
     */
    public static InputStream getInputStream(String urlStr, String data, String requestMethod) {
        try {
            HttpURLConnection conn = null;
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(requestMethod);

            conn.setUseCaches(false);
            conn.setConnectTimeout(10 * 1000);
            if (data != null) {
                OutputStream os = conn.getOutputStream();
                os.write(data.getBytes("UTF-8"));
            }
            return conn.getInputStream();
        } catch (Exception e) {
            System.err.println(urlStr);
            e.printStackTrace();
            return null;
        }
    }

    public static String inputStreamToStr(InputStream inputStream) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line = null;
            StringBuffer ret = new StringBuffer();
            while ((line = buf.readLine()) != null) {
                if (line == " ") {
                    System.out.println("=======  NULL  =========");
                }
                ret.append(line);
            }

            return ret.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * map转url格式
     */
    public static String mapToUrl(Map<String, String> map) {
        StringBuffer xmlTemp = new StringBuffer();
        if (map != null) {
            List<String> mapKey = new ArrayList<>(map.keySet());
            Collections.sort(mapKey);

            Iterator<String> iter = mapKey.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                xmlTemp.append("&" + key + "=" + map.get(key));
            }
        }

        return xmlTemp.substring(1);
    }

}
