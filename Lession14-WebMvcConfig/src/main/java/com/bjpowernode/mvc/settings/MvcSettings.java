package com.bjpowernode.mvc.settings;

import com.bjpowernode.mvc.fomatter.DeviceFormatter;
import com.bjpowernode.mvc.interceptor.AuthInterceptor;
import com.bjpowernode.mvc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 作者：北京动力节点
 * SpringMVC配置： 使用JavaConfig的方式配置SpringMVC，代替原来的xml配置文件
 */
@Configuration
public class MvcSettings implements WebMvcConfigurer {

  //页面跳转控制器， 从请求直达视图页面（无需controller）
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    //配置页面控制：  addViewController("请求uri")， 指定他的视图setViewName(目标视图)
    registry.addViewController("/welcome").setViewName("index");
  }

  //转换器
  @Override
  public void addFormatters(FormatterRegistry registry) {
      registry.addFormatter(new DeviceFormatter());
  }

  //拦截器
  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    //权限拦截器
    AuthInterceptor authInterceptor  = new AuthInterceptor();
    registry.addInterceptor(authInterceptor)
        .order(2)
        .addPathPatterns("/article/**") //拦截以article开头的所有请求
        .excludePathPatterns("/article/query"); //不拦截的地址

    //登录拦截器
    LoginInterceptor loginInterceptor = new LoginInterceptor();
    registry.addInterceptor(loginInterceptor)
        .order(1) //顺序，整数值，越小先执行
        .addPathPatterns("/**") //拦截所有对controller的请求
        .excludePathPatterns("/article/query"); //排除
  }
}
