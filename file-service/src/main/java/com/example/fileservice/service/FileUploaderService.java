package com.example.fileservice.service;

import com.example.fileservice.entity.FileUploadEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUploaderService {
    /**
     * 文件上传方法
     * @param fileUpload 文件上传实体类
     * @return 返回文件minio的路径
     * @throws Exception
     */
    String uploadFile(FileUploadEntity fileUpload) throws Exception;
}
