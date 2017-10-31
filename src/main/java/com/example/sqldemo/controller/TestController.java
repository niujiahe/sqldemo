package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:06
      * @Description 数据库功能测试
      */
    @RequestMapping("/test")
    public String say(){
        DataTest test = new DataTest();
        //添加一个数据
        //return test.Add("order_id=009&order_sn=jjj&total_price=800&order_time=2017-04-12 13:20:13.0");
        //查询全部数据
        //String a = test.findall();
        //查询所有数据
        //String a = test.findOne(1);
        //按天数查询数据
        String a = test.getandSort(201704);
        return a;
    }
}
