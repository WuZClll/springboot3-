package com.bjpowernode.blog;

import com.bjpowernode.blog.settings.ArticleSettings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "com.bjpowernode.blog.mapper")
@EnableConfigurationProperties({ArticleSettings.class})//扫描@ConfigurationProperties(prefix = "article")配置注解
@SpringBootApplication
public class Lession20BlogAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lession20BlogAdminApplication.class, args);
  }

}
