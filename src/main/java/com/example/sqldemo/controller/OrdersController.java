package com.example.sqldemo.controller;

import com.example.sqldemo.Service.OrdersService;
import com.example.sqldemo.entity.sys_statistics_ruleInfo;
import com.example.sqldemo.mapper.OrdersRepository;
import com.example.sqldemo.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersService ordersService;

    @GetMapping(value = "/order")
    private List<Orders> orderList() {
        return ordersRepository.findAll();
    }

    /**
     * @Author 牛家禾
     * @Date 2017/10/31 10:02
     * @Description 添加一个订单数据
     */
    @PostMapping(value = "/order")
    public Orders orderAdd(@RequestParam("order_id") String order_id,
                           @RequestParam("order_sn") String order_sn,
                           @RequestParam("total_price") Integer total_price,
                           @RequestParam("order_time")Timestamp order_time) {


        Orders orders = new Orders();
        orders.setOrder_id(order_id);
        orders.setOrder_sn(order_sn);
        orders.setTotal_price(total_price);
        orders.setOrder_time(order_time);

        ordersRepository.save(orders);
        return orders;
    }

    @GetMapping(value = "/order/{id}")
    public Orders orderFindOne(@PathVariable("id") Integer id) {
        return ordersRepository.findOne(id);
    }

    /**
     * @Author 牛家禾
     * @Date 2017/10/31 10:03
     * @Description 删除一个数据
     */
    @DeleteMapping(value = "/order/{id}")
    public void orderDelete(@PathVariable("id") Integer id) {
        ordersRepository.delete(id);
    }

    /**
     * @Author 牛家禾
     * @Date 2017/10/31 10:04
     * @Description 更新一个数据
     */
    @PutMapping(value = "/order/{id}")
    public Orders personUpdate(@PathVariable("id") Integer id,
                               @RequestParam("order_id") String order_id,
                               @RequestParam("order_sn") String order_sn,
                               @RequestParam("total_price") Integer total_price,
                               @RequestParam("order_time") Timestamp order_time) {
        Orders orders = new Orders();
        orders.setId(id);
        orders.setOrder_id(order_id);
        orders.setOrder_sn(order_sn);
        orders.setTotal_price(total_price);
        orders.setOrder_time(order_time);
        ordersRepository.save(orders);

        return orders;
    }

    /**
     * @Author 牛家禾
     * @Date 2017/10/31 10:04
     * @Description 返回每天的账单金额
     */
    @GetMapping(value = "/getsort/{yearmon}")
    public List getandSort(@PathVariable("yearmon") Integer yearmon) {
        String yearmonstr = String.valueOf(yearmon);
        int year= Integer.parseInt(yearmonstr.substring(0,4));
        int mon=Integer.parseInt(yearmonstr.substring(4,6));
        //String year = yearmonstr.substring(0,4);
        //String mon = yearmonstr.substring(4,6);


        //return ordersRepository.getSort(year,mon);
        return ordersRepository.getSort(2017,04);
    }
    /**
      * @Author 牛家禾
      * @Date 2017/11/16 09:32
      * @Description 根据自定义规则表进行查询
      */
    @GetMapping(value = "/getMaxid")
    public Integer getMaxid(){
        return ordersRepository.getMaxid();
    }


    /**
     * @Author 牛家禾
     * @Date 2017/10/31 10:05
     * @Description 事务测试
     */
    //@PostMapping("/order/two")
    @GetMapping("/order/two")
    public List<Orders> orderTwo(){
        return ordersService.judgeAllRule(1);
    }
}