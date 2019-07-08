package com.clement.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* @name: PageResult
*
* @description: 用户分页实体类
*
* @author: KeXin Xu
*
* @Date: 2019/7/8
*
* @Version：1.0
**/
@Data
public class PageResult<T> implements Serializable {


    private static final long serialVersionUID = 4886406176522634548L;

    private long total;
    private long totalPage;
    private List<T> users;

    public PageResult(long total, List<T> users) {

        this.total = total;
        this.users = users;

    }
}
