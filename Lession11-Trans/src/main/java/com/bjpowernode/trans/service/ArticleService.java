package com.bjpowernode.trans.service;

import com.bjpowernode.trans.po.ArticlePO;

/**
 * 作者：北京动力节点 wanghe
 */
public interface ArticleService {

  //发布新的文章
  boolean postNewArticle(ArticlePO article,String content);

  //新增方法
  boolean managerArticle(ArticlePO po,String content);

  //发布新文章使用新线程Thread
  boolean postNewArticleThread(ArticlePO articlePO,String content);

}
