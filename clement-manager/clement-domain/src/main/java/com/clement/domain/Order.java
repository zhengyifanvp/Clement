package com.clement.domain;




import tk.mybatis.mapper.annotation.KeySql;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
* @name: Order
*
* @description: 订单实体类
*
* @author: KeXin Xu
*
* @Date: 2019/7/8
*
* @Version：1.0
**/
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = -5354558834157036242L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer ordernumber;
    private String ordermessage;
    private Float ordertotal;
    private String usermessage;

    public Order(Integer ordernumber, String ordermessage, Float ordertotal, String usermessage) {
        this.ordernumber = ordernumber;
        this.ordermessage = ordermessage;
        this.ordertotal = ordertotal;
        this.usermessage = usermessage;
    }

    public Order() {
    }

    public Order(String ordermessage, Float ordertotal, String usermessage) {
        this.ordermessage = ordermessage;
        this.ordertotal = ordertotal;
        this.usermessage = usermessage;
    }



    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getOrdermessage() {
        return ordermessage;
    }

    public void setOrdermessage(String ordermessage) {
        this.ordermessage = ordermessage;
    }

    public Float getOrdertotal() {
        return ordertotal;
    }

    public void setOrdertotal(Float ordertotal) {
        this.ordertotal = ordertotal;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }
}
