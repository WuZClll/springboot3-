package com.bjpowernode.problem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点
 */
@RestController
public class ProblemController {

  @GetMapping("/probs/not-found")
  public String doNotFound(){
    return "图书的isbn可能不存在。。。。";
  }
}
