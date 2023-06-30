package com.example.sharedservices.exception;

/**
 * 状态码枚举类
 */
public enum ResultCode {
    SUCCESS("200", "success"),
    FAILED("500", "failed"),
    VALIDATE_FAILED("404", "validate failed"),
    UNAUTHORIZED("401", "unauthorized"),
    FORBIDDEN("403", "forbidden"),
    PARAMETER("10010","parameter is null");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
