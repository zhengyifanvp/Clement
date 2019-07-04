package com.clement.interfaces;

import com.clement.domain.Menu;
import com.clement.domain.PageResult;
import com.clement.domain.User;

public interface IUserService {
    void userAdd(User user);
    void userLogin(String username,String password);
    void updatePass(User user,String pass);
    PageResult<User> selectAllUser(Integer page,Integer rows,String sortBy,Boolean desc);
    void updateUser(User user);
    void deleteUser(User user);
}