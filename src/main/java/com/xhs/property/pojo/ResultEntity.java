package com.xhs.property.pojo;

public class ResultEntity<T> {
    private int code;

    private String message;

    private T data;


    public static ResultEntity getSuccessResult(Object t) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.data = t;
        resultEntity.code = 200;
        return resultEntity;
    }

    public static ResultEntity getErrorResult(String errorMessage) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.data = null;
        resultEntity.message = errorMessage;
        resultEntity.code = 208;
        return resultEntity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
