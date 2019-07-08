package com.clement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
* @name: Result
*
* @description: 部分菜单查询类
*
* @author: KeXin Xu
*
* @Date: 2019/7/8
*
* @Version：1.0
**/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4843265156465657738L;
    private List<T> menus;


    public Result(List<T> menus) {

        this.menus = menus;

    }
}
