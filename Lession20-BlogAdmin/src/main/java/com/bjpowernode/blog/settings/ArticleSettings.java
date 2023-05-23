package com.bjpowernode.blog.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 作者：北京动力节点
 */
@Data
@ConfigurationProperties(prefix = "article")
public class ArticleSettings {
  private Integer lowRead;
  private Integer topRead;
}
