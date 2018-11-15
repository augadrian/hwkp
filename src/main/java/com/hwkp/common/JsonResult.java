package com.hwkp.common;

/**
 * User: zhangbin.
 * Date: 2016/11/15.
 * Time: 16:02.
 * desc:
 */
public class JsonResult<T> {

    private Integer status;
    private String message;
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}