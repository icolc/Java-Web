package com.xrui.exception;

import com.xrui.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author NXRUI
 * @version 1.0
 * @date 2023/5/24 8:48
 * @description: 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //Exception.class代表所有的异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
