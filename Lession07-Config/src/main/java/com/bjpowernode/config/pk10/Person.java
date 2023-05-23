package com.bjpowernode.config.pk10;

/**
 * 作者：北京动力节点 wanghe
 * 使用xml，在启动类上使用@ImportResource
 */
public class Person {
  private String name;
  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
           "name='" + name + '\'' +
           ", age=" + age +
           '}';
  }
}
