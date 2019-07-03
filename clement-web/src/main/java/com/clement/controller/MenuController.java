package com.clement.controller;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;
import com.clement.domain.User;
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
    public ResponseEntity<PageResult<Menu>> selectAllUser(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc
    ){
        PageResult<Menu> result =this.menuService.selectAllMenu(page,rows,sortBy,desc);
        if(result == null || result.getUsers().size()==0){

            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        return ResponseEntity.ok(result);

    }
}
