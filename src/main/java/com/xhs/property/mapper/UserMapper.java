package com.xhs.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhs.property.pojo.User;

public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByPhone(String phoneNumber);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}