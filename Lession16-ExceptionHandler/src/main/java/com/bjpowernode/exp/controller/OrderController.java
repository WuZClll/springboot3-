package com.bjpowernode.exp.controller;

import com.bjpowernode.exp.vo.OrderVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点
 */
@RestController
public class OrderController {

  /**
   * @Validated 验证这个bean(传过来的bean)是否符合要求
   * @param orderVO
   * @return
   */
  @PostMapping("/order/new")
  public String createOrder(@Validated  @RequestBody  OrderVO orderVO){
    return "订单信息：" + orderVO.toString();
  }

}
