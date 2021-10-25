package com.jweiquan.serverwarehouse.common;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    /**
     * 业务状态码
     */
    private final int code;

    /**
     * 业务消息
     */
    private final String message;

    /**
     * 响应体
     */
    private final T data;

    public ApiResponse(T data) {
        this(ApiResultCode.SUCCESS, data);
    }

    public ApiResponse(ApiResultCode resultCode) {
        this(resultCode, null);
    }

    public ApiResponse(ApiResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
