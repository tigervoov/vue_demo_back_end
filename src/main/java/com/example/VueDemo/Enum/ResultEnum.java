package com.example.VueDemo.Enum;

public enum ResultEnum {

    UNKONW_ERROR(-1,"未知错误"),
    INSERT_ERROR(1,"新增失败，已有相同项"),;


    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
