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
    PROGRAM_EXCEPTION(110, "si");

    private int code;
    private String msg;
}
