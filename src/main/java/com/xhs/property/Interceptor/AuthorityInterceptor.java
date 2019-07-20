package com.xhs.property.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xhs.property.jwt.JwtTokenUtils;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.pojo.User;
import com.xhs.property.service.impl.UserServiceImpl;
import com.xhs.property.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AuthorityInterceptor implements HandlerInterceptor {
    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @Autowired
    UserServiceImpl userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            responseMessage(response, ResultEntity.getErrorResult("token不能为空"));
            return false;
        }
        String phoneNumberByToken = jwtTokenUtils.getUserNameByToken(token);
        if (jwtTokenUtils.isTokenExpired(token)) {
            responseMessage(response, ResultEntity.getErrorResult("token失效请刷新token"));
            return false;
        }
        if (StringUtils.isEmpty(phoneNumberByToken)) {
            responseMessage(response, ResultEntity.getErrorResult("token错误"));
            return false;
        }
        User user = userService.selectByPhone(phoneNumberByToken);
        if (user == null) {
            responseMessage(response, ResultEntity.getErrorResult("用户不存在"));
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor请求后");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        String message="";
        if(e!=null){
            message=e.getMessage();
        }
        System.out.println("Interceptor完整"+ message);
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response,
                                 ResultEntity resultEntity) {
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json; charset=utf-8");
            String json = JSONObject.toJSONString(resultEntity);
            out.print(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendError(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
