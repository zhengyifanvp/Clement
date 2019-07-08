package com.clement.service;

import com.clement.domain.Order;
import com.clement.domain.orderResult;
import com.clement.interfaces.IOrderService;
import com.clement.repository.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service(value = "orderService")
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Void saleOrder(Order orders) {
            orderMapper.insert(orders);
            return null;
    }

    @Override
    public orderResult<Order> selectOrder(Integer page, Integer rows, String sortBy,Boolean desc) {
        //开始分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example=new Example(Order.class);
        if(StringUtils.isNotBlank(sortBy)){
            //排序
            String orderByClause =sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);

        }
        //查询
        List<Order> list = orderMapper.selectByExample(example);

        //解析分页结果
        PageInfo<Order> pageInfo=new PageInfo<>(list);
        //返回结果
        return new orderResult<>(pageInfo.getTotal(),list);
    }
}
