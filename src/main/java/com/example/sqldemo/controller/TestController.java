package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import com.example.sqldemo.entity.Orders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class TestController {

    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:06
      * @Description 数据库功能测试
      */
    @RequestMapping("/test")
    public String say(){
        //String a = "DONE";
        DataTest test = new DataTest();
        //删除一个数据
        //test.dele("17");
        //添加一个数据
        Orders orders = new Orders();
        //test.add(orders);

        //test.myrule();
        //查询全部数据
        String a = test.findAll();
        //查询所有数据
        //String a = test.findOne(1);
        //按天数查询数据
        //String a = test.getandSort(201704);
        return a;
    }
}
