package com.example.VueDemo;


import com.example.VueDemo.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResultError handleException(RuntimeException e){
        e.printStackTrace();
        if(e instanceof BusinessException) {
            BusinessException businessException = (BusinessException)e;
            return new ResultError(businessException.getCode(),businessException.getMessage());
        }
        //未知错误
        return new ResultError(-1,"系统异常");
    }
}
