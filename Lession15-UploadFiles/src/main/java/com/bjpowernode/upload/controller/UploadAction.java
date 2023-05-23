package com.bjpowernode.upload.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 作者：北京动力节点
 */
@Controller
public class UploadAction {

  @PostMapping("/files")
  public String upload(HttpServletRequest request){
    try{
      for(Part part: request.getParts()){
        String filename=  extractFileName(part);
        //将文件写入到服务器的目录
        part.write(filename);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    return "redirect:/index.html";
  }

  private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    System.out.println("contentDisp="+contentDisp);
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        return s.substring(s.indexOf("=") + 2, s.length()-1);
      }
    }
    return "";
  }
}
