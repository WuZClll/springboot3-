package com.bjpowernode.config.pk2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author 动力节点 wanghe
 */
@Service
public class ReadConfig {

  //注入环境对象
  @Autowired
  private Environment environment;

  public  void print(){
    //获取某个key的值
    String name = environment.getProperty("app.name");

    //判断key是否存在
    if( environment.containsProperty("app.owner")){
      System.out.println("app.owner是存在的");
    }

    // 读取key的值，转为期望的类型， 同时提供默认值
    Integer port = environment.getProperty("app.port", Integer.class, 9001);

    String str = String.format("读取的key值，name=%s, port=%d", name, port);
    System.out.println("str = " + str);
  }
}
