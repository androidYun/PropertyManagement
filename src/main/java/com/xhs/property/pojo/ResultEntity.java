package com.xhs.property.pojo;

public class ResultEntity<T> {
    private int code;

    private String message;

    private T t;


    public static ResultEntity getSuccessResult(Object t) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.t = t;
        resultEntity.code = 200;
        return resultEntity;
    }

    public static ResultEntity getErrorResult(String errorMessage) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.t = null;
        resultEntity.message = errorMessage;
        resultEntity.code = 200;
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

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
