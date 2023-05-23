package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.Person;
import com.bjpowernode.quickweb.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点 wanghe
 */
@RestController
public class ParameterController {

  //一一对应，适合接收简单类型数据String，int，long，double，float， 参数数量少，比如2,3
  //http://localhost:8080/p?name=lisi&age=20&sex=m
  @GetMapping("/param/p1")
  public String p1(String name,Integer age,String sex){
    if( name != null && name.length() > 1) {
      //...
    }
    if(age !=null && age >=0 && age < 200){
      //...
    }

    if( sex == "m" || sex=="f"){
      //..
    }
    return "接收参数：" + name+","+age+","+sex;
  }

  //使用对象接收参数， 要求对象的属性名称和请求中参数名一样， 属性有set方法，类有无参数构造方法
  @GetMapping("/param/p2")
  public String p2(Person person,String type){
    if(person.getName() != null ){
      //...
    }
    person.getSex();
    person.getAge();
    //xxxService(person.getName(), person.getSex())

    return "接收参数，使用对象："+person.toString()+",type="+type;
  }

  //使用HttpServletRequest接收参数
  @GetMapping("/param/p3")
  public String p3(HttpServletRequest request){
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String sex = request.getParameter("sex");
    return "name="+name+",age="+age+",sex="+sex;
  }

  //使用@RequestParam
  @GetMapping("/param/p4")
  public String p4(@RequestParam(value="name",required = true) String name,
      @RequestParam(value = "age",required = false,defaultValue = "26") Integer age){
    return "p4,name="+name+",age="+age;

  }

  //使用@RequestHeader
  @GetMapping("/param/p5")
  public String p5(@RequestParam(value="name",required = true) String name,
      @RequestParam(value = "age",required = false,defaultValue = "26") Integer age,
      @RequestHeader("Accept") String accept){
    return "p5,name="+name+",age="+age + "Accept:"+accept;

  }

  //使用@RequestBody接收json， post请求体数据
  /**
   * 前端数据： {"username":"lisi","age":20 }
   * @RequestBody：从请求体中读取json数据，将数据转为形参对象的属性值
   *               框架创建User对象，将username，age key的值赋值给两个同名的属性
   * 前端请求中需要指定：头 Content-Type: application/json
   */
  @PostMapping("/param/json")
  public String p6(@RequestBody User user){
    return "p6,json:"+user.toString();
  }

  //使用Reader ，InputStream 读取post请求体的数据
  @PostMapping("/param/json2")
  public String p6(Reader reader){
    StringBuffer content = new StringBuffer("");
    try(BufferedReader bin = new BufferedReader(reader)){
      var line = "";
      while ( (line = bin.readLine()) != null){
        content.append(line);
      }
    }catch (IOException e){
      e.printStackTrace();
    }
    return "p7, reader=" + content.toString();
  }

  //接收数组 多个值
  @GetMapping("/param/vals")
  public String getMulitVal(Integer [] id){
    List<Integer> ids = Arrays.stream(id).toList();
    return ids.toString();
  }

}
