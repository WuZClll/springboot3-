package com.bjpowernode.exp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点
 */
@RestController
public class NumberController {

  @PostMapping("/divide")
  public String  some(Integer n1,Integer n2){
    int result = n1/ n2;
    return "n1/n2="+result;
  }
}
