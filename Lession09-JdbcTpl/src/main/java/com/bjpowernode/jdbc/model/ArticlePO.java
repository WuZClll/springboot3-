package com.bjpowernode.jdbc.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：北京动力节点 wanghe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePO {
  private Integer id;
  private Integer userId;
  private String title;
  private String summary;
  private Integer readCount;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
