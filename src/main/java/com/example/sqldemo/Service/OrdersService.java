package com.example.sqldemo.Service;

import com.example.sqldemo.dao.OrdersRepository;
import com.example.sqldemo.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:19
      * @Description
          * 事务管理测试
          * 两条数据同时成功，或者同时不成功
          * 保证数据库数据的完整性和一致性
      */
    @Transactional
    public void insertTwo(){
        Orders orderA = new Orders();
        orderA.setOrder_id("002");
        orderA.setOrder_sn("bbb");
        orderA.setTotal_price(200);
        orderA.setOrder_time(Timestamp.valueOf("2017-03-09 13:20:13.0"));
        ordersRepository.save(orderA);

        System.out.print(1/0);

        Orders orderB = new Orders();
        orderB.setOrder_id("003");
        orderB.setOrder_sn("ccc");
        orderB.setTotal_price(300);
        orderB.setOrder_time(Timestamp.valueOf("2017-02-09 13:20:13.0"));
        ordersRepository.save(orderB);
    }
}
