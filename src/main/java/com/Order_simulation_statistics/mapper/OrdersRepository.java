package com.Order_simulation_statistics.mapper;
import com.Order_simulation_statistics.entity.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository{
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
     void save(Orders orders);

     @Delete("DELETE FROM orders WHERE id =#{id}")
     void delete(@Param("id")Integer id);

     @Select("select DATE_FORMAT(order_time,'%Y-%m-%d') AS days, sum(total_price) AS amount, count(total_price) as ordercount from orders where year(order_time)='%${0}%' and month(order_time)='%${1}%' group by days")
     List getSort(int years, int mons);

     //@Query(value = "select DATE_FORMAT(order_time,'%Y-%m-%d') AS days, sum(total_price) AS amount, count(total_price) as ordercount from orders where year(order_time)=?1 and month(order_time) =?2 group by days", nativeQuery = true)
     //public List getSort(int year, int mon);

     //获得最大ID
     @Select("select max(id) from orders")
     Integer getMaxid();

     //读取数据表中的一定行数的数据
     @Select("select * from orders where id>= #{rowStart} and id<= #{rowEnd}")
     List<Orders> getOneGroup(@Param("rowStart")int rowStart, @Param("rowEnd")int rowEnd);

     @Delete("TRUNCATE TABLE orders")
     void deleteall();

}