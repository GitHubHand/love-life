package com.example.fileservice.service.imp;

import com.example.fileservice.entity.FileDownloadEntity;
import com.example.fileservice.service.FileDownloaderService;
import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileDownloaderServiceImp implements FileDownloaderService {

    @Autowired
    private MinioClient minioClient;

    @Value("${file-service.minio.bucket-name}")
    private String bucket;

    @Override
    public String downloadFile(FileDownloadEntity fileDownloader) throws Exception {
        String bucket;
        if (fileDownloader.getBucket() == null) {
            bucket = this.bucket;
        } else {
            bucket = fileDownloader.getBucket();
        }
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!bucketExists) {
            return "文件路径异常";
        }
        minioClient.downloadObject(DownloadObjectArgs.builder().bucket(bucket).object(fileDownloader.getFilename()).filename(fileDownloader.getLocalPathFile()).build());
        return "success";
    }
}
