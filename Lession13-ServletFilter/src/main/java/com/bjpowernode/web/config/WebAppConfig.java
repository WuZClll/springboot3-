package com.bjpowernode.web.config;

import com.bjpowernode.web.filter.LogFilter;
import com.bjpowernode.web.filter.YuthFilter;
import com.bjpowernode.web.servlet.LoginServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * 作者：北京动力节点 wanghe
 */
@Configuration
public class WebAppConfig {

  @Bean
  public ServletRegistrationBean servletRegistrationBean(){
    //创建ServletRegistrationBean 登录一个或多个Servlet
    ServletRegistrationBean registrationBean = new ServletRegistrationBean();
    registrationBean.setServlet( new LoginServlet());
    registrationBean.addUrlMappings("/user/login");
    registrationBean.setLoadOnStartup(1);
    return registrationBean;
  }

/*  @Bean
  public FilterRegistrationBean filterRegistrationBean(){
    //登记Filter对象
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new LogFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    return filterRegistrationBean;
  }*/

  //登录Filter， 指定顺序
  @Bean
  public FilterRegistrationBean addLogFilter(){
    FilterRegistrationBean log = new FilterRegistrationBean();
    log.setFilter(new LogFilter());
    log.addUrlPatterns("/*");
    log.setOrder(2); //设置顺序
    return log;
  }

  @Bean
  public FilterRegistrationBean addAuthFilter(){
    FilterRegistrationBean auth = new FilterRegistrationBean();
    auth.setFilter(new YuthFilter());
    auth.addUrlPatterns("/*");
    auth.setOrder(1); //越小越先执行
    return auth;
  }

  //登记框架内置的Filter
  @Bean
  public FilterRegistrationBean addCommoneLogFilter(){
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();

    CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();
    //记录请求的uri地址
    commonsRequestLoggingFilter.setIncludeQueryString(true);

    registrationBean.setFilter(commonsRequestLoggingFilter);

    registrationBean.addUrlPatterns(("/*"));
    return registrationBean;

  }

}
