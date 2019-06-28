package com.xhs.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhs.property.mapper.PropertyContentMapper;
import com.xhs.property.mapper.PropertyMapper;
import com.xhs.property.mapper.UserMapper;
import com.xhs.property.pojo.PropertyContent;
import com.xhs.property.pojo.User;
import com.xhs.property.service.PropertyContentService;
import com.xhs.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyContentServiceImpl extends ServiceImpl<PropertyContentMapper, PropertyContent> implements PropertyContentService {


}
