package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.ArticleMapper;
import com.bjpowernode.mybatis.po.ArticlePO;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 作者：北京动力节点 wanghe
 */
@SpringBootTest
public class MyBatisTest {

  @Autowired
  private ArticleMapper articleMapper;

  @Test
  void testSelect() {
    ArticlePO articlePO = articleMapper.selectById(1);
    System.out.println("articlePO = " + articlePO);
  }

  @Test
  void testInsert() {

    ArticlePO articlePO = new ArticlePO();
    articlePO.setTitle("TomcatWeb开发");
    articlePO.setSummary("使用Tomcat服务器，定制web应用");
    articlePO.setReadCount(19);
    articlePO.setUserId(new Random().nextInt(500));
    articlePO.setCreateTime(LocalDateTime.now());
    articlePO.setUpdateTime(LocalDateTime.now());

    int rows = articleMapper.insertArticle(articlePO);


  }


  @Test
  void testUpdateReadCount() {

    int rows  = articleMapper.updateReadCount(3,28);
    System.out.println("rows = " + rows);
  }

  @Test
  void testDelete() {
    int rows = articleMapper.deleteById(4);
    System.out.println("rows = " + rows);
  }
}
