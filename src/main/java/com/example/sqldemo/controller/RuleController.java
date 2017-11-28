package com.example.sqldemo.controller;

import com.example.sqldemo.entity.sys_statistics_ruleInfo;
import com.example.sqldemo.entity.*;
import com.example.sqldemo.mapper.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @Author 牛家禾【1207287598@qq.com】
 * @Date 2017/11/18 10:51
 */
@RestController
public class RuleController {
    @Autowired
    RuleRepository ruleRepository;

    @PostMapping(value = "/addrule")
    /*public sys_statistics_ruleInfo ruleAdd(@RequestParam("create_by") String create_by,
                                           @RequestParam("create_time") Timestamp create_time,
                                           @RequestParam("extra_content") String extra_content,
                                           @RequestParam("record_status")CommonRecordStatus record_status,
                                           @RequestParam("remarks")String remarks,
                                           @RequestParam("statistics_business_type")StatisticsBusinessType statistics_business_type,
                                           @RequestParam("statistics_business_value")String statistics_business_value,
                                           @RequestParam("statistics_time_type")StatisticsTimeType statistics_time_type,
                                           @RequestParam("statistics_time_value")String statistics_time_value,
                                           @RequestParam("statistics_user_type")StatisticsUserType statistics_user_type,
                                           @RequestParam("statistics_user_value")String statistics_user_value,
                                           @RequestParam("update_by")String update_by,
                                           @RequestParam("update_time")Timestamp update_time,
                                           @RequestParam("rule_id")Integer rule_id) {

        sys_statistics_ruleInfo ruleInfo= new sys_statistics_ruleInfo();
        ruleInfo.setCreateBy(create_by);
        ruleInfo.setCreateTime(create_time);
        ruleInfo.setExtraContent(extra_content);
        ruleInfo.setRecordStatus(record_status);
        ruleInfo.setRemarks(remarks);
        ruleInfo.setStatisticsBusinessType(statistics_business_type);
        ruleInfo.setStatisticsBusinessValue(statistics_business_value);
        ruleInfo.setStatisticsTimeType(statistics_time_type);
        ruleInfo.setStatisticsTimeValue(statistics_time_value);
        ruleInfo.setStatisticsUserType(statistics_user_type);
        ruleInfo.setStatisticsUserValue(statistics_user_value);
        ruleInfo.setUpdateBy(update_by);
        ruleInfo.setRuleId(rule_id);

        ruleRepository.save(ruleInfo);
        return ruleInfo;
    }*/
    public sys_statistics_ruleInfo addrule(@RequestParam("statistics_time_type") String statistics_time_type,
                                           @RequestParam("statistics_time_value")String statistics_time_value,
                                           @RequestParam("rule_id")Integer rule_id) {

        sys_statistics_ruleInfo ruleInfo= new sys_statistics_ruleInfo();
        //ruleInfo.setCreate_by(create_by);
        //ruleInfo.setCreate_time(create_time);
        ruleInfo.setStatistics_time_type(statistics_time_type);
        ruleInfo.setStatistics_time_value(statistics_time_value);
        ruleInfo.setRule_id(rule_id);
        ruleRepository.save(ruleInfo);
        return ruleInfo;
    }

    @GetMapping(value = "/deleteallrule")
    public String deleteall(){
        ruleRepository.deleteall();
        return "Delete all rules. DONE.";
    }



}
