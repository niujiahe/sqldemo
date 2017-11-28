package com.example.sqldemo.Service;

import com.example.sqldemo.entity.StatisticsTimeType;
import com.example.sqldemo.mapper.OrdersRepository;
import com.example.sqldemo.entity.Orders;
import com.example.sqldemo.entity.sys_statistics_summaryInfo;
import com.example.sqldemo.entity.sys_statistics_ruleInfo;
import com.example.sqldemo.mapper.RuleRepository;
import com.example.sqldemo.mapper.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private SummaryRepository summaryRepository;


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

    //常量定义
    static Integer count = 10;//每组数据的数目
    List<sys_statistics_ruleInfo> ruleInfo;//全部的规则
    HashMap summaryMap = new HashMap();//查询结果缓存Map


    /**
      * @Description 判断该条数据是否符合规则
      */
    public boolean judgeOneOrder(Orders orders, Integer ruleId){
        //变量的定义
        boolean SatisfyTimeValue = false;
        DateFormat sdf = null;
        String summaryTimeValue;
        sys_statistics_ruleInfo ruleInfoTemp =  ruleInfo.get(ruleId);


        //对于ruleInfo中的每条性质 进行判断
        //步骤1：首先读取ruleInfo中的时间信息,判断该条信息是否符合时间范围 并且获得分类方式
        StatisticsTimeType timeType  = StatisticsTimeType.valueOf(ruleInfoTemp.getStatistics_time_type());
        String TimeValue = ruleInfoTemp.getStatistics_time_value();

        Timestamp startTime = Timestamp.valueOf(TimeValue.split(";")[0]);
        Timestamp endTime   = Timestamp.valueOf(TimeValue.split(";")[1]);
        Timestamp orderTime = orders.getOrder_time();

        if(orderTime.after(startTime)&orderTime.before(endTime)){//满足时间范围的情况下
            switch (timeType){
                case DAY:
                    sdf = new SimpleDateFormat("yyyy/MM/dd");
                    SatisfyTimeValue = true;
                    break;
                case HOUR:
                    sdf = new SimpleDateFormat("yyyy/MM/dd HH");
                    SatisfyTimeValue = true;
                    break;
                case MINUTE:
                    sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    SatisfyTimeValue = true;
                    break;
            }
        }
        //步骤2：查询summary表中是否存在rule中获得的时间标签；如果存在则合并，如果不存在则增加新的记录

        if(SatisfyTimeValue){
            summaryTimeValue = sdf.format(orderTime)+ruleInfoTemp.getRule_id();
            sys_statistics_summaryInfo summaryInfo = new sys_statistics_summaryInfo();
            //设定summaryInfo公共部分的属性值
            summaryInfo.setRule_id(ruleInfoTemp.getRule_id());
            summaryInfo.setStatistics_time_begin(startTime);
            summaryInfo.setStatistics_time_end(endTime);
            summaryInfo.setTime_type(ruleInfoTemp.getStatistics_time_type());
            summaryInfo.setTime_value(summaryTimeValue);


            //判断当前的时间标签是否存在于summaryMap中 如果存在则替代
            if(summaryMap.containsKey(summaryTimeValue)){
                sys_statistics_summaryInfo summaryInfoTemp = (sys_statistics_summaryInfo) summaryMap.get(summaryTimeValue);
                summaryInfo.setItem_order_count (summaryInfoTemp.getItem_order_count() +1);
                summaryInfo.setItem_order_amount(summaryInfoTemp.getItem_order_amount()+orders.getTotal_price());

                summaryMap.replace(summaryTimeValue,summaryInfo);
            }
            //否则添加新的记录
            else{
                summaryInfo.setItem_order_count(1);
                summaryInfo.setItem_order_amount(orders.getTotal_price());

                summaryMap.put(summaryTimeValue,summaryInfo);
            }
        }




        return true;
    }

    /**
      * @Description 循环读取数据对规则进行判断
      */
    public List<Orders> judgeAllRule(Integer ruleID){
        //初始化
        Integer startCount = 0;
        Integer endCount = -1;
        Integer allCount = ordersRepository.getMaxid();
        ruleInfo = ruleRepository.findAll();
        summaryMap.clear();

        List<Orders> answerList = new ArrayList<>();
        List<Orders> oneGroup = new ArrayList<>();

        //首先以for循环 以每count个为一组进行读入
        for (;;){
            //数据递增
            oneGroup.clear();
            startCount = endCount + 1;
            endCount = startCount + count;
            oneGroup = ordersRepository.getOneGroup(startCount,endCount);
            if(startCount>allCount){break;}
            //对读入的每组数据进行判断
            else {
                for(int i=0;i<oneGroup.size();i++){

                    answerList.add(oneGroup.get(i));
                    for(int j=0;j<ruleInfo.size();j++) {
                        //如果满足条件，则将其合并到结果数据表中
                        judgeOneOrder(oneGroup.get(i), j);
                    }
                }

            }
        }

        summaryRepository.deleteall();
        for (Object key : summaryMap.keySet()) {
            sys_statistics_summaryInfo temp = (sys_statistics_summaryInfo) summaryMap.get(key);
            summaryRepository.save(temp);

        }

        return answerList;
    }
}
