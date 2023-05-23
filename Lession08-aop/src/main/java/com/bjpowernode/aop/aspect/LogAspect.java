package com.bjpowernode.aop.aspect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 作者：北京动力节点 wanghe
 */
@Component//将切面类对象注入到 spring 容器
@Aspect//说明当前类是切面类
public class LogAspect {

  //功能增加的方法
  //前置通知
  @Before("execution(* com.bjpowernode.aop.service..*.*(..))")
  public void sysLog(JoinPoint jp){
    StringJoiner log = new StringJoiner("|", "{","}");
    DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    log.add(formatter.format(LocalDateTime.now()));

    //当前执行的业务方法名称
    String methodName = jp.getSignature().getName();
    log.add(methodName);

    //方法的参数
    Object[] args = jp.getArgs();
    for(Object arg:args){
      log.add(arg == null ? "-" : arg.toString() );
    }

    System.out.println("日志："+log);

  }

}
