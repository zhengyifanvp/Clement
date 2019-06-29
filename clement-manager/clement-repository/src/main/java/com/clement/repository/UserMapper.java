package com.clement.repository;

import com.clement.common.utils.MyMapper;
import com.clement.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}
