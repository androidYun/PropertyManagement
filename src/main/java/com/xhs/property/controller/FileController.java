package com.xhs.property.controller;

import com.xhs.property.pojo.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    @RequestMapping(value = "/imageUpdate", method = RequestMethod.POST)
    @ResponseBody
    private ResultEntity updateImage(MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File pathFile = new File(path);
        if (!pathFile.exists()) {
            pathFile.mkdir();
        }

        return ResultEntity.getSuccessResult("");
    }
}
