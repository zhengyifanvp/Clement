package com.clement.interfaces;

import com.clement.domain.Order;

import com.clement.domain.orderResult;
/**
* @name: IOrderService
*
* @description: 订单服务接口类
*
* @author: KeXin Xu
*
* @Date: 2019/7/8
*
* @Version：1.0
**/
public interface IOrderService {
    orderResult<Order> selectOrder(Integer page, Integer rows, String sortBy,Boolean desc);
    Void saleOrder(Order orders);
}
