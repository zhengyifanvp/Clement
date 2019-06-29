package com.clement.common.exception;

import com.clement.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClmException extends RuntimeException{

    private ExceptionEnum exceptionEnum;
}
