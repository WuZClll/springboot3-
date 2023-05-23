package com.bjpowernode.pk.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 动力节点 wanghe
 */
@RestController
public class HelloController {

  @Autowired
  private Date date;//在启动类中配置的date

  @GetMapping("/hello")
  public String hello(){
    return "====欢迎使用SpringBoot3:====" + date;
  }
}
