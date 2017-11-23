package com.example.sqldemo.mapper;
import com.example.sqldemo.entity.sys_statistics_summaryInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface SummaryRepository {
    @Select("select * from sys_statistics_summary_info")
    List<sys_statistics_summaryInfo> findAll();

    @Select("select * from sys_statistics_summary_info where username ='${Timestamp}' limit 0,1")
    List<sys_statistics_summaryInfo> MatchTimeValue(String TimeValue);

    @Insert("INSERT INTO sys_statistics_summary_info(create_time,extra_content,item_order_amount,item_order_count," +
            "record_status,rule_id,statistics_business_value, statistics_time_begin,statistics_time_end," +
            "statistics_user_value,time_type,time_value)" +
            "VALUES(#{create_time},#{extra_content},#{item_order_amount},#{item_order_count}," +
            "#{record_status},#{rule_id},#{statistics_business_value},#{statistics_time_begin},#{statistics_time_end}," +
            "#{statistics_user_value},#{time_type},#{time_value})")
    void save(sys_statistics_summaryInfo summaryInfo);

}
