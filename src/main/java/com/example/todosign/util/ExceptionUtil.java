package com.example.todosign.util;

public class ExceptionUtil {

    private String servletName;
    private String requestUri;
    private String exception;
    private String message;

    public ExceptionUtil(String servletName, String requestUri, String exception, String message) {
        this.servletName = servletName;
        this.requestUri = requestUri;
        this.exception = exception;
        this.message = message;
    }

    public String getServletName() {
        return servletName;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }
}
