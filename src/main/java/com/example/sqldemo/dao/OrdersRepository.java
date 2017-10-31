package com.example.sqldemo.dao;
import com.example.sqldemo.entity.Orders;
import org.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer>{
    /**
      * @Author 牛家禾
      * @Date 2017/10/31 10:09
      * @Description 通过总共价格来进行查询
      */
    //public List<Orders> findByTotal_price(Integer total_price);

     /**
       * @Author 牛家禾
       * @Date 2017/10/31 10:51
       * @Description 按天查询
       */

     @Modifying
     @Query(value = "select DATE_FORMAT(order_time,'%Y-%m-%d') AS days, sum(total_price) AS amount, count(total_price) as ordercount from orders where year(order_time)=?1 and month(order_time) =?2 group by days", nativeQuery = true)
     public List getSort(int year, int mon);

}
