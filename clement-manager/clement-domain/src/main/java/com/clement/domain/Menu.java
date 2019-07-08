package com.clement.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
* @name: Menu
*
* @description: 菜单类
*
* @author: KeXin Xu
*
* @Date: 2019/7/5
*
* @Version：1.0
**/
@Table(name = "menu")
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = -99603059570700246L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer menuid;
    private String menuname;
    private Float menuprice;
}
