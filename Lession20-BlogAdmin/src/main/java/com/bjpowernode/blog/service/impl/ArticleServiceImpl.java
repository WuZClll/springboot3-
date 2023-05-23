package com.bjpowernode.blog.service.impl;

import com.bjpowernode.blog.mapper.ArticleMapper;
import com.bjpowernode.blog.model.dto.ArticleDTO;
import com.bjpowernode.blog.model.map.ArticleAndDetailMap;
import com.bjpowernode.blog.model.po.ArticleDetailPO;
import com.bjpowernode.blog.model.po.ArticlePO;
import com.bjpowernode.blog.service.ArticleService;
import com.bjpowernode.blog.settings.ArticleSettings;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 作者：北京动力节点
 */
@Service
@RequiredArgsConstructor//构造注入
public class ArticleServiceImpl implements ArticleService {

  //构造注入
  private final ArticleMapper articleMapper;
  private final ArticleSettings articleSettings;

  //构造注入 跟@RequiredArgsConstructor注解一样
 /* public ArticleServiceImpl(ArticleMapper articleMapper) {
    this.articleMapper = articleMapper;
  }*/

  @Override
  public List<ArticlePO> queryTopArticle() {
    Integer lowRead = articleSettings.getLowRead();
    Integer topRead = articleSettings.getTopRead();
    return articleMapper.topSortByReadCount(lowRead, topRead);
  }

  //发布文章（article ，article_detail）
  @Transactional(rollbackFor = Exception.class)
  @Override
  public boolean addArticle(ArticleDTO articleDTO) {
    //文章
    ArticlePO articlePO = new ArticlePO();
    articlePO.setTitle(articleDTO.getTitle());
    articlePO.setSummary(articleDTO.getSummary());
    articlePO.setCreateTime(LocalDateTime.now());
    articlePO.setUpdateTime(LocalDateTime.now());
    articlePO.setReadCount(new Random().nextInt(200));
    articlePO.setUserId(new Random().nextInt(5000));
    int addArticle = articleMapper.insertArticle(articlePO);

    //文章内容
    ArticleDetailPO articleDetailPO = new ArticleDetailPO();
    articleDetailPO.setArticleId(articlePO.getId());
    articleDetailPO.setContent(articleDTO.getContent());
    int addDetail = articleMapper.insertArticleDetail(articleDetailPO);

    return  (addArticle + addDetail) == 2 ? true: false;
  }

  @Override
  public ArticleDTO queryByArticleId(Integer id) {
    //文章属性，内容
    ArticleAndDetailMap mapper = articleMapper.selectArticleAndDetail(id);
    //转为DTO
    ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setTitle(mapper.getTitle());
    articleDTO.setContent(mapper.getContent());
    articleDTO.setSummary(mapper.getSummary());
    articleDTO.setId(mapper.getId());
    return articleDTO;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public boolean modifyArticle(ArticleDTO articleDTO) {

    //修改文章属性
    ArticlePO articlePO = new ArticlePO();
    articlePO.setTitle(articleDTO.getTitle());
    articlePO.setSummary(articleDTO.getSummary());
    articlePO.setUpdateTime(LocalDateTime.now());
    articlePO.setId(articleDTO.getId());
    int article = articleMapper.updateArticle(articlePO);

    //修改文章内容
    ArticleDetailPO articleDetailPO = new ArticleDetailPO();
    articleDetailPO.setArticleId(articleDTO.getId());
    articleDetailPO.setContent(articleDTO.getContent());
    int detail = articleMapper.updateArticleDetail(articleDetailPO);

    return (article + detail) == 2 ? true :false;
  }

  //删除文章属性， 内容
  @Transactional(rollbackFor = Exception.class)
  @Override
  public boolean removeArticle(List<Integer> idList) {
    int article = articleMapper.deleteArticle(idList);
    int detail = articleMapper.deleteDetail(idList);
    return article == detail ? true: false;
  }

  @Override
  public String queryTop20Content(Integer id) {
    ArticleDetailPO articleDetailPO = articleMapper.selectArticleDetailByArticleId(id);
    String content = "无内容";
    if( articleDetailPO != null ){
      content = articleDetailPO.getContent();
      if(StringUtils.hasText(content)){
        //content = content.substring(0, content.length() >= 20 ? 20 : content.length() );
        content = content.substring(0, 20 );
      }
    }
    return content;
  }
}
