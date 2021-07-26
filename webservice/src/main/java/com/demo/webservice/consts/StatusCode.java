package com.demo.webservice.consts;

public enum StatusCode {
    SUCCESS(1000, "Success"),
    SYSTEM_ERROR(1001, "System error"),
    DATA_NOT_FOUND(1002, "Data not found"),
    DB_ERROR(1003, "Db error");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setCode(String msg) {
        this.msg = msg;
    }
}
