package com.bjpowernode.problem.handler;

import com.bjpowernode.problem.exp.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

/**
 * 作者：北京动力节点
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  //定义的ProblemDetail
  @ExceptionHandler( { BookNotFoundException.class})
  public ProblemDetail handlerBookNotFoundException(BookNotFoundException e){
    //ProblemDetail
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    //type：异常类型，是一个uri，uri找到解决问题的途径
    problemDetail.setType(URI.create("/api/probs/not-found"));
    problemDetail.setTitle("图书异常");

    //增加自定义的字段
    problemDetail.setProperty("时间", Instant.now());
    problemDetail.setProperty("客服", "services@bjpowernode.com");
    //....
    return problemDetail;

  }

  //返回ErrorResponse
/*  @ExceptionHandler( { BookNotFoundException.class})
  public ErrorResponse handlerException(BookNotFoundException e){
    ErrorResponse error = new ErrorResponseException(HttpStatus.NOT_FOUND, e );
    return error;
  }
*/
}
