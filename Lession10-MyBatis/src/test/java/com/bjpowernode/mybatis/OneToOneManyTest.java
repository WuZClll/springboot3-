package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.ArticleCommentMapper;
import com.bjpowernode.mybatis.mapper.ArticleOneToOneMapper;
import com.bjpowernode.mybatis.po.Article;
import com.bjpowernode.mybatis.po.ArticleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 作者：北京动力节点 wanghe
 */
@SpringBootTest
public class OneToOneManyTest {

  @Autowired
  private ArticleOneToOneMapper oneMapper;

  @Autowired
  private ArticleCommentMapper commentMapper;

  @Test
  void testOneToOne() {
    Article article = oneMapper.selectAllArticle(1);
    System.out.println("article = " + article);
  }

  @Test
  void testOneToMany() {
    ArticleEntity articleEntity = commentMapper.selectArticleComment(1);
    System.out.println("articleEntity = " + articleEntity);
  }
}
