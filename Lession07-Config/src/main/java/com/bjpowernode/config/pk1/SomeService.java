package com.bjpowernode.config.pk1;

import java.util.StringJoiner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 动力节点 wanghe
 */
@Service
public class SomeService {

  //使用@Value("${key:默认值}")

  @Value("${app.name}")
  private String name;

 // @Value("${app.owner}")
  private String owner;

  @Value("${app.port:8008}")
  private Integer port;

  public void printValue(){
    StringJoiner joiner = new StringJoiner(";");
    joiner.add(name).add(owner).add(String.valueOf(port));

    String result = joiner.toString();
    System.out.println("result="+result);

  }
}
