package com.xhs.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhs.property.pojo.Property;

import java.util.List;

public interface PropertyMapper extends BaseMapper<Property> {
    int deleteByPrimaryKey(Integer propertyId);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer propertyId);

    Property getPropertyByUserId(int userId);

    List<Property> selectListByAsc(int isAsc);

    List<Property> listBySearchName(String content);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}