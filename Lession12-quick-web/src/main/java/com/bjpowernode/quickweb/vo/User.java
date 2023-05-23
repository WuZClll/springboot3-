package com.bjpowernode.quickweb.vo;

import lombok.Data;

/**
 * 作者：北京动力节点 wanghe
 */
@Data
public class User {
  private String username;
  private Integer age;
  private RoleVO roleVO;

}
