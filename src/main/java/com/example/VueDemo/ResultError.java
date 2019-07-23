package com.example.VueDemo;

public class ResultError {
    private int code;
    private String mess;

    public ResultError(int code, String mess) {

        this.code = code;
        this.mess = mess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
