package com.clement.common.exception;

import com.clement.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @name: ClmException
 *
 * @description: 定义自己的异常，因为runtime异常不能自己定制异常
 *
 * @author: Yifan Zheng
 *
 * @Date: 2019/6/30
 *
 * @Version：1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClmException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
}
