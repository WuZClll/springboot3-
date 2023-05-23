package com.bjpowernode.blog.model.dto;

import lombok.Data;

/**
 * 作者：北京动力节点
 */
@Data
public class ArticleDTO {
  //userId...
  private Integer id;
  private String title;
  private String summary;
  private String content;
}
