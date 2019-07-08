package com.clement.interfaces;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;
import com.clement.domain.User;
/**
* @name: IUserService
*
* @description: 用户服务接口类
*
* @author: KeXin Xu
*
* @Date: 2019/7/5
*
* @Version：1.0
**/
public interface IUserService {
    void userAdd(User user);
    void userLogin(String username,String password);
    void updatePass(User user,String pass);
    PageResult<User> selectAllUser(Integer page,Integer rows,String sortBy,Boolean desc);
    void updateUser(User user);
    void deleteUser(User user);
}