package com.clone.screen.youtube.youtubeclone.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
    String uploadFile(MultipartFile multipartFile);
}
