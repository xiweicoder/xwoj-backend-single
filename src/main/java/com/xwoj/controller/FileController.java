package com.xwoj.controller;

import com.xwoj.common.BaseResponse;
import com.xwoj.common.ErrorCode;
import com.xwoj.common.ResultUtils;
import com.xwoj.exception.BusinessException;
import com.xwoj.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author 西尾coding
 * 文件上传接口
 */
@Api(tags = "FileController")
@RestController
@RequestMapping("/file")
@CrossOrigin(originPatterns = {"http://localhost:8080","http://oj.kongxw.top"}, allowCredentials = "true")
public class FileController {

    @Resource
    private FileService ossService;

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public BaseResponse<String> uploadOssFile(@RequestPart("file") MultipartFile file) {
        //获取上传的文件
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "上传文件为空");
        }
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        //返回r对象
        return ResultUtils.success(url);
    }
}
