package com.xhs.property.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhs.property.pojo.PropertyContent;
import com.xhs.property.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyContentService extends IService<PropertyContent> {

    List<PropertyContent> selectPropertyListById(int propertyId, int isAsc);

    PropertyContent selectPropertyById(int propertyContentId);

    PropertyContent getPropertyContentByUserId(int userId);

    int updatePropertyContent(PropertyContent propertyContent);
}
