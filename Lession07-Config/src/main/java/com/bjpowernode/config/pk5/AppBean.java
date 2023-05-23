package com.bjpowernode.config.pk5;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  @ConfigurationProperties:表示使用Bean对象读取配置项
 *     prefix： 表示配置文件中多个key的公共开始部分。
 *              比如app.name, 这里app就前缀
 */
//@Component

//@Configuration表示是一个配置bean，创建普通bean，非spring代理，
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app")
public class AppBean {
  //key的名称与属性名相同，调用属性setXXX方法给属性赋值
  //非static属性
  private String name;
  private String owner;
  private Integer port;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  @Override
  public String toString() {
    return "AppBean{" +
           "name='" + name + '\'' +
           ", owner='" + owner + '\'' +
           ", port=" + port +
           '}';
  }
}
