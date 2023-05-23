package com.bjpowernode.aop.service.impl;

import com.bjpowernode.aop.service.SomeService;
import org.springframework.stereotype.Service;

/**
 * 作者：北京动力节点 wanghe
 */
@Service
public class SomeServiceImpl implements SomeService {

  @Override
  public void query(Integer id) {
    System.out.println("=====SomeService的业务方法query====");
  }

  @Override
  public void save(String name, Integer age) {
    System.out.println("=====SomeService的业务方法save====");
  }
}
