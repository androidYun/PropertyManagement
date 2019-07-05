package com.xhs.property.service.impl;

import com.xhs.property.mapper.PropertyImageMapper;
import com.xhs.property.pojo.PropertyImage;
import com.xhs.property.service.PropertyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyImageServiceImpl implements PropertyImageService {

    @Autowired
    PropertyImageMapper propertyImageMapper;

    public int insertPropertyImage(PropertyImage propertyImage) {
        return propertyImageMapper.insert(propertyImage);
    }

    public List<PropertyImage> selectPropertyImageList(int propertyContentId) {
        return propertyImageMapper.selectListById(propertyContentId);
    }

    public int insertPropertyImageList(List<String> imageList, int propertyContentId) {
        return propertyImageMapper.insertPropertyImageList(imageList, propertyContentId);
    }
}
