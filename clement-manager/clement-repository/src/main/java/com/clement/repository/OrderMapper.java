package com.clement.repository;

import com.clement.common.utils.MyMapper;
import com.clement.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends MyMapper<Order> {
}
