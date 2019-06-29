package com.clement.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 7024728510435740028L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;
    private String username;
    private String password;
    private String phone;
    private String createtime;
}
