package com.example.sqldemo.entity;

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
    private Integer infoId;
    //规则ID
    private Integer ruleId;
    //维度
    private StatisticsTimeType timeType;
    private Timestamp statisticsTimeBegin;
    private Timestamp statisticsTimeEnd;
    private String statisticsUserValue;
    private String statisticsUBusinessValue;
    //统计项
    private long itemOrderCount;
    private long itemOrderAmount;
    //扩展信息
    private String extraContent;
    //公共信息
    private Timestamp createTime;
    private Timestamp recordStatus;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public StatisticsTimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(StatisticsTimeType timeType) {
        this.timeType = timeType;
    }

    public Timestamp getStatisticsTimeBegin() {
        return statisticsTimeBegin;
    }

    public void setStatisticsTimeBegin(Timestamp statisticsTimeBegin) {
        this.statisticsTimeBegin = statisticsTimeBegin;
    }

    public Timestamp getStatisticsTimeEnd() {
        return statisticsTimeEnd;
    }

    public void setStatisticsTimeEnd(Timestamp statisticsTimeEnd) {
        this.statisticsTimeEnd = statisticsTimeEnd;
    }

    public String getStatisticsUserValue() {
        return statisticsUserValue;
    }

    public void setStatisticsUserValue(String statisticsUserValue) {
        this.statisticsUserValue = statisticsUserValue;
    }

    public String getStatisticsUBusinessValue() {
        return statisticsUBusinessValue;
    }

    public void setStatisticsUBusinessValue(String statisticsUBusinessValue) {
        this.statisticsUBusinessValue = statisticsUBusinessValue;
    }

    public long getItemOrderCount() {
        return itemOrderCount;
    }

    public void setItemOrderCount(long itemOrderCount) {
        this.itemOrderCount = itemOrderCount;
    }

    public long getItemOrderAmount() {
        return itemOrderAmount;
    }

    public void setItemOrderAmount(long itemOrderAmount) {
        this.itemOrderAmount = itemOrderAmount;
    }

    public String getExtraContent() {
        return extraContent;
    }

    public void setExtraContent(String extraContent) {
        this.extraContent = extraContent;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Timestamp recordStatus) {
        this.recordStatus = recordStatus;
    }

}
