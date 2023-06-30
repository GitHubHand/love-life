package com.example.fileservice.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadEntity {
    private String bucket;
    private String filename;
    private String newFileName;
    private MultipartFile file;
}
