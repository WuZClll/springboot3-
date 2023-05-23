package com.bjpowernode.pk1;

/**
 * @author 动力节点 wanghe
 */
public class SomeService {
  //定义业务方法，判断年龄是否18
  public boolean isEligible(Object obj){
 /*   if( obj instanceof Person(String name,Integer age)){
      return age >= 18;
    }*/

   //判断当是 Record 类型时，继续判断 age 年龄是否满足 18 岁。
    if( obj instanceof Person(String name,Integer age) p){
      return p.age() >= 18;
    }
    return false;
  }

}
