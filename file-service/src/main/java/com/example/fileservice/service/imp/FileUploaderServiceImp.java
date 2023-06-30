package com.example.fileservice.service.imp;

import com.example.fileservice.entity.FileUploadEntity;
import com.example.fileservice.service.FileUploaderService;
import com.example.sharedservices.utils.md5.stringMD5;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileUploaderServiceImp implements FileUploaderService {
    @Autowired
    private MinioClient minioClient;

    @Value("${file-service.minio.bucket-name}")
    private String bucket;

    private final static Logger log = LoggerFactory.getLogger(FileUploaderServiceImp.class);

    @Override
    public String uploadFile(FileUploadEntity fileUpload) {
        String bucket;
        String newFile;
        MultipartFile file = fileUpload.getFile();
        InputStream inputStream = null;
        if (fileUpload.getBucket() == null) {
            bucket = this.bucket;
        } else {
            bucket = fileUpload.getBucket();
        }
        try {
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder()
                        .bucket(bucket)
                        .build());
                log.info("bucket不存在，创建bucket:{}成功", bucket);
            }
            inputStream = file.getInputStream();
            String md5 = stringMD5.getMD5(file.getName());
            newFile = new SimpleDateFormat("yyyy-MM-dd/").format(new Date()) + md5 + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            minioClient.putObject(PutObjectArgs.builder().bucket(bucket).object(newFile).stream(
                            inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());
            log.info("文件{}上传成功", file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件{}上传桶{}失败,失败日志{}", file.getOriginalFilename(), bucket, e.getMessage());
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close(); // 关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("文件流关闭失败，失败日志：{}", e.getMessage());
                    return null;
                }
            }
        }
        return bucket + "/" + newFile;
    }
}
