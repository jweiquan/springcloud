package com.jweiquan.serverwarehouse.common;

import lombok.Getter;
import org.apache.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private final int code;
    private final String message;

    public ApiException() {
        this("API Service Error!");
    }

    public ApiException(String message) {
        this(HttpStatus.SC_INTERNAL_SERVER_ERROR, message);
    }

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
