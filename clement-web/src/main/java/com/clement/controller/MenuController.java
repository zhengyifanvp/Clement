package com.clement.controller;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;
import com.clement.domain.PageResult1;
import com.clement.interfaces.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;


    @GetMapping("/list/page")
    @CrossOrigin
    public ResponseEntity<PageResult1<Menu>> selectAllUser(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc
    ){
        PageResult1<Menu> result =this.menuService.selectAllMenu(page,rows,sortBy,desc);
//        if(result == null || result.getT().size()==0){
//
//            return new ResponseEntity<>(HttpStatus.CREATED);
//
//        }
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

    @DeleteMapping
    @CrossOrigin
    public ResponseEntity<Void> deleteMenu(@RequestBody Integer menuid){
        menuService.deleteMenu(menuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
