package com.example.sqldemo.dao;

import com.example.sqldemo.entity.Orders;

import java.util.List;

/**
 * @Author 牛家禾【1207287598@qq.com】
 * @Date 2017/11/7 15:38
 */
public interface OrdersRepositoryCustom {
   List<Object[]> getMaxid();
   boolean judgeRule(Orders orders,String param);
   List<Object[]> myRule(String param);
}
