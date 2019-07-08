package com.clement.controller;


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

    /**
     * @methodName: userAdd
     * @Description:添加用户
     * @Param: [user]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Void> userAdd(User user){
        userService.userAdd(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    /**
     * @methodName: userLogin
     * @Description:用户登录
     * @Param: [username, password]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<Void> userLogin(String username,String password){

        userService.userLogin(username,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/password")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        @PostMapping("/update")
    @CrossOrigin
    public ResponseEntity<Void> updatePass(User user,String pass){
        /**
        * @methodName: updatePass
        * @Description: 修改密码
        * @Param: [user, pass]
        * @return: org.springframework.http.ResponseEntity<java.lang.Void>
        * @Author: KeXin Xu
        * @Date: 2019/7/4
        */
        userService.updatePass(user,pass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @methodName: selectAllUser
     * @Description:查询所有用户
     * @Param: [page, rows, sortBy, desc]
     * @return: org.springframework.http.ResponseEntity<com.clement.domain.PageResult<com.clement.domain.User>>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */

    @GetMapping("/list/page")
    @CrossOrigin
    public ResponseEntity<PageResult<User>> selectAllUser(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc
            ){
        PageResult<User> result =this.userService.selectAllUser(page,rows,sortBy,desc);

        return ResponseEntity.ok(result);

    }
    /**
     * @methodName: updateUser
     * @Description: 修改用户信息
     * @Param: [user]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @PutMapping("")
    @CrossOrigin
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @methodName: deleteUser
     * @Description: 删除用户
     * @Param: [user]
     * @return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @DeleteMapping("")
    @CrossOrigin
    public ResponseEntity<Void> deleteUser(@RequestBody User user){

        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
