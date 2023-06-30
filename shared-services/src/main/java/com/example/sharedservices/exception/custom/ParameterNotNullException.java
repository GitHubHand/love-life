package com.example.sharedservices.exception.custom;

import lombok.Data;

@Data
public class ParameterNotNullException extends RuntimeException {

    private String code;
    private String message;
}
