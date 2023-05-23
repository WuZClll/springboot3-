package com.bjpowernode.blog.settings;

import com.bjpowernode.blog.fomatter.IdTypeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 作者：北京动力节点
 */
@Configuration
public class MvcSettings  implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addFormatter(new IdTypeFormatter());
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/view/addArticle").setViewName("/blog/addArticle");
  }
}
