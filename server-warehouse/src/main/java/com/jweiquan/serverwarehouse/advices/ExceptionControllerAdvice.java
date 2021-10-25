package com.jweiquan.serverwarehouse.advices;

import com.jweiquan.serverwarehouse.common.ApiException;
import com.jweiquan.serverwarehouse.common.ApiResponse;
import com.jweiquan.serverwarehouse.common.ApiResultCode;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponse<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        ObjectError error = exception.getBindingResult().getAllErrors().get(0);
        return new ApiResponse<String>(ApiResultCode.VALIDATE_FIELD, error.getDefaultMessage());
    }

    @ExceptionHandler({ApiException.class})
    public ApiResponse<Object> apiExceptionHandler(ApiException exception) {
        return new ApiResponse<Object>(ApiResultCode.ERROR);
    }
}
