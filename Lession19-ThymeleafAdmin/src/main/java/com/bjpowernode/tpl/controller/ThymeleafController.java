package com.bjpowernode.tpl.controller;

import com.bjpowernode.tpl.vo.UserVO;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 作者：北京动力节点
 */
@Controller
public class ThymeleafController {

  //表达式， 方法的返回值表示视图， 一个xxx.html页面
  @GetMapping("/expression")
  public String exp(Model model){
    //model中的数据，最后是放到request作用域的。 request.setAttribute("name", "动力节点IT培训");
    model.addAttribute("name", "动力节点IT培训");
    model.addAttribute("address","北京的大兴区");
    return "exp";//是一个视图 exp.html
  }

  //连接表达式
  @GetMapping("/link")
  public String link(Integer id,String name, Model model){
    model.addAttribute("id", id);
    model.addAttribute("myname", name);
    return "link";
  }

  //if ,for
  @GetMapping("/if-for")
  public String ifFor(Model model){
    model.addAttribute("login", true);
    UserVO user = new UserVO();
    user.setId(10);
    user.setName("李四");
    user.setAge(20);
    model.addAttribute("user", user);

    //创建List集合
    List<UserVO> users = Arrays.asList(
        new UserVO(11, "张三", 21),
        new UserVO(12, "周行", 22)
    );
    model.addAttribute("users",users);

    return "base";


  }

}
