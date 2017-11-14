package com.example.sqldemo.dao;
import com.example.sqldemo.entity.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface OrdersRepository extends OrdersRepositoryCustom{
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:09
      * @Description 通过总共价格来进行查询
      */
    //public List<Orders> findByTotal_price(Integer total_price);

     /**
       * @Author 牛家禾
       * @Date 2017/10/31 10:51
       * @Description 基本查询函数
       */
     @Select("select * from orders")
     List<Orders> findAll();

     @Select("Select * from orders where id = #{id}")
     Orders findOne(@Param("id") Integer id);

     @Insert("INSERT INTO orders(order_id,order_sn,total_price,order_time) VALUES(#{order_id},#{order_sn},#{total_price},#{order_time})")
     Orders save(Orders orders);

     @Delete("DELETE FROM orders WHERE id =#{id}")
     void delete(@Param("id")Integer id);

     @Select("select DATE_FORMAT(order_time,'%Y-%m-%d') AS days, sum(total_price) AS amount, count(total_price) as ordercount from orders where year(order_time)='%${0}%' and month(order_time)='%${1}%' group by days")
     List getSort(int years, int mons);

     //@Query(value = "select DATE_FORMAT(order_time,'%Y-%m-%d') AS days, sum(total_price) AS amount, count(total_price) as ordercount from orders where year(order_time)=?1 and month(order_time) =?2 group by days", nativeQuery = true)
     //public List getSort(int year, int mon);


}