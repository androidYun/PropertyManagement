package com.xhs.property.controller;


import com.github.pagehelper.PageInfo;
import com.xhs.property.entity.PageEntity;
import com.xhs.property.pojo.Property;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.PropertyServiceImpl;
import com.xhs.property.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {

    @Autowired
    PropertyServiceImpl propertyService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public ResultEntity saveProperty(@RequestBody Property property) {
        try {
            if (property == null) {
                return ResultEntity.getErrorResult("参数不合法");
            }
            if (StringUtils.isEmpty(property.getAddress())) {
                return ResultEntity.getErrorResult("地址不能为空");
            }
            if (StringUtils.isEmpty(property.getDeveloperName())) {
                return ResultEntity.getErrorResult("开发商不能为空");
            }
            if (StringUtils.isEmpty(property.getPropertyName())) {
                return ResultEntity.getErrorResult("物业不能为空");
            }
            if (property.getUserId() == null) {
                return ResultEntity.getErrorResult("请授权");
            }
            if (StringUtils.isEmpty(property.getAppraise())) {
                return ResultEntity.getErrorResult("反对内容");
            }
            boolean isInsert;
            isInsert = propertyService.save(property);
            if (isInsert) {
                return ResultEntity.getSuccessResult("请求成功");
            } else {
                return ResultEntity.getErrorResult("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据那" + e.getMessage());
            return ResultEntity.getErrorResult(e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/getPropertyList/{isAsc}", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getPropertyList(@PathVariable boolean isAsc, int pageNum, int pageSize) {
        try {
            List<Property> propertyList = propertyService.selectListByAsc(isAsc, pageNum, pageSize);
            PageInfo<Property> pageInfo = PageInfo.of(propertyList);
            if (pageNum > pageInfo.getPages()) {
                return ResultEntity.getSuccessResult(new PageEntity<Property>(pageInfo.getTotal(),
                        pageInfo.getPages(),
                        pageInfo.getPageSize(),
                        new ArrayList<Property>()));
            } else {
                return ResultEntity.getSuccessResult(new PageEntity<Property>(pageInfo.getTotal(),
                        pageInfo.getPages(),
                        pageInfo.getPageSize(),
                        pageInfo.getList()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.getErrorResult(e.getMessage());
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity searchProperty(String content) {
        List<Property> propertiesList = propertyService.listBySearchName(content);
        return ResultEntity.getSuccessResult(propertiesList);
    }
    @RequestMapping(value = "/isSubmit",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity isSubmit(int userId){
        Property propertyByUserId = propertyService.getPropertyByUserId(userId);
        if(propertyByUserId!=null){
            return ResultEntity.getSuccessResult(true);
        }else{
            return ResultEntity.getSuccessResult(false);
        }
    }
}
