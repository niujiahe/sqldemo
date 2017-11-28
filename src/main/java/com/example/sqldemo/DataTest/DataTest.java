package com.example.sqldemo.DataTest;
import com.example.sqldemo.entity.Orders;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.net.URLConnection;
import java.util.List;

@Repository
public class DataTest {

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

    public static String findAll(){
        String s = sendGet("http://localhost:8080//order", null);
        System.out.println(s);
        return s;
    }

    public static String findOne(int id) {
        //发送 GET 请求 查询一个用户数据
        String s = sendGet("http://localhost:8080/order/"+id, null);
        System.out.println(s);
        return s;
    }

    public static String getandSort(int yearday){
        String s = sendGet("http://localhost:8080/getsort/"+yearday, null);
        System.out.println(s);
        return s;
    }

    public static String add(String param){
        //发送 POST 请求 添加一个用户数据
        //String sr=sendPost("http://localhost:8081/springboot/person/","name=user&age=22");
        String sr=sendPost("http://localhost:8080/order/",param);
        System.out.println(sr);
        return sr;
    }

    public static String dele(String param){
        String sr=sendPost("http://localhost:8080/person/",param);
        System.out.println(sr);
        return sr;
    }

    //对于规则表的操作
    public static String ruleAdd(String param) {
        String sr=sendPost("http://localhost:8080/addrule/",param);
        System.out.println(sr);
        return sr;
    }

    /**
      * @Author 牛家禾
      * @Date 2017/11/23 14:38
      * @Description 并行输入数据的模拟
      */

    private static int thread_num = 10;
    private static int client_num = 100;

    public static void OrderSim() {
        List<String> ordersList = new ArrayList<>();
        // TODO Auto-generated method stub
        ExecutorService exec = Executors.newCachedThreadPool();
        // 10个线程可以同时访问
        final Semaphore semp = new Semaphore(thread_num);
        // 模拟100个客户端访问
        for (int index = 0; index < client_num; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Thread:" + NO);
                        String host = "http://localhost:8080/order/";
                        String para = getRandomOrder();
                        String sr=sendPost("http://localhost:8080/order/",para);
                        System.out.println(host + para);
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
    private static String getRandomOrder() {
        Random ra =new Random();

        String test_price  = (ra.nextInt(5)+1)*100+"";
        String test_time   = "2017-04-"+(ra.nextInt(29)+1)+" "+ra.nextInt(24)+":00:00";

        String orders = "order_id=999&order_sn=test&total_price="+test_price+"&order_time="+test_time;

        return orders;
    }



}
