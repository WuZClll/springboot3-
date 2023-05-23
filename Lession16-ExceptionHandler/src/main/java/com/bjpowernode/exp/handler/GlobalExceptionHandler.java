package com.bjpowernode.exp.handler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者：北京动力节点
 * 1.在类的上面加入@ControllerAdvice, @RestControllerAdvice
 *   灵活组合@ControllerAdvice 和 @ResponseBody
 * 2.在类中自定义方法，处理各种异常。
 *   方法定义同Controller类中的方法的定义
 */
//控制器增强，给Controller增加异常处理功能。 类似AOP的思想
//@ControllerAdvice
public class GlobalExceptionHandler {

  //定义方法处理 数学异常

  /**
   *@ExceptionHandler: 指定处理异常的方法
   *   位置：在方法的上面
   *   属性：是异常类的class数组 ，如果你的系统抛出的异常类型与@ExceptionHandler声明的相同，由当前方法处理异常
   */
/*  @ExceptionHandler( { ArithmeticException.class})
  public String handlerArtithmeticException(ArithmeticException e, Model model){
    String error = e.getMessage();
    model.addAttribute("error",error);
    return "exp"; //就是视图
  }*/

  @ExceptionHandler( { ArithmeticException.class})
  @ResponseBody
  public Map<String,String> handlerReturnDataException(ArithmeticException e){
    Map<String,String> error = new HashMap<>();
    error.put("msg", e.getMessage());
    error.put("tips", "被除数不能为0");
    return error;
  }

  //处理JSR303 验证参数的异常
//  @ExceptionHandler({ BindException.class})//BindException.class是父类，下面的是子类
  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseBody
  public Map<String,Object> handlerJSR303Exception(MethodArgumentNotValidException e){ //MethodArgumentNotValidException
    System.out.println("=========JSR303==========");
    Map<String,Object> map = new HashMap<>();
    BindingResult result = e.getBindingResult();
    if( result.hasErrors()){
      //获取错误的信息
      List<FieldError> errors = result.getFieldErrors();
      for (int i=0,len = errors.size(); i<len ;i++){
        FieldError field = errors.get(i);
        //field.getField()字段名
        map.put(i+"-"+field.getField(), field.getDefaultMessage());
      }
    }
    return map;

  }
}
