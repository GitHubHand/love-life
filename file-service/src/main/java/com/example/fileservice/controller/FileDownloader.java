package com.example.fileservice.controller;

import com.example.fileservice.entity.FileDownloadEntity;
import com.example.fileservice.service.FileDownloaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("download")
public class FileDownloader {

    @Autowired
    private FileDownloaderService fileDownloaderService;

    @PostMapping("/file")
    public String downloadFile(FileDownloadEntity fileDownloader) {
        try {
            return fileDownloaderService.downloadFile(fileDownloader);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}

