package com.bjpowernode.pk4;

/**
 * @author 动力节点 wanghe
 */
public sealed interface SomeService permits SomeServiceImpl, OrderService {

  void doThing();

}
