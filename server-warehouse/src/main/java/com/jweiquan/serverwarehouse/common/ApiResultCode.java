package com.jweiquan.serverwarehouse.common;

import lombok.Getter;
import org.apache.http.HttpStatus;

@Getter
public enum ApiResultCode {
    SUCCESS(200, "success"),
    ERROR(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Api Server Error"),
    VALIDATE_FIELD(400, "VALIDATE FIELD!")
    ;
    private final int code;
    private final String message;

    ApiResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
