package com.clement.interfaces;

import com.clement.domain.*;

/**
* @name: IMenuService
* 
* @description: 菜单服务接口
* 
* @author: KeXin Xu
*
* @Date: 2019/7/5
*
* @Version：1.0
**/
public interface IMenuService {
    PageResult1<Menu> selectAllMenu(Integer page, Integer rows, String sortBy, Boolean desc);
    void updateMenu(Menu menu);
    void deleteMenu(Menu menu);
    void addMenu(Menu menu);
    Result<Menus> selectMenu();



}
