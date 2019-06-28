package com.xhs.property.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.xhs.property.enumClass.PropertyContentEnum;
import com.xhs.property.pojo.Property;
import com.xhs.property.pojo.PropertyContent;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.PropertyContentServiceImpl;
import com.xhs.property.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/content")
public class PropertyContentController {

    @Autowired
    PropertyContentServiceImpl propertyContentService;

    @Autowired
    PropertyServiceImpl propertyService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    private ResultEntity savePropertyContent(@RequestBody PropertyContent propertyContent) {
        Property property = propertyService.selectById(propertyContent.getPropertyId());
        if (property == null) {
            return ResultEntity.getErrorResult("请选择物业信息");
        }
        if (propertyContent.getScore() == null) {
            return ResultEntity.getErrorResult("请选择评分");
        }
        propertyContent.setState(PropertyContentEnum.wait_review.getState());
        boolean isInsert = propertyContentService.save(propertyContent);
        if (isInsert) {
            return ResultEntity.getSuccessResult("请求成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }
    }
}
