package com.bjpowernode.blog.handler;

import com.bjpowernode.blog.handler.exp.IdTypeException;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 作者：北京动力节点
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  //处理JSR303
  @ExceptionHandler( { BindException.class})
  public String handlerBindException(BindException bindException, Model model){
    BindingResult bindingResult = bindException.getBindingResult();
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();//获取发生异常的字段和描述
    model.addAttribute("errors",fieldErrors);
    return "/blog/error/bind";
  }

  @ExceptionHandler({IdTypeException.class})
  public String handleIdTypeException(IdTypeException idTypeException,Model model){
    model.addAttribute("msg", idTypeException.getMessage());
    return "/blog/error/error";
  }

  @ExceptionHandler({Exception.class})
  public String handleDefalutException(Exception e,Model model){
    model.addAttribute("msg", "请稍后重试!");
    return "/blog/error/error";
  }

}
