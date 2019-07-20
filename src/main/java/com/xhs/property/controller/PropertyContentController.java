package com.xhs.property.controller;

import com.xhs.property.enumClass.PropertyContentEnum;
import com.xhs.property.pojo.Property;
import com.xhs.property.pojo.PropertyContent;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.PropertyContentServiceImpl;
import com.xhs.property.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/content")
public class PropertyContentController {

    @Autowired
    PropertyContentServiceImpl propertyContentService;

    @Autowired
    PropertyServiceImpl propertyService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity savePropertyContent(@RequestBody PropertyContent propertyContent) {
        PropertyContent propertyContentByUserId = propertyContentService.getPropertyContentByUserId(propertyContent.getUserId());
       if(propertyContentByUserId!=null){
           return ResultEntity.getErrorResult("你已经添加过了");
       }
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

    @RequestMapping(value = "/getPropertyContent/{isAsc}", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getPropertyContent(int propertyId, @PathVariable int isAsc) {
        List<PropertyContent> propertyContents = propertyContentService.selectPropertyListById(propertyId, isAsc);
        return ResultEntity.getSuccessResult(propertyContents);
    }


    @RequestMapping(value = "/updatePropertyContentState/{state}", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity updatePropertyContentState(int propertyContentId, @PathVariable int state) {
        PropertyContent propertyContent = propertyContentService.selectPropertyById(propertyContentId);
        if (propertyContent == null) {
            return ResultEntity.getErrorResult("此内容不存在");
        }
        propertyContent.setState(state);
        int updateCount = propertyContentService.updatePropertyContent(propertyContent);
        if (updateCount > 0) {
            return ResultEntity.getSuccessResult("更新成功");
        } else {
            return ResultEntity.getErrorResult("更新失败");
        }
    }

    @RequestMapping(value = "/isSubmit",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity isSubmit(int userId){
        PropertyContent propertyContentByUserId = propertyContentService.getPropertyContentByUserId(userId);
        if(propertyContentByUserId!=null){
            return ResultEntity.getSuccessResult(true);
        }else{
            return ResultEntity.getSuccessResult(false);
        }
    }
}
