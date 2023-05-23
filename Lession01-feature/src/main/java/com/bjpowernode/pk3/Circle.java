package com.bjpowernode.pk3;

/**
 * @author 动力节点 wanghe
 */
//用final声名代表这个继承到这儿就截止了，不能再被继承
public final class Circle extends Shape{

  @Override
  public void draw() {
    System.out.println("======图形Circle=======");
  }
}
