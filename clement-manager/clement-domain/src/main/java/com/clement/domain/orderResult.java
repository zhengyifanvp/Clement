package com.clement.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* @name: orderResult
*
* @description: 订单分页实体类
*
* @author: KeXin Xu
*
* @Date: 2019/7/8
*
* @Version：1.0
**/
@Data
public class orderResult<T> implements Serializable {

    private static final long serialVersionUID = 5088731327110545573L;


    private long total;
    private long totalPage;
    private List<T> orders;

    public orderResult(long total, List<T> orders) {
        this.total = total;
        this.orders = orders;
    }
}
