package com.clement.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * @methodName: PageResult
 * @Description: 分页实体类
 * @Param: [total, items]
 * @return:
 * @Author: KeXin Xu
 * @Date: 2019/7/2
 */
@Data
public class PageResult<T> implements Serializable {


    private static final long serialVersionUID = 4886406176522634548L;

    private long total;
    private long totalPage;
    private List<T> users;

    public PageResult(long total,List<T> users){

        this.total=total;
        this.users=users;

    }
}
