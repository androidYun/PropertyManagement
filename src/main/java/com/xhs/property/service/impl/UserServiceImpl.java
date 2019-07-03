package com.xhs.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhs.property.mapper.PropertyMapper;
import com.xhs.property.mapper.UserMapper;
import com.xhs.property.pojo.Property;
import com.xhs.property.pojo.User;
import com.xhs.property.service.PropertyService;
import com.xhs.property.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    public User selectById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
