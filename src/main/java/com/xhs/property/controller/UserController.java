package com.xhs.property.controller;

import com.xhs.property.jwt.JwtTokenUtils;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.pojo.User;
import com.xhs.property.service.impl.UserServiceImpl;
import com.xhs.property.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity register(@RequestBody User user) {

        if (StringUtils.isEmpty(user.getName())) {
            return ResultEntity.getErrorResult("用户姓名不能为空");
        }
        User userByPhone = userService.selectByPhone(user.getPhoneNumber());
        if (userByPhone != null) {
            return ResultEntity.getErrorResult("此用户已经存在");
        }
        boolean isInsert = userService.save(user);
        if (isInsert) {
            return ResultEntity.getSuccessResult("请求成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getUser(int userId) {
        User user = userService.selectById(userId);
        if (user == null) {
            return ResultEntity.getErrorResult("此用户不存在");
        }
        return ResultEntity.getSuccessResult(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity login(String phoneNumber, String password) {
        User user = userService.selectByPhone(phoneNumber);
        if (user == null) {
            return ResultEntity.getErrorResult("此用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            return ResultEntity.getErrorResult("密码错误");
        }
        String token = jwtTokenUtils.createToken(user.getPhoneNumber(), user.getPassword());
        return ResultEntity.getSuccessResult(token);
    }

    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity refreshToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        String refreshToken = jwtTokenUtils.refreshToken(token);
        return ResultEntity.getSuccessResult(refreshToken);
    }

}
