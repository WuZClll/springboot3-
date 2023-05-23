package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.ArticleVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：北京动力节点 wanghe
 */
@RestController
public class ArticleController {

  //发布新文章

  /**
   * @Validated : 验证Bean
   * BindingResult:包含Bean的验证结果
   */
  @PostMapping("/article/add")
  public Map<String,Object> addArticle(@Validated(ArticleVO.AddArticleGroup.class)  @RequestBody ArticleVO article, BindingResult br){

    //service方法处理文章的业务

    //返回结果数据
    Map<String,Object> map = new HashMap<>();
    if( br.hasErrors() ){
      List<FieldError> fieldErrors = br.getFieldErrors();
      for (int i=0,len = fieldErrors.size(); i<len ;i++){
        FieldError field = fieldErrors.get(i);
        map.put(i+"-"+field.getField(), field.getDefaultMessage());
      }
    }
    return map;
  }

  @PostMapping("/article/edit")
  public Map<String,Object> editArticle(@Validated(ArticleVO.EditArticleGroup.class)  @RequestBody ArticleVO article, BindingResult br){

    //service方法处理文章的业务

    //返回结果数据
    Map<String,Object> map = new HashMap<>();
    if( br.hasErrors() ){
      List<FieldError> fieldErrors = br.getFieldErrors();
      for (int i=0,len = fieldErrors.size(); i<len ;i++){
        FieldError field = fieldErrors.get(i);
        map.put(i+"-"+field.getField(), field.getDefaultMessage());
      }
    }
    return map;
  }
}
