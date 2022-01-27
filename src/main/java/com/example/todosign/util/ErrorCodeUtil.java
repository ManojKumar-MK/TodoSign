package com.example.todosign.util;

public class ErrorCodeUtil {
    private Integer errorCode;
    private String message;

    public ErrorCodeUtil(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

}
