package com.bjpowernode.problem;

import com.bjpowernode.problem.config.BookContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties配置类
@EnableConfigurationProperties({BookContainer.class})
@SpringBootApplication
public class Lession17ProblemDetailApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lession17ProblemDetailApplication.class, args);
  }

}
