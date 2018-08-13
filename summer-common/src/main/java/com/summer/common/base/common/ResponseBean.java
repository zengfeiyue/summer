package com.summer.common.base.common;

/**
 * Response message bean
 *@author zengfeiyue
 */
public class ResponseBean {
    private String msg;
    private Integer code;
    private Object data;

    public ResponseBean(Integer code, String msg, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    public ResponseBean() {

    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
