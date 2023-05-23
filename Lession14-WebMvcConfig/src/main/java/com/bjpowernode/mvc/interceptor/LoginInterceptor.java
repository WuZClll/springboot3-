package com.bjpowernode.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 作者：北京动力节点
 */
public class LoginInterceptor  implements HandlerInterceptor {

  private List<String> permitUser = new ArrayList<>();

  public LoginInterceptor() {
    this.permitUser = Arrays.asList("zhangsan","lisi","admin");
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("==========LoginInterceptor执行了==========");
    //获取登录的用户名称
    String loginUser = request.getParameter("loginUser");

    //只有三个用户能够访问系统
    if(StringUtils.hasText(loginUser) && permitUser.contains(loginUser)){
      return true;
    }
    return  false;
  }
}
