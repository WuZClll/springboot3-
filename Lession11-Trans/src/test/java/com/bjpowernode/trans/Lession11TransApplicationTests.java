package com.bjpowernode.trans;

import com.bjpowernode.trans.po.ArticlePO;
import com.bjpowernode.trans.service.ArticleService;
import java.time.LocalDateTime;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession11TransApplicationTests {


  @Autowired
  private ArticleService articleService;

  @Test
  void testInsertArticle() {
    ArticlePO articlePO = new ArticlePO();
    articlePO.setUpdateTime(LocalDateTime.now());
    articlePO.setCreateTime(LocalDateTime.now());
    articlePO.setTitle("Spring事务管理");
    articlePO.setSummary("基于Spring的注解管理事务，进行事务控制");
    articlePO.setUserId(new Random().nextInt(500));
    articlePO.setReadCount(new Random().nextInt(1000));

    String content="基于Spring的注解管理事务，进行事务控制. 1.声明式；2.编程式";
    boolean add  = articleService.postNewArticle(articlePO, content);
    System.out.println("发布新的文章 = " + add);

  }

  @Test
  void testInsertArticleTrans() {
    ArticlePO articlePO = new ArticlePO();
    articlePO.setUpdateTime(LocalDateTime.now());
    articlePO.setCreateTime(LocalDateTime.now());
    articlePO.setTitle("Spring事务管理111");
    articlePO.setSummary("基于Spring的注解管理事务，进行事务控制");
    articlePO.setUserId(new Random().nextInt(500));
    articlePO.setReadCount(0);

    String content="1111基于Spring的注解管理事务，进行事务控制. 1.声明式；2.编程式";
    boolean add  = articleService.postNewArticle(articlePO, content);
    System.out.println("发布新的文章 = " + add);

  }


  @Test
  void testManagerArticleTrans() {
    ArticlePO articlePO = new ArticlePO();
    articlePO.setUpdateTime(LocalDateTime.now());
    articlePO.setCreateTime(LocalDateTime.now());
    articlePO.setTitle("===SpringMVC开发web应");
    articlePO.setSummary("===基于MVC架构的");
    articlePO.setUserId(new Random().nextInt(500));
    articlePO.setReadCount(0);

    //com.bjpowernode.trans.service.impl.ArticleServiceImpl$$SpringCGLIB$$0
    System.out.println(articleService.getClass().getName());
    String content="====Web开发使用SpringMVC";
    boolean add  = articleService.managerArticle(articlePO,content);
    System.out.println("发布新的文章 = " + add);

  }

  @Test
  void testManagerArticleTransThread() {
    ArticlePO articlePO = new ArticlePO();
    articlePO.setUpdateTime(LocalDateTime.now());
    articlePO.setCreateTime(LocalDateTime.now());
    articlePO.setTitle("Python开发web应");
    articlePO.setSummary("基于Python MVC架构的");
    articlePO.setUserId(new Random().nextInt(500));
    articlePO.setReadCount(0);


    String content="Python开发使用Python";
    boolean add  = articleService.postNewArticleThread(articlePO,content);
    System.out.println("发布新的文章 = " + add);

  }
}
