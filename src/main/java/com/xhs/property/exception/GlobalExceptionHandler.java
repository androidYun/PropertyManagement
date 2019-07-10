package com.xhs.property.exception;

import com.xhs.property.pojo.ResultEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.tools.tree.NullExpression;

@ControllerAdvice(basePackages = "com.xhs.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultEntity exception(Exception e) {
        return ResultEntity.getErrorResult(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResultEntity nullException(NullExpression e) {
        return ResultEntity.getErrorResult("数据为空");
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultEntity nullException(MissingServletRequestParameterException e) {
        return ResultEntity.getErrorResult("MissingServletRequestParameterException ");
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultEntity nullException(HttpRequestMethodNotSupportedException e) {
        return ResultEntity.getErrorResult("Method Not Allowed");
    }
}
