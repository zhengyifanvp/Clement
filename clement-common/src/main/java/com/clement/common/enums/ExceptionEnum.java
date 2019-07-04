package com.clement.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @name: ExceptionEnum
 *
 * @description: 规范异常格式，code为状态码，msg为状态信息
 *
 * @author: Yifan Zheng
 *
 * @Date: 2019/6/30
 *
 * @Version：1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnum {

    EXAMPLE_EXCEPTION(000, "模板错误"),
    PROGRAM_EXCEPTION(400, "用戶名不可用"),
    NOTEXIST_EXCEPTION(400,"用戶不存在"),
    PASSWORDERROR_EXCEOTION(400,"密碼錯誤"),
    PRICE_EXCEPTION(400,"价格错误"),
    MENUEXIST_EXCEPTION(400,"菜品存在"),
    MENUNAME_EXCEPTION(400,"菜品名稱錯誤")
    ;

    private int code;
    private String msg;
}
