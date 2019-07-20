package com.xhs.property.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.xhs.property.pojo.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService extends IService<Property> {
    Property selectById(int propertyId);

    Property getPropertyByUserId(int userId);

    List<Property> selectListByAsc(boolean isAsc, int pageNum, int pageSize);

    List<Property> listBySearchName(String content);
}
