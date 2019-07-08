package com.clement.service;

import com.clement.common.enums.ExceptionEnum;
import com.clement.common.exception.ClmException;
import com.clement.domain.PageResult;
import com.clement.domain.User;
import com.clement.interfaces.IUserService;
import com.clement.repository.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
    public void userAdd(User user){
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
    public void userLogin(String username,String password) {
        // 创建Example
        Example example = new Example(User.class);
        // 创建Criteria
        Example.Criteria criteria = example.createCriteria();
        // 添加条件
        criteria.andEqualTo("username", username);
        //通過條件查詢user
        List<User> list = userMapper.selectByExample(example);

        if(list.size()==0){
            throw new ClmException(ExceptionEnum.NOTEXIST_EXCEPTION);

        }/*else if ((list.get(0).getPassword()).equals(user.getPassword())) {*/
            else if ((list.get(0).getPassword()).equals(password)) {


        }else{
            throw new ClmException(ExceptionEnum.PASSWORDERROR_EXCEOTION);
        }

        }
    /**
     * @methodName: updatePass
     * @Description: 修改密码
     * @Param: [user, pass]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/7/2
     */
    public void updatePass(User user,String pass){
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
    /**
     * @methodName: selectAllUser
     * @Description: 查询所有用户
     * @Param: [page, rows, sortBy, desc]
     * @return: com.clement.domain.PageResult<com.clement.domain.User>
     * @Author: KeXin Xu
     * @Date: 2019/7/3
     */
    public PageResult<User> selectAllUser(Integer page,Integer rows,String sortBy,Boolean desc){

            //开始分页
            PageHelper.startPage(page,rows);
            //过滤
            Example example=new Example(User.class);
            if(StringUtils.isNotBlank(sortBy)){
                //排序
                String orderByClause =sortBy + (desc ? " DESC" : " ASC");
                example.setOrderByClause(orderByClause);

            }
            //查询
            //List<User> list =userMapper.selectByExample(example);
            List<User> list = userMapper.selectByExample(example);

            //解析分页结果
            PageInfo<User> pageInfo=new PageInfo<>(list);
            //返回结果
            return new PageResult<>(pageInfo.getTotal(),list);



        }
    /**
     * @methodName: updateUser
     * @Description: 修改用户信息
     * @Param: [user]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @Override
    public void updateUser(User user) {
            Integer userid = user.getUserid();
            User newUser = new User();
            newUser.setUserid(userid);
            newUser.setUsername(user.getUsername());
            newUser.setPhone(user.getPhone());
            newUser.setPassword(user.getPassword());
            newUser.setCreatetime(user.getCreatetime());
            userMapper.updateByPrimaryKey(newUser);
        }

    /**
     * @methodName: deleteUser
     * @Description: 删除用户
     * @Param: [user]
     * @return: void
     * @Author: KeXin Xu
     * @Date: 2019/7/4
     */
    @Override
    public void deleteUser(User user) {

        userMapper.deleteByPrimaryKey(user.getUserid());
    }


}



