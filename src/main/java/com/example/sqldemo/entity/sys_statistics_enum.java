package com.example.sqldemo.entity;

/**
 * @Author 牛家禾【1207287598@qq.com】
 * @Date 2017/11/14 11:19
 */
enum StatisticsTimeType {
    UNKNOWN,
    DAY,
    HOUR,
    MINUTE,
}

enum StatisticsUserType {
    UNKNOWN,
    ALL_USER_TYPE,//所有用户类型
    DRILL_USER_TYPE,//分用户类型
    SPECIFIED_USER_TYPE,//指定用户类型
}

enum StatisticsBusinessType {
    UNKNOWN,
    ALL_BUSINESS_TYPE,//总业务
    SINGLE_BUSINESS,//单业务
    DRILL_BUSINESS,//分业务
}

enum CommonRecordStatus{
    UNKNOW,
    SAVED,
    AUTO_SAVED,
}