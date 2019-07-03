package com.clement.repository;

import com.clement.common.utils.MyMapper;
import com.clement.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends MyMapper<Menu> {
}
