package com.xhs.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.xhs.property.mapper.PropertyMapper;
import com.xhs.property.pojo.Property;
import com.xhs.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements PropertyService {

    @Autowired
    PropertyMapper propertyMapper;

    public Property selectById(int propertyId) {
        return propertyMapper.selectByPrimaryKey(propertyId);
    }

    public List<Property> selectListByAsc(boolean isAsc, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return propertyMapper.selectListByAsc(isAsc ? 1 : 2);
    }
}
