package com.bjpowernode.problem.exp;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

/**
 * 作者：北京动力节点
 */
//自定义异常类，让SpringMVC的异常处理器使用
  //#ProblemDetail需要在配置文件开启支付RFC7807
public class IsbnNotFoundException extends ErrorResponseException {

  public IsbnNotFoundException(HttpStatus httpStatus,String detail){
    super(httpStatus,createProblemDetail(httpStatus,detail),null);
  }

  private static ProblemDetail createProblemDetail(HttpStatus status,String detail) {
    //封装RFC7807 字段
    ProblemDetail problemDetail = ProblemDetail.forStatus(status);
    problemDetail.setType(URI.create("/api/probs/not-found"));
    problemDetail.setTitle("图书异常");
    problemDetail.setDetail(detail);
    //自定义字段
    problemDetail.setProperty("严重程度","低");
    problemDetail.setProperty("客户邮箱","service@bjpowernode.com");
    return problemDetail;
  }
}
