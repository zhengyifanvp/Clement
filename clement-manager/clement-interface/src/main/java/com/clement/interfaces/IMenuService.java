package com.clement.interfaces;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;
import com.clement.domain.PageResult1;

public interface IMenuService {
    PageResult1<Menu> selectAllMenu(Integer page, Integer rows, String sortBy, Boolean desc);
    void updateMenu(Menu menu);
    void deleteMenu(Integer menuid);
    void addMenu();
}
