package com.example.sqldemo.entity;
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
    private Integer ruleId;
    //基本信息
    private StatisticsTimeType statisticsTimeType;
    private String statisticsTimeValue;
    private StatisticsUserType statisticsUserType;
    private String statisticsUserValue;
    private StatisticsBusinessType statisticsBusinessType;
    private String statisticsBusinessValue;
    //扩展信息
    private String extraContent;
    //公共信息
    private String createBy;
    private Timestamp createTime;
    private String updateBy;
    private Timestamp updateTime;
    private String remarks;
    private CommonRecordStatus recordStatus;


    //GETTER AND SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public StatisticsTimeType getStatisticsTimeType() {
        return statisticsTimeType;
    }

    public void setStatisticsTimeType(StatisticsTimeType statisticsTimeType) {
        this.statisticsTimeType = statisticsTimeType;
    }

    public String getStatisticsTimeValue() {
        return statisticsTimeValue;
    }

    public void setStatisticsTimeValue(String statisticsTimeValue) {
        this.statisticsTimeValue = statisticsTimeValue;
    }

    public StatisticsUserType getStatisticsUserType() {
        return statisticsUserType;
    }

    public void setStatisticsUserType(StatisticsUserType statisticsUserType) {
        this.statisticsUserType = statisticsUserType;
    }

    public String getStatisticsUserValue() {
        return statisticsUserValue;
    }

    public void setStatisticsUserValue(String statisticsUserValue) {
        this.statisticsUserValue = statisticsUserValue;
    }

    public StatisticsBusinessType getStatisticsBusinessType() {
        return statisticsBusinessType;
    }

    public void setStatisticsBusinessType(StatisticsBusinessType statisticsBusinessType) {
        this.statisticsBusinessType = statisticsBusinessType;
    }

    public String getStatisticsBusinessValue() {
        return statisticsBusinessValue;
    }

    public void setStatisticsBusinessValue(String statisticsBusinessValue) {
        this.statisticsBusinessValue = statisticsBusinessValue;
    }

    public String getExtraContent() {
        return extraContent;
    }

    public void setExtraContent(String extraContent) {
        this.extraContent = extraContent;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public CommonRecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(CommonRecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }
}
