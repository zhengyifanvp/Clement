package com.clement.common.advice;

import com.clement.common.exception.ClmException;
import com.clement.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @name: CommonExceptionHandler
 *
 * @description: 拦截所有的controller，然后做异常通知处理
 *
 * @author: Yifan Zheng
 *
 * @Date: 2019/6/30
 *
 * @Version：1.0
 **/
@ControllerAdvice
public class CommonExceptionHandler {//handleException
    @ExceptionHandler(ClmException.class)
    public ResponseEntity<ExceptionResult> handleException(ClmException e) {
        return ResponseEntity.status(e.getExceptionEnum().getCode())
                .body(new ExceptionResult(e.getExceptionEnum()));
    }
}
