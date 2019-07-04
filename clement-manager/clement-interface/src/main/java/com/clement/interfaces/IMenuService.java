package com.clement.interfaces;

import com.clement.domain.Menu;
import com.clement.domain.PageResult1;

import java.util.List;

public interface IMenuService {
    PageResult1<Menu> selectAllMenu(Integer page, Integer rows, String sortBy, Boolean desc);
    void updateMenu(Menu menu);
    void deleteMenu(Menu menu);
    void addMenu(Menu menu);
    List<Menu> selectMenu();

}
