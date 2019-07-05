package com.xhs.property.controller;

import com.xhs.property.pojo.PropertyContent;
import com.xhs.property.pojo.PropertyImage;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.PropertyContentServiceImpl;
import com.xhs.property.service.impl.PropertyImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/image")
public class PropertyImageController {

    @Autowired
    PropertyImageServiceImpl propertyImageService;

    @Autowired
    PropertyContentServiceImpl propertyContentService;

    @RequestMapping(value = "/propertyContent/{propertyContentId}", method = RequestMethod.GET)
    @ResponseBody
    private ResultEntity getPropertyImageList(@PathVariable int propertyContentId) {
        PropertyContent propertyContent = propertyContentService.selectPropertyById(propertyContentId);
        if (propertyContent == null) {
            return ResultEntity.getErrorResult("这个文章不存在");
        }
        List<PropertyImage> propertyImageList = propertyImageService.selectPropertyImageList(propertyContentId);
        return ResultEntity.getSuccessResult(propertyImageList);
    }
}
