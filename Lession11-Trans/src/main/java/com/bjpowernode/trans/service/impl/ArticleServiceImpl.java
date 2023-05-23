package com.bjpowernode.trans.service.impl;

import com.bjpowernode.trans.mapper.ArticleMapper;
import com.bjpowernode.trans.po.ArticleDetailPO;
import com.bjpowernode.trans.po.ArticlePO;
import com.bjpowernode.trans.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作者：北京动力节点 wanghe
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  //注入mapper
  @Autowired
  private ArticleMapper articleMapper;


  /**
   *   @Transactional：事务控制注解
   *     位置： 1. 方法的上面， 2.类的上面
   *
   *   事务回滚：
   *    1.默认对运行时异常，执行回滚rollback
   *    2.rollbackFor: 需要回滚的异常类列表
   */
  @Transactional
  @Override
  public boolean postNewArticle(ArticlePO article, String content) {

    //添加新的文章
    int rows = articleMapper.insertArticle(article);

    //抛出异常
    if( article.getReadCount() < 1){
      throw new RuntimeException("文章阅读数量最小是1");
    }

    //添加文章内容
    ArticleDetailPO detail = new ArticleDetailPO();
    detail.setArticleId(article.getId());
    detail.setContent(content);
    int detailRows  = articleMapper.insertDetail(detail);

    return (rows + detailRows) == 2 ? true : false;
  }

  @Override
  public boolean managerArticle(ArticlePO po, String content) {
    //调用具有事务的方法
    return postNewArticle(po,content);
  }

  @Transactional
  @Override
  public boolean postNewArticleThread(ArticlePO article, String content) {
    System.out.println("Start 父线程:"+Thread.currentThread().threadId());
    Thread thread = new Thread(()->{
      System.out.println("子线程："+ Thread.currentThread().threadId());
      //添加新的文章
      int rows = articleMapper.insertArticle(article);

      //抛出异常
      if( article.getReadCount() < 1){
        throw new RuntimeException("====文章阅读数量最小为1====");
      }
      //添加文章内容
      ArticleDetailPO detail = new ArticleDetailPO();
      detail.setArticleId(article.getId());
      detail.setContent(content);
      int detailRows  = articleMapper.insertDetail(detail);

    });

    thread.start();
    try{
      thread.join();//等待该线程执行完毕。当一个线程调用join()方法时，当前线程会被阻塞，直到被调用的线程执行完毕。如果调用join()方法的线程已经执行完毕，那么该方法会立即返回
    }catch (Exception e){
      e.printStackTrace();
    }
    System.out.println("End 父线程:"+Thread.currentThread().threadId());

    return true;
  }
}
