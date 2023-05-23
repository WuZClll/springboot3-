package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.ArticleRepository;
import com.bjpowernode.mybatis.po.ArticlePO;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 作者：北京动力节点 wanghe
 */
@SpringBootTest
public class RepositoryTest {

  @Autowired
  private ArticleRepository dao;

  @Test
  void test01() {
    ArticlePO articlePO = dao.selectByPrimary(3);
    System.out.println("articlePO = " + articlePO);
  }


  @Test
  void test02() {
    dao.updateTime(3, LocalDateTime.now());
  }

  @Test
  void test03() {
    ArticlePO po = new ArticlePO();
    po.setTitle("Spring6");
    po.setSummary("Spring6全新课程");
    po.setUserId(29);
    po.setReadCount(0);
    po.setCreateTime(LocalDateTime.now());
    po.setUpdateTime(LocalDateTime.now());
    dao.insertArticle(po);
  }

  @Test
  void test04(){
    dao.deleteById(5);
  }
}
