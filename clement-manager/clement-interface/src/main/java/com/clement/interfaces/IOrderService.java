package com.clement.interfaces;

import com.clement.domain.Order;

import com.clement.domain.orderResult;

public interface IOrderService {
    orderResult<Order> selectOrder(Integer page, Integer rows, String sortBy,Boolean desc);
    Void saleOrder(Order orders);
}
