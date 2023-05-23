package com.bjpowernode.pk3;

/**
 * @author 动力节点 wanghe
 * permits 限制可以继承的子类
 */
public sealed class Shape permits Circle, Square, Rectangle {
  private Integer width;
  private Integer height;

  public void draw(){
    System.out.println("画一个图形Shape");
  }

}
