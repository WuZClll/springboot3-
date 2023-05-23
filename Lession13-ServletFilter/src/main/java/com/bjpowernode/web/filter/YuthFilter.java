package com.bjpowernode.web.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 作者：北京动力节点
 */
//@WebFilter(urlPatterns = "/*")
public class YuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String uri = ((HttpServletRequest)request).getRequestURI().toString();
    System.out.println("=========YuthFilter 过滤器执行了，uri："+uri);
    chain.doFilter(request,response);
  }
}
