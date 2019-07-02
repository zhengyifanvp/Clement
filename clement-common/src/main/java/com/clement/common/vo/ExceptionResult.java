package com.clement.common.vo;

import com.clement.common.enums.ExceptionEnum;
import lombok.Data;

/**
* @name: ExceptionResult
*
* @description: 定义自己返回的结果(body)
*
* @author: Yifan Zheng
*
* @Date: 2019/6/30
*
* @Version：1.0
**/
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }

}
