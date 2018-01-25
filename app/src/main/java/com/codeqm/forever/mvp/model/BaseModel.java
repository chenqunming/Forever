package com.codeqm.forever.mvp.model;

/**
 * Created by chenqunming on 2018/1/25.
 */

public class BaseModel<T> {
    protected String code;
    protected  String msg;
    protected T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
