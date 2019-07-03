package com.clement.controller;

import com.clement.common.enums.ExceptionEnum;
import com.clement.common.exception.ClmException;
import com.clement.domain.PageResult;
import com.clement.domain.User;
import com.clement.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")

public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Void> userAdd(User user){

        userService.userAdd(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
        /*throw new ClmException(ExceptionEnum.PASSWORDERROR_EXCEOTION);*/
    }

    @GetMapping("/list")
    public ResponseEntity<String> getString(){

        return ResponseEntity.status(200).body("fsfsfsfsf");
    }

    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<Void> userLogin(String username,String password){
        userService.userLogin(username,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        @PostMapping("/update")
    @CrossOrigin
    public ResponseEntity<Void> updateUser(User user,String pass){
        userService.updateUser(user,pass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/list/page")
    @CrossOrigin
    public ResponseEntity<PageResult<User>> selectAllUser(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc
            ){
        PageResult<User> result =this.userService.selectAllUser(page,rows,sortBy,desc);
        if(result == null || result.getUsers().size()==0){

            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        return ResponseEntity.ok(result);

    }




}
