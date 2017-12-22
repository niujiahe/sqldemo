package com.Order_simulation_statistics.entity;
/**
 * @Author 牛家禾
 * @Date 2017/10/31 10:19
 * @Description Orders数据格式定义
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
public class sys_statistics_ruleInfo{

    @Id
    @GeneratedValue
    private Integer id;
    private Integer rule_id;
    //基本信息
    private String statistics_time_type;
    private String statistics_time_value;
    private String statistics_user_type;
    private String statistics_user_value;
    private String statistics_business_type;
    private String statistics_business_value;
    //扩展信息
    private String extra_content;
    //公共信息
    private String create_by;
    private Timestamp create_time;
    private String update_by;
    private Timestamp update_time;
    private String remarks;
    private CommonRecordStatus record_status;


    //GETTER AND SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public String getStatistics_time_type() {
        return statistics_time_type;
    }

    public void setStatistics_time_type(String statistics_time_type) {
        this.statistics_time_type = statistics_time_type;
    }

    public String getStatistics_time_value() {
        return statistics_time_value;
    }

    public void setStatistics_time_value(String statistics_time_value) {
        this.statistics_time_value = statistics_time_value;
    }

    public String getStatistics_user_type() {
        return statistics_user_type;
    }

    public void setStatistics_user_type(String statistics_user_type) {
        this.statistics_user_type = statistics_user_type;
    }

    public String getStatistics_user_value() {
        return statistics_user_value;
    }

    public void setStatistics_user_value(String statistics_user_value) {
        this.statistics_user_value = statistics_user_value;
    }

    public String getStatistics_business_type() {
        return statistics_business_type;
    }

    public void setStatistics_business_type(String statistics_business_type) {
        this.statistics_business_type = statistics_business_type;
    }

    public String getStatistics_business_value() {
        return statistics_business_value;
    }

    public void setStatistics_business_value(String statistics_business_value) {
        this.statistics_business_value = statistics_business_value;
    }

    public String getExtra_content() {
        return extra_content;
    }

    public void setExtra_content(String extra_content) {
        this.extra_content = extra_content;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public CommonRecordStatus getRecord_status() {
        return record_status;
    }

    public void setRecord_status(CommonRecordStatus record_status) {
        this.record_status = record_status;
    }



}
