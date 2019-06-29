package com.clement.controller;

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
    public ResponseEntity<Void> userAdd(User user){

        userService.userAdd(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<String> getString(){
        return ResponseEntity.status(200).body("fsfsfsfsf");
    }

}
