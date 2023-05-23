package com.bjpowernode.pk4;

import org.junit.Test;

/**
 * @author 动力节点 wanghe
 */
public class TestSealed {

  @Test
  public void test01() {
    SomeService service = new SomeServiceImpl();
    service.doThing();

  }
}
