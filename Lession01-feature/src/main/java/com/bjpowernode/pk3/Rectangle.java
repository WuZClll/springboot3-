package com.bjpowernode.pk3;

/**
 * @author 动力节点 wanghe
 */
//non-sealed 非密闭类，可以被继承，去掉了密闭类的特性
public non-sealed class Rectangle extends Shape{

  @Override
  public void draw() {
    System.out.println("===Rectangle====");
  }
}
