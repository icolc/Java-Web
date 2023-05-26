package com.xrui.controller;

import com.xrui.pojo.Result;
import com.xrui.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author NXRUI
 * @version 1.0
 * @date 2023/5/21 19:16
 * @description:
 */
@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("upload() called with parameters => 【image = {}】",image);
        log.info("文件上传中...文件名：{}", image.getOriginalFilename());
        //调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功！文件访问的url为：{}",url);

        Result success = Result.success(url);
        log.info("upload() returned: {}", success);
        return success;
    }
}
