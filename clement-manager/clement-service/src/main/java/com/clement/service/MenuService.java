package com.clement.service;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;
import com.clement.domain.User;
import com.clement.interfaces.IMenuService;
import com.clement.repository.MenuMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service(value = "menuService")
public class MenuService implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * @methodName: selectAllMenu
     * @Description: 查询所有的菜品
     * @Param: [page, rows, sortBy, desc]
     * @return: com.clement.domain.PageResult<com.clement.domain.Menu>
     * @Author: KeXin Xu
     * @Date: 2019/7/3
     */
    @Override
    public PageResult<Menu> selectAllMenu(Integer page, Integer rows, String sortBy, Boolean desc){

        //开始分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example=new Example(Menu.class);
        if(StringUtils.isNotBlank(sortBy)){
            //排序
            String orderByClause =sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);

        }
        //查询
        List<Menu> list = menuMapper.selectByExample(example);

        //解析分页结果
        PageInfo<Menu> pageInfo=new PageInfo<>(list);
        //返回结果
        return new PageResult<>(pageInfo.getTotal(),list);



    }
    @Override
    public void updateMenu() {

    }

    @Override
    public void deleteMenu() {

    }

    @Override
    public void addMenu() {

    }
}
