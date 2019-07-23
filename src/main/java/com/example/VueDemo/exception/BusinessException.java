package com.example.VueDemo.exception;


import com.example.VueDemo.Enum.ResultEnum;

public class BusinessException extends RuntimeException{

    private Integer code;

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
