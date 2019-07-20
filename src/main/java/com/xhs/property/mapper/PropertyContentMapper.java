package com.xhs.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhs.property.pojo.PropertyContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyContentMapper extends BaseMapper<PropertyContent> {
    int deleteByPrimaryKey(Integer propertyContentId);

    int insert(PropertyContent record);

    int insertSelective(PropertyContent record);

    PropertyContent selectByPrimaryKey(Integer propertyContentId);

    PropertyContent getPropertyContentByUserId(int userId);

    List<PropertyContent> selectListByPropertyId(@Param("propertyId") int propertyId, @Param("isAsc") int isAsc);

    int updateByPrimaryKeySelective(PropertyContent record);

    int updateByPrimaryKey(PropertyContent record);
}