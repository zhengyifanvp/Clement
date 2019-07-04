package com.clement.controller;

import com.clement.domain.Menu;
import com.clement.domain.PageResult1;
import com.clement.interfaces.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    /**
     * @methodName: selectAllMenu
     * @Description:分页查询菜品
     * @Param: [page, rows, sortBy, desc]
     * @return: org.springframework.http.ResponseEntity<com.clement.domain.PageResult1<com.clement.domain.Menu>>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @GetMapping("/list/page")
    @CrossOrigin
    public ResponseEntity<PageResult1<Menu>> selectAllMenu(


            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc
    ){
        PageResult1<Menu> result =this.menuService.selectAllMenu(page,rows,sortBy,desc);
        return ResponseEntity.ok(result);

    }


    /**
     * @methodName: editMenu
     * @Description: 修改菜品信息的controller
     * @Param: [menu]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: Yifan Zheng
     * @Date: 2019/7/4
     */
    @PutMapping
    @CrossOrigin
    public ResponseEntity<Void> editMenu(@RequestBody Menu menu){
        menuService.updateMenu(menu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * @methodName: deleteMenu
     * @Description: 删除菜品
     * @Param: [menu]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @DeleteMapping("")
    @CrossOrigin
    public ResponseEntity<Void> deleteMenu(@RequestBody Menu menu){
        menuService.deleteMenu(menu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * @methodName: addMenu
     * @Description: 添加菜品
     * @Param: [menu]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Void> addMenu(@RequestBody Menu menu){

        menuService.addMenu(menu);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @methodName: selectMenu
     * @Description: 普通查询
     * @Param: []
     * @return: org.springframework.http.ResponseEntity<java.util.List<com.clement.domain.Menu>>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @GetMapping("/list")
    @CrossOrigin
    public ResponseEntity<List<Menu>> selectMenu() {
        List<Menu> menus = menuService.selectMenu();
        return ResponseEntity.ok(menus);
    }
}
