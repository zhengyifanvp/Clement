package com.clement.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* @name: PageResult1
*
* @description: 菜品分页查询的pageResult
*
* @author: Yifan Zheng
*
* @Date: 2019/7/4
*
* @Version：1.0
**/
@Data
public class PageResult1<T> implements Serializable {


    private static final long serialVersionUID = -3615614278647048662L;
    private long total;
    private long totalPage;
    private List<T> menus;

    public PageResult1(long total, List<T> menus) {

        this.total = total;
        this.menus = menus;

    }
}
