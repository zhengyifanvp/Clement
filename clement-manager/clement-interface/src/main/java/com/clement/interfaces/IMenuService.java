package com.clement.interfaces;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;

public interface IMenuService {
    PageResult<Menu> selectAllMenu(Integer page, Integer rows, String sortBy, Boolean desc);
    void updateMenu();
    void deleteMenu();
    void addMenu();
}
