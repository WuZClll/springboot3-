package com.bjpowernode.trans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//可选
@EnableTransactionManagement
@MapperScan(basePackages = "com.bjpowernode.trans.mapper")
@SpringBootApplication
public class Lession11TransApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lession11TransApplication.class, args);
  }

}
