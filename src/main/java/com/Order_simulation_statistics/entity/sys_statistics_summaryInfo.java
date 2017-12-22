package com.Order_simulation_statistics.entity;

/**
 * @Author 牛家禾【1207287598@qq.com】
 * @Date 2017/11/14 11:10
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class sys_statistics_summaryInfo {
    @Id
    @GeneratedValue

    private Integer id;
    //规则ID
    private Integer rule_id;

    //维度
    private String time_type;
    private String time_value;
    private Timestamp statistics_time_begin;
    private Timestamp statistics_time_end;
    private String statistics_user_value;
    private String statistics_business_value;
    //统计项
    private long item_order_count;
    private long item_order_amount;
    //扩展信息
    private String extra_content;
    //公共信息
    private Timestamp create_time;
    private String record_status;

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

    public String getTime_type() {
        return time_type;
    }

    public void setTime_type(String time_type) {
        this.time_type = time_type;
    }

    public String getTime_value() {
        return time_value;
    }

    public void setTime_value(String time_value) {
        this.time_value = time_value;
    }

    public Timestamp getStatistics_time_begin() {
        return statistics_time_begin;
    }

    public void setStatistics_time_begin(Timestamp statistics_time_begin) {
        this.statistics_time_begin = statistics_time_begin;
    }

    public Timestamp getStatistics_time_end() {
        return statistics_time_end;
    }

    public void setStatistics_time_end(Timestamp statistics_time_end) {
        this.statistics_time_end = statistics_time_end;
    }

    public String getStatistics_user_value() {
        return statistics_user_value;
    }

    public void setStatistics_user_value(String statistics_user_value) {
        this.statistics_user_value = statistics_user_value;
    }

    public String getStatistics_business_value() {
        return statistics_business_value;
    }

    public void setStatistics_business_value(String statistics_business_value) {
        this.statistics_business_value = statistics_business_value;
    }

    public long getItem_order_count() {
        return item_order_count;
    }

    public void setItem_order_count(long item_order_count) {
        this.item_order_count = item_order_count;
    }

    public long getItem_order_amount() {
        return item_order_amount;
    }

    public void setItem_order_amount(long item_order_amount) {
        this.item_order_amount = item_order_amount;
    }

    public String getExtra_content() {
        return extra_content;
    }

    public void setExtra_content(String extra_content) {
        this.extra_content = extra_content;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getRecord_status() {
        return record_status;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }


}
