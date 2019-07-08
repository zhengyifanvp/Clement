package com.clement.domain;

import lombok.Data;

import java.io.Serializable;

/**
* @name: Menus
*
* @description: 部分菜单类
*
* @author: KeXin Xu
*
* @Date: 2019/7/5
*
* @Version：1.0
**/
@Data
public class Menus implements Serializable {
    private static final long serialVersionUID = 4161205092518743748L;
    private String name;
    private Float price;

    public Menus(String name, Float price) {
        this.name = name;
        this.price = price;
    }
}
