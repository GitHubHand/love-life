package com.example.sharedservices.exception;

import com.example.sharedservices.exception.custom.ParameterNotNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 处理系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.fail(ResultCode.FAILED, e);
    }

    @ExceptionHandler(ParameterNotNullException.class)
    public Result ParameterException(Exception e) {
        return Result.fail(ResultCode.PARAMETER, e);
    }
}
