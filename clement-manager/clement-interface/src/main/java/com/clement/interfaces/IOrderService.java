package com.clement.interfaces;

import com.clement.domain.Order;
import com.clement.domain.orderResult;

public interface IOrderService {
    orderResult<Order> selectOrder();
    void saleOrder(Order orders);
}
