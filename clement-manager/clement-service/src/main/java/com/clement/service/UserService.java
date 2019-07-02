package com.clement.service;

import com.clement.common.enums.ExceptionEnum;
import com.clement.common.exception.ClmException;
import com.clement.domain.User;
import com.clement.interfaces.IUserService;
import com.clement.repository.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        if(user.getUsername().isEmpty()|user.getUsername()==null){
            throw new ClmException(ExceptionEnum.PROGRAM_EXCEPTION);


        }else{int i = userMapper.selectCountByExample(example);
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

    @Override
    /**
    * @methodName: userlogin
    * @Description: 用户登陆
    * @Param: [user]
    * @return: void
    * @Author: KeXin Xu
    * @Date: 2019/7/1
    */
    public void userLogin(User user) {
        // 创建Example
        Example example = new Example(User.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        // 添加条件
        criteria.andEqualTo("username", user.getUsername());
        //通過條件查詢user
        List<User> list = userMapper.selectByExample(example);

        if(list.size()==0){
            throw new ClmException(ExceptionEnum.NOTEXIST_EXCEPTION);

        }else if ((list.get(0).getPassword()).equals(user.getPassword())) {


        }else{
            throw new ClmException(ExceptionEnum.PASSWORDERROR_EXCEOTION);
        }

        }
    /**
     * @methodName: updateUser
     * @Description: 修改密码
     * @Param: [user, pass]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/7/2
     */
    public void updateUser(User user,String pass){

            // 创建Example
            Example example = new Example(User.class);
            // 创建Criteria
            Example.Criteria criteria = example.createCriteria();
            // 添加条件
            criteria.andEqualTo("username", user.getUsername());
            List<User> list = userMapper.selectByExample(example);

            if(list.size()==0){
                throw new ClmException(ExceptionEnum.NOTEXIST_EXCEPTION);

            }else if ((list.get(0).getPassword()).equals(user.getPassword())) {
                user.setPassword(pass);
                userMapper.updateByExampleSelective(user,example);

            }else{
                throw new ClmException(ExceptionEnum.PASSWORDERROR_EXCEOTION);
            }


        }
    }



