package com.xwoj.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 西尾coding
 */
public interface FileService {
    /**
     * 上传头像到OSS
     *
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
