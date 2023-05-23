package com.bjpowernode.upload.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 作者：北京动力节点
 */
@Controller
public class UploadFileController {

  //上传文件
  @PostMapping("/uploadFile")
  public String uploadFile(@RequestParam("upfile") MultipartFile multipartFile){
    System.out.println("开始处理上传文件");
    Map<String,Object> info = new HashMap<>();

    try{
      //判断上传了文件
      if( !multipartFile.isEmpty() ){
        info.put("上传文件的参数名称", multipartFile.getName());//upfile
        info.put("内容类型", multipartFile.getContentType());

        var ext = "unknown";
        var filename = multipartFile.getOriginalFilename(); //原始文件名称，例如a.gif
        if( filename.indexOf(".") > 0 ){
          ext = filename.substring(filename.indexOf(".") + 1);
        }
        //生成服务器使用的文件名称
        var newFileName = UUID.randomUUID().toString() + "." +  ext;

        var path="D://upload//" + newFileName;//存储服务器的文件

        //把文件保存到path目录
        multipartFile.transferTo(new File(path));

        info.put("文件名称", newFileName);

      }

    }catch (Exception e){
      e.printStackTrace();
    }

    System.out.println("info = " + info);
    //重定向到index页面
    return "redirect:/index.html";

  }
}
