package com.xhs.property.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.xhs.property.pojo.ResultEntity;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import sun.tools.tree.NullExpression;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> errorResult = new HashMap<String, Object>();
        if (e instanceof NullPointerException) {
            errorResult.put("message", "空指针" + e.getMessage());
        } else if (e instanceof TimeoutException) {
            errorResult.put("message", "超时" + e.getMessage());
        }
        System.out.println("时间"+e.getMessage());
        errorResult.put("code", 203);
        view.setAttributesMap(errorResult);
        modelAndView.setView(view);
        return modelAndView;
    }
}
