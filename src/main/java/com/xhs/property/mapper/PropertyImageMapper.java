package com.xhs.property.mapper;

import com.xhs.property.pojo.PropertyImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyImageMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(PropertyImage record);

    int insertSelective(PropertyImage record);

    int insertPropertyImageList(@Param("list") List<String> imageList, @Param("propertyContentId") int propertyContentId);

    PropertyImage selectByPrimaryKey(Integer imageId);

    List<PropertyImage> selectListById(Integer propertyContentId);

    int updateByPrimaryKeySelective(PropertyImage record);

    int updateByPrimaryKey(PropertyImage record);
}