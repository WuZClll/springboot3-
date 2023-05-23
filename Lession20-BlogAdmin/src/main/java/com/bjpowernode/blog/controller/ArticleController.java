package com.bjpowernode.blog.controller;

import cn.hutool.core.bean.BeanUtil;
import com.bjpowernode.blog.fomatter.IdType;
import com.bjpowernode.blog.handler.exp.IdTypeException;
import com.bjpowernode.blog.model.dto.ArticleDTO;
import com.bjpowernode.blog.model.param.ArticleParam;
import com.bjpowernode.blog.model.po.ArticlePO;
import com.bjpowernode.blog.model.vo.ArticleVO;
import com.bjpowernode.blog.service.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者：北京动力节点
 */
@RequiredArgsConstructor//构造注入
@Controller
public class ArticleController {

  private final ArticleService articleService;

  @GetMapping(value = {"/", "/article/hot"})
  public String showHotArticle(Model model) {
    List<ArticlePO> articlePOList = articleService.queryTopArticle();
    //转为VO  .hutool工具类
    List<ArticleVO> articleVOList = BeanUtil.copyToList(articlePOList, ArticleVO.class);

    //添加数据
    model.addAttribute("articleList", articleVOList);

    //视图
    return "/blog/articleList";

  }

  //发布新文章
  @PostMapping("/article/add")
  public String addArticle(@Validated(ArticleParam.AddArticle.class) ArticleParam param) {
    //业务逻辑，调用service
    ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setContent(param.getContent());
    articleDTO.setSummary(param.getSummary());
    articleDTO.setTitle(param.getTitle());
    boolean add = articleService.addArticle(articleDTO);
    return "redirect:/article/hot";
  }

  //查询文章内容
  @GetMapping("/article/get")
  public String queryById(Integer id, Model model) {
    if (id != null && id > 0) {
      ArticleDTO articleDTO = articleService.queryByArticleId(id);
      //DTO-VO
      ArticleVO articleVO = BeanUtil.copyProperties(articleDTO, ArticleVO.class);
      //添加数据
      model.addAttribute("article", articleVO);
      //视图
      return "/blog/editArticle";
    } else {
      return "/blog/error/error";
    }

  }

  //更新文章
  @PostMapping("/article/edit")
  public String modifyArticle(@Validated(ArticleParam.EditArticle.class) ArticleParam param) {
    ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setId(param.getId());
    articleDTO.setTitle(param.getTitle());
    articleDTO.setSummary(param.getSummary());
    articleDTO.setContent(param.getContent());
    boolean edit = articleService.modifyArticle(articleDTO);
    return "redirect:/article/hot";
  }

  //删除文章  ids= 1,6,2
  //public String removeArticle(Integer ids[]){
  @PostMapping("/article/remove")
  public String removeArticle(@RequestParam("ids") IdType idType) {

    if (idType == null) {
      throw new IdTypeException("ID为空");
    }
    boolean delete = articleService.removeArticle(idType.getIdList());
    return "redirect:/article/hot";
  }

  @GetMapping("/article/deail/overview")
  @ResponseBody
  public String queryDetail(Integer id) {
    String top20Content="无ID";
    if( id != null && id > 0 ){
      top20Content = articleService.queryTop20Content(id);
    }
    return top20Content;
  }
}
