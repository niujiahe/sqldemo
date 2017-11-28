package com.example.sqldemo.controller;

import com.example.sqldemo.DataTest.DataTest;
import com.example.sqldemo.entity.Orders;
import com.example.sqldemo.entity.StatisticsTimeType;
import com.example.sqldemo.mapper.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    OrdersRepository ordersRepository;
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:06
      * @Description 数据库功能测试
      */
    @RequestMapping("/orderadd")
    public List<Orders> say(){
        Integer a = 0;
        DataTest test = new DataTest();
        return ordersRepository.findAll();

        //添加一个数据
        //Orders orders = new Orders();
        //String orders = "order_id=999&order_sn=aaa&total_price=900&order_time=2007-04-09 13:20:13";
        //test.add(orders);

        //添加一个规则
        //String statistics_time_type = StatisticsTimeType.DAY.toString();
        //String ruleadd = "create_by=NJH&create_time=2017-04-09 13:20:10&statistics_time_value=2017-04-09 00:00:00;2017-04-12 23:59:59&rule_id=2&statistics_time_type="+statistics_time_type;
        //test.ruleAdd(ruleadd);
        //Timestamp time1 = Timestamp.valueOf("2017-04-7 19:00:00");
    }
}
