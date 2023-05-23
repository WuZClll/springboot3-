package com.bjpowernode.mybatis.po;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 * 作者：北京动力节点 wanghe
 */
@Data
public class ArticleEntity {
  private Integer id;
  private Integer userId;
  private String title;
  private String summary;
  private Integer readCount;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  //多个评论
  private List<CommentPO> comments;
}
