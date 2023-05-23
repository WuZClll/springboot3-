package com.bjpowernode.quickweb.controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点 wanghe
 */
@RestController
public class ExamPathController {

  //使用 ？ 表示单个字符
  @GetMapping("/file/test.html")
  public String path1(HttpServletRequest request){
    return "path请求：" + request.getRequestURI() ;
  }

  // * 表示0或多个字符， 不能匹配路径 /
  @GetMapping("/images/*.gif")
  public String path2(HttpServletRequest request){
    return "path2请求：" + request.getRequestURI() ;
  }

  // ** 表示所有， 多个路径或者字符
  @GetMapping("/pic/**")
  public String path3(HttpServletRequest request){
    return "path3请求：" + request.getRequestURI() ;
  }

  //路径变量 {*变量名称}
  @GetMapping("/order/{*id}")
  public String path4(@PathVariable("id") String orderId,HttpServletRequest request){
    return "path4请求：" + request.getRequestURI() + " ,id="+orderId;
  }

  //正则表达式
  @GetMapping("/pages/{fname:\\w+}.log")
  public String path5(@PathVariable("fname") String fname, HttpServletRequest request){
    return "path5请求：" + request.getRequestURI() + " ,fname="+fname;
  }

  @GetMapping("/pages/get")
  public String path6( HttpServletRequest request){
    return "path6请求：" + request.getRequestURI();
  }


  // localhost:8080/exam/query?id=1001&time=2023
  public String req(ServletRequest request, ServletResponse response, HttpSession session,
      Reader reader, OutputStream outputStream   ,@RequestParam("age") Integer age,
      @RequestHeader("Accept") String accept , Map map, Model model,Integer id,String time){
    String requestId = request.getRequestId();
    response.setBufferSize(1024);
    session.setAttribute("name","lisi");
    return "ok";
  }
}
