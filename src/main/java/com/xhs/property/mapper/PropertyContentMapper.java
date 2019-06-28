package com.xhs.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhs.property.pojo.PropertyContent;

public interface PropertyContentMapper extends BaseMapper<PropertyContent> {
    int deleteByPrimaryKey(Integer propertyContentId);

    int insert(PropertyContent record);

    int insertSelective(PropertyContent record);

    PropertyContent selectByPrimaryKey(Integer propertyContentId);

    int updateByPrimaryKeySelective(PropertyContent record);

    int updateByPrimaryKey(PropertyContent record);
}