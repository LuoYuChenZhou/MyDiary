package com.lycz.design;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {
    private int status;
    private String msg;//用于页面提示的信息
    private T data;

    public CommonResult() {
        this.msg = "";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
