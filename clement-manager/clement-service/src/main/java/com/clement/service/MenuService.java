package com.clement.service;

import com.clement.common.enums.ExceptionEnum;
import com.clement.common.exception.ClmException;
import com.clement.domain.Menu;
import com.clement.domain.PageResult1;
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
/**
* @name: MenuService
*
* @description: 菜品服务类
*
* @author: KeXin Xu
*
* @Date: 2019/7/4
*
* @Version：1.0
**/
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
    public PageResult1<Menu> selectAllMenu(Integer page, Integer rows, String sortBy, Boolean desc){

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
        return new PageResult1<>(pageInfo.getTotal(),list);



    }

    /**
     * @methodName: updateMenu
     * @Description: 更新菜品信息的具体业务逻辑
     * @Param: [menu]
     * @return: void
     * @Author: Yifan Zheng
     * @Date: 2019/7/4
     */
    @Override
    public void updateMenu(Menu menu) {
        Integer menuid = menu.getMenuid();
        Menu newMenu = new Menu();
        newMenu.setMenuid(menuid);
        newMenu.setMenuname(menu.getMenuname());
        newMenu.setMenuprice(menu.getMenuprice());
        menuMapper.updateByPrimaryKey(newMenu);
    }
    /**
     * @methodName: deleteMenu
     * @Description: 删除菜品
     * @Param: [menu]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @Override
    public void deleteMenu(Menu menu) {

        menuMapper.deleteByPrimaryKey(menu.getMenuid());
    }
    /**
     * @methodName: addMenu
     * @Description:添加菜品
     * @Param: [menu]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @Override
    public void addMenu(Menu menu) {

        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("menuname",menu.getMenuname());
        //判空
        if(StringUtils.isNotBlank(menu.getMenuname())) {
            //是否存在
            int i = menuMapper.selectCountByExample(example);
            if (i == 0) {
                menuMapper.insert(menu);

            } else if (i == 1) {
                throw new ClmException(ExceptionEnum.MENUEXIST_EXCEPTION);

            }

        }else {
            throw new ClmException(ExceptionEnum.MENUNAME_EXCEPTION);
        }
    }
    /**
     * @methodName: selectMenu
     * @Description: 普通查询
     * @Param: []
     * @return: java.util.List<com.clement.domain.Menu>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @Override
    public List<Menu> selectMenu() {

        List<Menu> menus = menuMapper.selectAll();

        return menus;
    }
}
