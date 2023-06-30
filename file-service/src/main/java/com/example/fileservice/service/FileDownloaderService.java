package com.example.fileservice.service;


import com.example.fileservice.entity.FileDownloadEntity;

public interface FileDownloaderService {
    String downloadFile(FileDownloadEntity fileDownloader) throws Exception;
}
