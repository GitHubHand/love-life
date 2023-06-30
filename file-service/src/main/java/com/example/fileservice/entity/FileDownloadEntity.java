package com.example.fileservice.entity;

import lombok.Data;

@Data
public class FileDownloadEntity {
    private String bucket;
    private String filename;
    private String localPathFile;
}
