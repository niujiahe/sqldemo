package com.Order_simulation_statistics.mapper;
import com.Order_simulation_statistics.entity.sys_statistics_ruleInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository{

    @Select("select * from sys_statistics_rule_info")
    List<sys_statistics_ruleInfo> findAll();

    @Select("Select * from sys_statistics_rule_info where id = #{id}")
    sys_statistics_ruleInfo findOne(@Param("id") Integer id);

    @Insert("INSERT INTO sys_statistics_rule_info(create_by,create_time,extra_content,record_status,remarks,statistics_business_type," +
            "statistics_business_value,statistics_time_type,statistics_time_value,statistics_user_type,statistics_user_value," +
            "update_by,update_time,rule_id)" +
            "VALUES(#{create_by},#{create_time},#{extra_content},#{record_status},#{remarks},#{statistics_business_type}," +
            "#{statistics_business_value},#{statistics_time_type},#{statistics_time_value},#{statistics_user_type},#{statistics_user_value}," +
            "#{update_by},#{update_time},#{rule_id})")
    void save(sys_statistics_ruleInfo ruleInfo);

    @Delete("DELETE FROM sys_statistics_rule_info WHERE id =#{id}")
    void delete(@Param("id")Integer id);

    //获得最大ID
    @Select("select max(id) from sys_statistics_rule_info")
    Integer getMaxid();

    //获得所有rule_id
    @Select("select rule_id from sys_statistics_rule_info")
    List<Integer> getAllRuleid();

    @Delete("TRUNCATE TABLE sys_statistics_rule_info")
    void deleteall();


}