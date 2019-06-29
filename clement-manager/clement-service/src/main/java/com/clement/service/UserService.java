package com.clement.service;

import com.clement.common.enums.ExceptionEnum;
import com.clement.common.exception.ClmException;
import com.clement.domain.User;
import com.clement.interfaces.IUserService;
import com.clement.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
* @name: UserService
*
* @description: 用户服务类
*
* @author: KeXin Xu
*
* @Date: 2019/6/29
*
* @Version：1.0
**/
@Service(value = "userService")
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @methodName: userAdd
     * @Description: 注册用户
     * @Param: [user]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/6/29
     */
    @Override
    public void userAdd(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        int i = userMapper.selectCountByExample(example);
        if(i==0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //时间格式设置
            String format = simpleDateFormat.format(new Date());
            user.setCreatetime(format);
            userMapper.insert(user);

        }else if(i==1){
            throw new ClmException(ExceptionEnum.EXAMPLE_EXCEPTION);

        }else{
            throw new ClmException(ExceptionEnum.PROGRAM_EXCEPTION);
        }


    }
}
