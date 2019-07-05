package com.xhs.property.controller;

import com.xhs.property.pojo.PropertyContent;
import com.xhs.property.pojo.PropertyImage;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.PropertyContentServiceImpl;
import com.xhs.property.service.impl.PropertyImageServiceImpl;
import com.xhs.property.utils.FileUtils;
import com.xhs.property.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private PropertyImageServiceImpl propertyImageService;

    @Autowired
    private PropertyContentServiceImpl propertyContentService;

    @RequestMapping(value = "/imageUpdate", method = RequestMethod.POST)
    @ResponseBody
    private ResultEntity updateImage(HttpSession session, @RequestParam("uploadFile") MultipartFile[] uploadFile, int propertyContentId) {
        PropertyContent propertyContent = propertyContentService.selectPropertyById(propertyContentId);
        if (propertyContent == null) {
            return ResultEntity.getErrorResult("此文章不存在");
        }
        List<String> updatePathList = new ArrayList<String>();
        for (int i = 0; i < uploadFile.length; i++) {
            String insertPath = updateFile(session, uploadFile[i]);
            if (insertPath != null) {
                updatePathList.add(insertPath);
            }
        }
        int insertCount = 0;
        if (updatePathList.size() > 0) {
            insertCount = propertyImageService.insertPropertyImageList(updatePathList, propertyContentId);
        }
        if (insertCount > 0) {
            return ResultEntity.getSuccessResult("保存成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }

    }

    private String updateFile(HttpSession session, MultipartFile file) {
        //获取要上传的目标文件夹绝对路径、webapp下
        String realPath = System.getProperty("xhsImages");
        //重新定义文件名、避免名称重复
        String fileName = "xhsImages/" + UUID.randomUUID().toString() + FileUtils.getFileSuffix(file.getOriginalFilename());
        String parentFilePath = new File(realPath).getParent();
        File currentFile = new File(parentFilePath + "/" + fileName);

        try {
            if (!currentFile.exists()) {
                currentFile.createNewFile();
            }
            //上传文件至指定位置
            file.transferTo(currentFile);
            return fileName;
        } catch (IOException e) {
            System.out.println("错误日志" + e);
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    private ResultEntity test(HttpServletRequest request) {
        String contextPath = System.getProperty("xhsImages");
        File file = new File(contextPath);
        File shxFile = new File(file.getParent() + "/xhsImages");
        if (!shxFile.exists()) {
            shxFile.mkdir();
        }
        return ResultEntity.getSuccessResult(shxFile.getAbsolutePath());
    }
}
