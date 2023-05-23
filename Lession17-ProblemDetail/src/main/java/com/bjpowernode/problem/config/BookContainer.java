package com.bjpowernode.problem.config;

import com.bjpowernode.problem.model.BookRecord;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 作者：北京动力节点
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "product")//配置文件属性的前缀
public class BookContainer {
  private List<BookRecord> books;
}
