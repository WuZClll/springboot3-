package com.bjpowernode.config.pk7;

import com.bjpowernode.config.pk6.Security;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：北京动力节点 wanghe
 */
@Configuration
public class ApplicationConfig {

  //创建bean对象，属性值来自配置文件
  @ConfigurationProperties(prefix = "security")
  @Bean
  public Security createSecurity(){
    return new Security();
  }

}
