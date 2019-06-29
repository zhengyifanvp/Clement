package com.clement.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnum {

    EXAMPLE_EXCEPTION(000,"模板错误");
    ;
    private int code;
    private String msg;
}
