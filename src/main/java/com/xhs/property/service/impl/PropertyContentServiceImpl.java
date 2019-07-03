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

import java.util.List;

@Service
public class PropertyContentServiceImpl extends ServiceImpl<PropertyContentMapper, PropertyContent> implements PropertyContentService {


    @Autowired
    PropertyContentMapper propertyContentMapper;

    public List<PropertyContent> selectPropertyListById(int propertyId, int isAsc) {
        return propertyContentMapper.selectListByPropertyId(propertyId, isAsc);
    }

    public PropertyContent selectPropertyById(int propertyContentId) {
        return propertyContentMapper.selectByPrimaryKey(propertyContentId);
    }

    public int updatePropertyContent(PropertyContent propertyContent) {
        return propertyContentMapper.updateByPrimaryKey(propertyContent);
    }
}
