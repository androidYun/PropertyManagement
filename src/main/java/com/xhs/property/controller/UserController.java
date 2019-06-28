package com.xhs.property.controller;

import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.pojo.User;
import com.xhs.property.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    private ResultEntity addUser(@RequestBody User user) {
        boolean isInsert = userService.save(user);
        if (isInsert) {
            return ResultEntity.getSuccessResult("请求成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }
    }
}
