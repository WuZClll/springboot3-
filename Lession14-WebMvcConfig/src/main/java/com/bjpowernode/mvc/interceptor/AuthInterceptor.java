package com.bjpowernode.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 作者：北京动力节点
 */
public class AuthInterceptor  implements HandlerInterceptor {

  private static  final  String COMMON_USER="zhangsan";
  //判断登录的用户 ，能否执行相应的动作
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("====AuthInterceptor权限拦截器======");
    //登录的用户
    String loginUser = request.getParameter("loginUser");
    //获取请求的uri地址
    String requestURI = request.getRequestURI();

    //判断用户和操作
    if( COMMON_USER.equals(loginUser) && (
        requestURI.startsWith("/article/add") ||
        requestURI.startsWith("/article/edit") ||
        requestURI.startsWith("/article/remove")
        )) {
      return false;
    }
    return true;
  }
}
