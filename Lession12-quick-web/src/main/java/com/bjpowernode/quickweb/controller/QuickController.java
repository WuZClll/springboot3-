package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.RoleVO;
import com.bjpowernode.quickweb.vo.User;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 作者：北京动力节点 wanghe
 * @Controller:创建控制器对象，控制器能够接收请求，响应结果给浏览器
 *              控制器也叫做处理器
 */
@Controller
public class QuickController {

  //定义方法处理请求， 方法叫做控制器方法（处理器方法）
  //Model表示模型，存储数据。 这个数据最后是放在request作用域。
  //HttpServletRequest放在的作用域中
  @RequestMapping("/exam/quick")
  public String quick(Model model){

    //调用service，处理请求，获取数据
    model.addAttribute("title","Web开发");
    model.addAttribute("time", LocalDateTime.now());
    // request.setAttribute("title","Web开发");

    //指定视图，显示数据
    return "quick";//他是视图文件的名称

  }

  @GetMapping("/hello")
  public ModelAndView hello(){
    //ModelAndView 表示数据和视图
    ModelAndView mv = new ModelAndView();
    mv.addObject("name","李四");
    mv.addObject("age",20);
    mv.setViewName("hello");
    return mv;
  }

  @GetMapping("/json")
  @ResponseBody
  public User returnJson(){
    User user = new User();
    user.setUsername("zhangsan");
    user.setAge(20);

    RoleVO roleVO = new RoleVO();
    roleVO.setRoleName("管理员");
    roleVO.setMemo("具有较高的权限");
    roleVO.setId(11);
    user.setRoleVO(roleVO);
    return user;
  }

  /**
   * ResponseEntity 包含 HttpStatus Code 和 应答数据的结合体。 因为有 Http Code
   * 能表达标准的语义， 200 成功， 404 没有发现等。
   * @return
   */
  @GetMapping("/json3")
  @ResponseBody public ResponseEntity<User> returnEntity(){
    User user = new User();
    user.setUsername("zhangsan");
    user.setAge(20);

    RoleVO roleVO = new RoleVO();
    roleVO.setRoleName("管理员");
    roleVO.setMemo("具有较高的权限");
    roleVO.setId(11);
    user.setRoleVO(roleVO);

    ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    return response;

  }

  @GetMapping("/map")
  @ResponseBody public Map<String,Object> returnMap(){
    Map<String,Object> map = new HashMap<>();
    map.put("name","lisi");
    map.put("age", 20);
    return map;
  }

  //接收时间
  @GetMapping("/param/date")
  @ResponseBody public String paramDate(LocalDateTime date){
    return "时间："+date;
  }

}
