package com.bjpowernode.trans.po;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 作者：北京动力节点 wanghe
 */
@Data
public class ArticlePO {
  private Integer id;
  private Integer userId;
  private String title;
  private String summary;
  private Integer readCount;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
