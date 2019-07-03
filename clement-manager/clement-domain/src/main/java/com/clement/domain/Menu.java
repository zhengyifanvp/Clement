package com.clement.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "menu")
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = -99603059570700245L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private int menuId;
    private String menuName;
    private float menuPrice;
    private int muenuFlag;
}
