package com.xhs.property.service;

import com.xhs.property.pojo.PropertyImage;

import java.util.List;

public interface PropertyImageService {

    int insertPropertyImage(PropertyImage propertyImage);

    int insertPropertyImageList(List<String> ImageList,int propertyContentId);

    List<PropertyImage> selectPropertyImageList(int propertyContentId);
}
