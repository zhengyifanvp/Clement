package com.clement.service;

import com.clement.domain.User;
import com.clement.interfaces.IUserService;
import com.clement.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "userService")
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void userAdd(User user) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(new Date());

        user.setCreatetime(format);

        userMapper.insert(user);

    }
}
