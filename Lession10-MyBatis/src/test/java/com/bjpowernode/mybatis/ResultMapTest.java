package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.ArticleDao;
import com.bjpowernode.mybatis.po.ArticlePO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 作者：北京动力节点 wanghe
 */
@SpringBootTest
public class ResultMapTest {

  @Autowired
  private ArticleDao articleDao;

  @Test
  void test01() {
    ArticlePO articlePO = articleDao.selectById(1);
    System.out.println("articlePO = " + articlePO);
  }

  @Test
  void test02() {
    List<ArticlePO> list = articleDao.selectList(2101);
    list.forEach(po->{
      System.out.println("po = " + po);
    });
  }

}
