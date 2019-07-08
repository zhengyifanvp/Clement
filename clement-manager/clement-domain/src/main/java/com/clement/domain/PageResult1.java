package com.clement.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
* @name: PageResult1
*
* @description: 菜单分页实体类
*
* @author: KeXin Xu
*
* @Date: 2019/7/8
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
