package com.example.sharedservices.exception;

import lombok.Data;

/**
 * 异常对象
 */
@Data
public  class Result {
    /**
     * 状态码
     */
    private String code;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 异常类型
     */
    private String exception;
    /**
     * 异常堆栈
     */
    private String error;

    /**
     * 方法封装
     * @param resultCode
     * @param e
     * @return
     */
    public static Result fail(ResultCode resultCode, Exception e) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setException(e.getClass().getName());
        result.setError(e.getMessage());
        return result;
    }
}
