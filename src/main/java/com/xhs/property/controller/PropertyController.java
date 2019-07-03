package com.xhs.property.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.pojo.Property;
import com.xhs.property.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    private ResultEntity saveProperty(@RequestBody Property property) {
        System.out.println("请求来了吗" + property.getAddress());
        boolean isInsert = propertyService.save(property);
        if (isInsert) {
            return ResultEntity.getSuccessResult("请求成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }
    }

    @RequestMapping(value = "/getPropertyList/{isAsc}", method = RequestMethod.GET)
    @ResponseBody
    private ResultEntity getPropertyList(@PathVariable  boolean isAsc) {
        List<Property> propertyList = propertyService.selectListByAsc(isAsc);
        return ResultEntity.getSuccessResult(propertyList);
    }
}
