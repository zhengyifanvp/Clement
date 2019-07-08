package com.clement.service;

import com.clement.domain.Order;
import com.clement.domain.orderResult;
import com.clement.interfaces.IOrderService;
import com.clement.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "orderService")
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;



    @Override
    public orderResult<Order> selectOrder() {
        List<Order> list= orderMapper.selectAll();
        System.err.println(list);
        return new orderResult<Order>(list);
    }

    @Override
    public void saleOrder(Order orders) {
            orderMapper.insert(orders);
    }
}
