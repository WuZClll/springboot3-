package com.bjpowernode.config.pk3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 动力节点 wanghe
 */
@Service
public class MultiConfigService {

  @Value("${spring.redis.host}")
  private String redisHostName;

  @Value("${spring.datasource.url}")
  private String jdbcUrl;

  public void print(){
    System.out.println("redisHostName  , jdbcUrl = " + redisHostName + "," + jdbcUrl);
  }
}
