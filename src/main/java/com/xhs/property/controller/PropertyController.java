package com.xhs.property.controller;


import com.github.pagehelper.PageInfo;
import com.xhs.property.pojo.Property;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public ResultEntity saveProperty(@RequestBody Property property) throws Exception {
        System.out.println("请求来了吗" + property.getAddress());
        boolean isInsert = propertyService.save(property);
        if (isInsert) {
            return ResultEntity.getSuccessResult("请求成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/getPropertyList/{isAsc}", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getPropertyList(@PathVariable boolean isAsc, int pageNum, int pageSize) throws Exception {
        List<Property> propertyList = propertyService.selectListByAsc(isAsc, pageNum, pageSize);
        return ResultEntity.getSuccessResult(propertyList);
    }
}
