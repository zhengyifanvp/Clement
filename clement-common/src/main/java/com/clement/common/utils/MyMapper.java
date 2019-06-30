package com.clement.common.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @name: MyMapper
 *
 * @description: 通用mapper，里边含有大量操作数据库的方法
 *
 * @author: Yifan Zheng
 *
 * @Date: 2019/6/30
 *
 * @Version：1.0
 *
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
