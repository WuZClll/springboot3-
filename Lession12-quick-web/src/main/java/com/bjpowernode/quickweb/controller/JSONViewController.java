package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.User;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点 wanghe
 */
@Controller
@RestController
public class JSONViewController {

  //显示json视图，包含json数据
  @RequestMapping("/exam/json")
  public void responseJson(HttpServletResponse response) throws IOException {
    String json="{\"name\":\"lisi\",\"age\":20}";
    //应答，通过HttpServletResponse输出
    response.setContentType("application/json;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println(json);
    out.flush();
    out.close();
  }

  //SpringMVC支持控制器方法返回对象， 由框架将对象使用jackson转为json，并输出
  //User--Jackson工具库的ObjectMapper对象，---user转为json格式字符串--HttpServletResponse输出

  /**
   * 接受请求的注解
   * @GetMapping:接收get请求 ， 简化的@RequestMapping(method=RequestMethod.GET)
   * @PostMapping 接收post请求
   * @PutMapping: 接收put请求
   * @DeleteMapping:接收delete请求
   */
  /**
   * @ResponseBody等同于
   *  response.setContentType("application/json;charset=utf-8");
   *  PrintWriter out = response.getWriter();
   *  out.println(json);
   *  out.flush();
   *  out.close();
   * @return
   */
  //@RequestMapping("/exam/json2")
  @GetMapping("/exam/json2")
  @ResponseBody
  public User getUserJson(){
    User user = new User();
    user.setUsername("张三");
    user.setAge(22);
    return user;
  }
}
