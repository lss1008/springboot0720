package com.sangeng.exception;

import com.sangeng.domain.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 创建类加上@ControllerAdvice注解进行标识
@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    // 定义异常处理方法，使用@ExceptionHandler标识可以处理的异常
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleException(Exception e) {
        String message = e.getMessage();
        ResponseResult result = new ResponseResult(300, message);
        return result;
    }
}
