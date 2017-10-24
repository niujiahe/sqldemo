package com.example.sqldemo.DataTest;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.List;
import java.io.IOException;



public class DataTest {
    private static int thread_num = 1;
    private static int client_num = 1;
    private static Map keywordMap = new HashMap();
    static {
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream(
            //        new File("clicks.txt")), "GBK");
            //BufferedReader buffer = new BufferedReader(isr);
            //String line = "";
            //while ((line = buffer.readLine()) != null) {
            //    keywordMap.put(line.substring(0, line.lastIndexOf(":")), "");
            //}
            for (int i=0;i<230;i++){
                keywordMap.put(1,2);

                keywordMap.put(3,4);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    //查询一个数据
    public static String main() {
        //发送 GET 请求 查询一个用户数据
        String s = sendGet("http://localhost:8081/springboot/person/1", null);
        System.out.println(s);
        return s;
    }

    //添加一个数据
    public static String Add(String param){
        //发送 POST 请求 添加一个用户数据
        //String sr=sendPost("http://localhost:8081/springboot/person/","name=user&age=22");
        String sr=sendPost("http://localhost:8081/springboot/person/",param);
        System.out.println(sr);
        return sr;
    }

    //删除一个数据
    public static String dele(String param){
        String sr=sendPost("http://localhost:8081/springboot/person/",param);
        System.out.println(sr);
        return sr;
    }


    public static void main2() {
        int size = keywordMap.size();
        // TODO Auto-generated method stub
        ExecutorService exec = Executors.newCachedThreadPool();
        // 50个线程可以同时访问
        final Semaphore semp = new Semaphore(thread_num);
        // 模拟2000个客户端访问
        for (int index = 0; index < client_num; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Thread:" + NO);
                        String host = "http://localhost:8081/springboot/person";
                        String para = "？name='TestUser'";
                        System.out.println(host + para);
                        URL url = new URL(host+para);// 此处填写供测试的url
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        // connection.setRequestMethod("POST");
                        // connection.setRequestProperty("Proxy-Connection",
                        // "Keep-Alive");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);

                        PrintWriter out = new PrintWriter(connection.getOutputStream());
                        out.print(para);
                        out.flush();
                        out.close();
                        System.out.println("output");
                        /*BufferedReader in = new BufferedReader(
                                new InputStreamReader(connection
                                        .getInputStream()));
                        String line = "";
                        String result = "";
                        while ((line = in.readLine()) != null) {
                            result += line;
                        }*/
                        // System.out.println(result);
                        // Thread.sleep((long) (Math.random()) * 1000);
                        // 释放
                        System.out.println("第：" + NO + " 个");
                        semp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
    /*private static String getRandomSearchKey(final int no) {
        String ret = "";
        int size = keywordMap.size();
        // int wanna = (int) (Math.random()) * (size - 1);
        ret = (keywordMap.entrySet().toArray())[no].toString();
        ret = ret.substring(0, ret.lastIndexOf("="));
        System.out.println("\t" + ret);
        return ret;
    }*/
    private static String getRandomSearchKey2(final int no) {
        String ret = "TEST";
        return ret;
    }
}
