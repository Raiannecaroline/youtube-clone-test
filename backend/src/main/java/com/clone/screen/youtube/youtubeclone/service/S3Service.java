package com.clone.screen.youtube.youtubeclone.service;


import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService {

    public static final String BUCKET_NAME = "raianne-caroline";

    private final AmazonS3Client awsS3Client;

    @Override
    public String uploadFile(MultipartFile multipartFile) {
       var fileNameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());

       var key = UUID.randomUUID().toString() + "." + fileNameExtension;

       var metadata = new ObjectMetadata();
       metadata.setContentLength(multipartFile.getSize());
       metadata.setContentType(multipartFile.getContentType());


       try {
           awsS3Client.putObject(BUCKET_NAME, key, multipartFile.getInputStream(), metadata);
       } catch (IOException ioException) {
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                   "Aconteceu um erro ao subir o arquivo.");
       }

       awsS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead);

       return awsS3Client.getResourceUrl(BUCKET_NAME,key);

    }

    @Bean
    public static AmazonS3Client amazonS3Client() {
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion("sa-east-1")
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }


}
