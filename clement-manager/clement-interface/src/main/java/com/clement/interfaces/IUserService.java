package com.clement.interfaces;

import com.clement.domain.User;

public interface IUserService {
    void userAdd(User user);
    void userLogin(User user);
    void updateUser(User user,String pass);

}