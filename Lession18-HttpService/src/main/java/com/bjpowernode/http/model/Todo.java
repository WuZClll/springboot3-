package com.bjpowernode.http.model;

import lombok.Data;

/**
 * 作者：北京动力节点
 */
@Data
public class Todo {

  private Integer userId;
  private Integer id;
  private String title;
  private Boolean completed;

}
