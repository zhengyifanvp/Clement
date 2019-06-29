package com.clement.service;

import com.clement.domain.User;
import com.clement.interfaces.IUserService;
import com.clement.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void userAdd(User user) {
        userMapper.insert(user);

    }
}
