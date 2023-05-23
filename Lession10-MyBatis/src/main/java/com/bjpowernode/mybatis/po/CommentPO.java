package com.bjpowernode.mybatis.po;

import lombok.Data;

/**
 * 作者：北京动力节点 wanghe
 * 评论
 */
@Data
public class CommentPO {
  private Integer id;
  private Integer articleId;
  private String content;
}
