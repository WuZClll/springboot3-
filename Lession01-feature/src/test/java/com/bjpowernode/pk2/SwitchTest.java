package com.bjpowernode.pk2;

import org.junit.Test;

/**
 * @author 动力节点 wanghe
 */
public class SwitchTest {

  @Test
  public void test01() {
    int week = 20;
    String memo = "";//表示计算结果

    switch (week) {
      case 1 -> memo = "星期日，休息";
      case 2,3,4,5,6 -> memo = "工作日";
      case 7  -> memo="星期六，休息";
      default -> throw new RuntimeException("无效的日期");
    }
    System.out.println("memo="+memo);

  }



  @Test
  public void test02() {
    int week = 17;
    //yield将值返回给memo
    String memo  = switch ( week ){
      case 1: yield "星期日";
      case 2,3,4,5,6 : yield "工作日";
      case 7 : yield "星期六";
      default: yield "无需星期";
    };

    System.out.println("memo = " + memo);

  }

  @Test
  public void test03() {

    int week = 1;
    String memo = switch (week){
      case  1 -> {
        System.out.println("星期日，执行了自定义代码");
        yield "星期日";
      }
      case 2,3,4,5,6 -> {
        System.out.println("工作日，执行了自定义代码");
        yield "2-6工作日";
      }
      case 7 ->{
        System.out.println("星期六，执行了自定义代码");
        yield "星期六";
      }
      default -> {
        System.out.println("执行了自定义代码");
        yield "其他日期";
      }
    };

    System.out.println("memo = " + memo);

  }

  @Test
  public void test04() {
    //创建对象
    Line line = new Line(10,20);
    Rectangle rectangle = new Rectangle(20,50);
    Shape shape = new Shape(50,80);

//    Object obj = new String();
    Object obj = rectangle;
    int result  = switch ( obj ){
      case Line(int x,int y) -> {
        System.out.println("图形是Line, x:"+x+",y:"+y);
        yield  x + y;
      }
      case Rectangle(int w,int h) -> 2 * (w + h);//可以直接返回
      case Shape(int x ,int y) ->{
        System.out.println("图形Shape");
        yield x * y;
      }
      default -> 0;
    };

    System.out.println("result = " + result);
  }
}
