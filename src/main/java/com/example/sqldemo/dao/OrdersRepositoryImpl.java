package com.example.sqldemo.dao;

import com.example.sqldemo.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Author 牛家禾【1207287598@qq.com】
 * @Date 2017/11/7 15:40
 */
public class OrdersRepositoryImpl implements OrdersRepositoryCustom{
    @Autowired
    @PersistenceContext

    private EntityManager entityManager;

    /**
      * @Author 牛家禾
      * @Date 2017/11/7 16:23
      * @Description 获得最大ID
      */
    @Override
    public List<Object[]> getMaxid(){
        List<Object[]> orders = entityManager.createNativeQuery("select max(id) from orders").getResultList();
        return  orders;
    }

    /**
      * @Author 牛家禾
      * @Date 2017/11/7 16:33
      * @Description 判断该条记录是否符合规则
      */
    @Override
    public boolean judgeRule(Orders orders,String param) {
        boolean judege = false;

        return judege;
    }
    /**
      * @Author 牛家禾
      * @Date 2017/11/7 16:30
      * @Description 首先按批次读取每一组数据，对每一组数据中的每一条内容进行规则param的判断
      * 如果满足规则则加入新的List
      */
    @Override
    public  List<Object[]> myRule(String param){
        return getMaxid();
    }
}
