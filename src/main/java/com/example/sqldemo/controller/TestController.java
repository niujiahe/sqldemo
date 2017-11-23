package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import com.example.sqldemo.entity.Orders;
import com.example.sqldemo.entity.StatisticsTimeType;
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
        Integer a = 0;
        DataTest test = new DataTest();
        //删除一个数据
        //test.dele("17");
        //添加一个数据
        //Orders orders = new Orders();
        //String orders = "order_id=999&order_sn=aaa&total_price=900&order_time=2007-04-09 13:20:13";
        //test.add(orders);

        String statistics_time_type = StatisticsTimeType.DAY.toString();
        String ruleadd = "create_by=NJH&create_time=2017-04-09 13:20:10&statistics_time_value=2017-04-09 13:20:10;2017-04-12 13:20:14&rule_id=1&statistics_time_type="+statistics_time_type;
        //test.ruleAdd(ruleadd);


        //a=test.getMaxid();

        //test.myrule();
        //查询全部数据
        //String a = test.findAll();
        //查询所有数据
        //String a = test.findOne(1);
        //按天数查询数据
        //String a = test.getandSort(201704);
        return ruleadd;
    }
}
