package com.bjpowernode.blog.service;

import com.bjpowernode.blog.model.dto.ArticleDTO;
import com.bjpowernode.blog.model.po.ArticlePO;
import java.util.List;

/**
 * 作者：北京动力节点
 */
public interface ArticleService {

  //获取首页文章列表
  List<ArticlePO> queryTopArticle();


  //发布文章（article ，article_detail）
  boolean addArticle(ArticleDTO articleDTO);

  //根据主键查询文章
  ArticleDTO queryByArticleId(Integer id);

  //修改文章属性和内容
  boolean modifyArticle(ArticleDTO articleDTO);

  //删除文章
  boolean removeArticle(List<Integer> idList);

  //查询文章内容前20个字符
  String queryTop20Content(Integer id);
}
