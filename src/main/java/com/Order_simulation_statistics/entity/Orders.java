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
public class Orders {

    @Id
    @GeneratedValue

    private Integer id;
    private String order_id;
    private String order_sn;
    private String order_user;
    private String order_business;

    private Integer total_price;
    private Timestamp order_time;

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public String getOrder_user() {
        return order_user;
    }

    public void setOrder_user(String order_user) {
        this.order_user = order_user;
    }

    public String getOrder_business() {
        return order_business;
    }

    public void setOrder_business(String order_business) {
        this.order_business = order_business;
    }

}
