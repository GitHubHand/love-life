package com.example.fileservice.controller;

import com.example.fileservice.entity.FileUploadEntity;
import com.example.fileservice.service.FileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("upload")
public class FileUploader {

    @Autowired
    private FileUploaderService fileUploaderService;

    @PostMapping("/MultipartFile")
    public Map uploadFile(FileUploadEntity fileUpload) throws Exception {
        Map<Object, Object> map = new HashMap<>();
        String message = fileUploaderService.uploadFile(fileUpload);
        map.put("message", message);
        return map;
    }
}
